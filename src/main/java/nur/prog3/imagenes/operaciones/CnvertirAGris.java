package nur.prog3.imagenes.operaciones;

import nur.prog3.imagenes.Imagen;

import java.awt.image.BufferedImage;

public class CnvertirAGris extends ComandoImagen {

    public CnvertirAGris(Imagen img) {
        imagen = img;
    }

    @Override
    public void ejecutar() {
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                // Si r=50, g= 80, b= 200
                // x
                // r = x, g=x, b= x
                int r = (0x00FF0000 & imagen.get(i,j)) >> 16;
                int g = (0x0000FF00 & imagen.get(i,j)) >> 8;
                int b = (0x000000FF & imagen.get(i,j));

                int x = (r+g+b) / 3;
                imagen.set(i,j, x | (x << 8) | (x << 16));
            }
        }
        imagen.notificarCambios();
    }
}
