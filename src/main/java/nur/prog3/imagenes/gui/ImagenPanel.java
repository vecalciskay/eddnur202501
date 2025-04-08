package nur.prog3.imagenes.gui;

import nur.prog3.imagenes.Imagen;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ImagenPanel extends JPanel implements PropertyChangeListener {
    private Imagen modelo;

    public ImagenPanel(Imagen img) {
        modelo = img;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        modelo.dibujar(g, 0, 0);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
