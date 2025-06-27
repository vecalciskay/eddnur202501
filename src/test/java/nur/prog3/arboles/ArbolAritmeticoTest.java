package nur.prog3.arboles;

import nur.prog3.arboles.aritmeticos.ArbolAritmetico;
import nur.prog3.arboles.aritmeticos.NodoAritmetico;
import nur.prog3.arboles.aritmeticos.Numero;
import nur.prog3.arboles.aritmeticos.Operador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArbolAritmeticoTest {
    @Test
    void imprimirArbolAritmeticoSimple() {

        // Arrange
        //---------------------------
        ArbolAritmetico a = new ArbolAritmetico();
        // 4 * 8
        NodoAritmetico izq = new NodoAritmetico(new Numero(4));
        NodoAritmetico der = new NodoAritmetico(new Numero(8));
        NodoAritmetico r = new NodoAritmetico(new Operador("*"));

        r.setIzquierda(izq);
        r.setDerecha(der);
        a.setRaiz(r);

        // Act
        String resultado = a.toString();

        // Assert
        String esperado = "(4.0 * 8.0)";
        assertEquals(esperado, resultado);
    }

    @Test
    void imprimirArbolAritmeticoDosOperaciones() {

        // Arrange
        //---------------------------
        ArbolAritmetico a = new ArbolAritmetico();
        // 3 + (4 * 8)
        NodoAritmetico izq = new NodoAritmetico(new Numero(4));
        NodoAritmetico der = new NodoAritmetico(new Numero(8));
        NodoAritmetico r = new NodoAritmetico(new Operador("*"));
        r.setIzquierda(izq);
        r.setDerecha(der);

        izq = new NodoAritmetico(new Numero(3));
        der = r;
        r = new NodoAritmetico(new Operador("+"));
        r.setIzquierda(izq);
        r.setDerecha(der);

        a.setRaiz(r);

        // Act
        String resultado = a.toString();

        // Assert
        String esperado = "(3.0 + (4.0 * 8.0))";
        assertEquals(esperado, resultado);
    }

    @Test
    void evaluarArbolAritmeticoSimple() {

        // Arrange
        //---------------------------
        ArbolAritmetico a = new ArbolAritmetico();
        // 4 * 8
        NodoAritmetico izq = new NodoAritmetico(new Numero(4));
        NodoAritmetico der = new NodoAritmetico(new Numero(8));
        NodoAritmetico r = new NodoAritmetico(new Operador("*"));

        r.setIzquierda(izq);
        r.setDerecha(der);
        a.setRaiz(r);

        // Act
        Numero resultado = a.evaluar();
        double valor = resultado.getValor();

        // Assert
        double esperado = 32.0;
        assertEquals(esperado, valor);
    }

    @Test
    void evaluarArbolAritmeticoDosOperaciones() {

        // Arrange
        //---------------------------
        ArbolAritmetico a = new ArbolAritmetico();
        // 3 + (4 * 8)
        NodoAritmetico izq = new NodoAritmetico(new Numero(4));
        NodoAritmetico der = new NodoAritmetico(new Numero(8));
        NodoAritmetico r = new NodoAritmetico(new Operador("*"));
        r.setIzquierda(izq);
        r.setDerecha(der);

        izq = new NodoAritmetico(new Numero(3));
        der = r;
        r = new NodoAritmetico(new Operador("+"));
        r.setIzquierda(izq);
        r.setDerecha(der);

        a.setRaiz(r);

        // Act
        Numero resultado = a.evaluar();
        double valor = resultado.getValor();

        // Assert
        double esperado = 35.0;
        assertEquals(esperado, valor);
    }

    @Test
    void construirYEvaluarArbolSimple() {
        // Arrange
        ArbolAritmetico a = new ArbolAritmetico("  (4.0  *  8       ) ");

        // Act
        Numero resultado = a.evaluar();
        double valor = resultado.getValor();

        // Assert
        double esperado = 32.0;
        assertEquals(esperado, valor);
    }

    @Test
    void construirYEvaluarArbolDosOperaciones() {
        // Arrange
        ArbolAritmetico a = new ArbolAritmetico(" 3 +  (4.0  *  8       ) ");

        // Act
        Numero resultado = a.evaluar();
        double valor = resultado.getValor();

        // Assert
        double esperado = 35.0;
        assertEquals(esperado, valor);
    }
}
