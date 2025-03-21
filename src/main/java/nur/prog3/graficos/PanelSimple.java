package nur.prog3.graficos;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanelSimple extends JPanel
        implements PropertyChangeListener {
    private Pelota modelo;
    public PanelSimple(Pelota m) {
        modelo = m;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillOval(modelo.getX(), modelo.getY(), 40, 40);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
