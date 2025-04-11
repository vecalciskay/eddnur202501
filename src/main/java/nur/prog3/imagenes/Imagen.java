package nur.prog3.imagenes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * La forma en que un pixel toma u color es la siguiente
 * int color =  4 Bytes
 * 00000000 00000000 00000000 00000000
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
