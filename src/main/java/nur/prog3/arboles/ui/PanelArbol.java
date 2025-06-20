package nur.prog3.arboles.ui;

import nur.prog3.arboles.Arbol;
import nur.prog3.arboles.NumeroIdentificable;

import javax.swing.*;
import java.awt.*;

public class PanelArbol extends JPanel {

    private Arbol<NumeroIdentificable> arbol;

    public PanelArbol(Arbol<NumeroIdentificable> arbol) {
        this.arbol = arbol;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (arbol != null) {
            DibujoArbol dibujo = new DibujoArbol(arbol);
            dibujo.dibujar(g, 0, 0);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(600,500);
    }


}
