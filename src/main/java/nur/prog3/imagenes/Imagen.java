package nur.prog3.imagenes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * La forma en que un pixel toma u color es la siguiente
 * <ul>
 *     <li>int color =  4 Bytes</li>
 *     <li>00000000 00000000 00000000 00000000</li>
 * </ul>
 *
 * Por ejemplo: 255
 * 00000000 00000000 00000000 11111111
 * 00        00         00     FF
 * Esto representa el color AZUL
 *
 * Para representar el color verde
 * 00000000 00000000 11111111 00000000
 *
 * Para representar el color rojo (16711680)
 * 00000000 11111111 00000000 00000000
 * */
public class Imagen {
    private String ruta;
    private int alto;
    private int ancho;
    private int[][] pixeles;
    private PropertyChangeSupport observado;

    /**
     * Constructor de imagen vacia con un ancho y un alto
     * @param w Este es el ancho de la imagen
     * @param h Este es el alto de la imagen
     */
    public Imagen(int w, int h) {
        ancho = w;
        alto = h;
        pixeles = new int[w][h];
        observado = new PropertyChangeSupport(this);
    }

    public void addObservador(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int[][] getPixeles() {
        return pixeles;
    }

    public void setPixeles(int[][] pixeles) {
        this.pixeles = pixeles;
    }

    public void pintarFranjaRoja(int altoFranja, int y0) {
        // Rojo: R=255, G=0, B=0
        for (int i = 0; i < ancho; i++) {
            for (int j = y0; j < (y0 + altoFranja); j++) {
                int verde = 255;
                // 0x0000ff00 = 0000000 0000000 11111111 00000000
                // verde << 8 = 0000000 0110000 10100111 00010000
                //              0000000 0000000 10100111 00000000
                pixeles[i][j] = 0x0000FF00 & (verde << 8);
            }
        }
        observado.firePropertyChange("IMAGEN", true, false);
    }

    public void pintarFranja(int altoFranja, int y0, int r, int g, int b) {
        // Rojo: R=255, G=0, B=0
        for (int i = 0; i < ancho; i++) {
            for (int j = y0; j < (y0 + altoFranja); j++) {
                pixeles[i][j] = (r << 16) | (g << 8) | b;
            }
        }
        observado.firePropertyChange("IMAGEN", true, false);
    }

    public void dibujar(Graphics g, int x0, int y0) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Color c = new Color(pixeles[i][j]);
                g.setColor(c);
                g.drawLine(i,j,i,j);
            }
        }
    }

    public void setImage(BufferedImage image) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixeles[i][j] = image.getRGB(i,j);
            }
        }
        observado.firePropertyChange("IMAGEN", true, false);
    }

    public byte[] getBytes() {
        BufferedImage bi = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = (WritableRaster)bi.getRaster();
        int[] rasterPixels = transformarPuntos();
        raster.setPixels(0, 0, ancho, alto, rasterPixels);
        byte[] result;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(bi, "png", baos);
            baos.flush();
            result = baos.toByteArray();
        }
        catch (IOException e) {
            throw new UncheckedIOException("No se pudo codificar la imagen", e);
        }
        return result;
    }

    private int[] transformarPuntos() {
        int[] raster = new int[3*ancho*alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int r = (0x00FF0000 & pixeles[i][j]) >> 16;
                int g = (0x0000FF00 & pixeles[i][j]) >> 8;
                int b = (0x000000FF & pixeles[i][j]);

                int base = 3*(j*ancho + i);
                raster[base] = r;
                raster[base +1] = g;
                raster[base +2] = b;
            }
        }
        return raster;
    }

    public void notificarCambios() {
        observado.firePropertyChange("IMAGEN", true, false);
    }

    public int get(int i, int j) {
        return pixeles[i][j];
    }

    public void set(int x, int y, int color) {
        pixeles[x][y] = color;
    }
}
