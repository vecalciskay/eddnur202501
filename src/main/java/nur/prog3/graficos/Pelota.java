package nur.prog3.graficos;

import java.beans.PropertyChangeSupport;

public class Pelota {
    private PropertyChangeSupport observado;
    private int x;
    private int y;
    public Pelota() {
        observado = new PropertyChangeSupport(this);
    }

    public void setPosicion(int nuevoX, int nuevoY) {
        x = nuevoX;
        y = nuevoY;
        observado.firePropertyChange("POSICION",
                false, true);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addObserver(PanelSimple panel) {
        observado.addPropertyChangeListener(panel);
    }
}
