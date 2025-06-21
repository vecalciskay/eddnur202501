package nur.prog3.arboles.ui;

import nur.prog3.arboles.Arbol;
import nur.prog3.arboles.NodoArbol;
import nur.prog3.arboles.NumeroIdentificable;

import java.awt.*;

public class DibujoArbol {

    private Arbol<NumeroIdentificable> arbol;

    private Graphics grafico;

    private static final int ESPACIO_VERTICAL = 90;
    private static final int ESPACIO_HORIZONTAL = 20;
    private static final int TAMANO_NODO = 50;

    public DibujoArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public void dibujar(Graphics g, int x, int y) {
        NodoArbol raiz = arbol.getRaiz();

        grafico = g;
        dibujarRecursivo(raiz, x, y);
    }

    private void dibujarRecursivo(NodoArbol<NumeroIdentificable> nodo, int x, int y) {
        int ancho = getAncho(nodo);

        int yHijo = y + ESPACIO_VERTICAL;
        int xHijo = x;
        int separador = ESPACIO_HORIZONTAL;
        for (NodoArbol<NumeroIdentificable> hijo: nodo.getHijos() ){
            int anchoHijo = getAncho(hijo);

            grafico.drawLine(x + ancho / 2 , y + TAMANO_NODO / 2,
                    xHijo + anchoHijo / 2, yHijo + TAMANO_NODO / 2);
            dibujarRecursivo(hijo, xHijo, yHijo);

            xHijo += (anchoHijo + separador);
        }

        dibujarNodo(nodo, x + ancho / 2 -  TAMANO_NODO / 2, y);
    }


    private int getAncho(NodoArbol<NumeroIdentificable> nodo) {
        if (nodo.getHijos().getTamano() == 0) {
            return TAMANO_NODO;
        }

        int anchoTotal = 0;
        int separador = 0;
        for (NodoArbol<NumeroIdentificable> hijo: nodo.getHijos()) {
            int anchoHijo = getAncho(hijo);
            anchoTotal += (separador + anchoHijo);
            separador = ESPACIO_HORIZONTAL;
        }

        return anchoTotal;
    }

    private void dibujarNodo(NodoArbol<NumeroIdentificable> nodo, int x, int y) {

//        nodo.setX(x + TAMANO_NODO / 2);
//        nodo.setY(y + TAMANO_NODO / 2);
//        nodo.setTamano(TAMANO_NODO/2);

        grafico.setColor(Color.white);
        grafico.fillArc(x, y, TAMANO_NODO, TAMANO_NODO, 0, 360);
        grafico.setColor(Color.black);
        grafico.drawArc(x, y, TAMANO_NODO, TAMANO_NODO, 0, 360);

        grafico.setFont(new Font("Arial", Font.PLAIN, 18));
        if (nodo.getValor().toString().length() > 1) {
            grafico.drawString(nodo.getValor().toString(), x + 4, y + 22);
        } else {
            grafico.drawString(nodo.getValor().toString(), x + 10, y + 22);
        }
    }
}
