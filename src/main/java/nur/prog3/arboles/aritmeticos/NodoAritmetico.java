package nur.prog3.arboles.aritmeticos;

public class NodoAritmetico {
    private NodoAritmetico izquierda;
    private NodoAritmetico derecha;
    private SimboloAritmetico contenido;

    public NodoAritmetico(SimboloAritmetico c) {
        contenido = c;
        izquierda = null;
        derecha = null;
    }

    public NodoAritmetico(String expresion) {
        expresion = expresion.trim();
        NodoAritmetico nodo = construirDesde(expresion);
        this.contenido = nodo.contenido;
        this.izquierda = nodo.izquierda;
        this.derecha = nodo.derecha;
    }

    private NodoAritmetico construirDesde(String expr) {
        expr = expr.trim();

        // Elimina paréntesis envolventes innecesarios
        if (expr.startsWith("(") && expr.endsWith(")") &&
                paréntesisBalanceados(expr.substring(1, expr.length() - 1))) {
            expr = expr.substring(1, expr.length() - 1).trim();
        }

        // Recorremos la expresión para encontrar el operador principal (fuera de paréntesis)
        int nivelParentesis = 0;
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (c == ')') nivelParentesis++;
            else if (c == '(') nivelParentesis--;
            else if (nivelParentesis == 0 && (c == '+' || c == '-')) {
                // operador de menor precedencia encontrado
                return crearNodoOperador(expr, i);
            }
        }
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (c == ')') nivelParentesis++;
            else if (c == '(') nivelParentesis--;
            else if (nivelParentesis == 0 && (c == '*' || c == '/')) {
                return crearNodoOperador(expr, i);
            }
        }

        // Si no encontramos operador, debe ser un número
        return new NodoAritmetico(new Numero(Double.parseDouble(expr)));
    }

    private boolean paréntesisBalanceados(String expr) {
        int count = 0;
        for (char c : expr.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }


    private NodoAritmetico crearNodoOperador(String expr, int index) {
        char operador = expr.charAt(index);
        String izquierda = expr.substring(0, index);
        String derecha = expr.substring(index + 1);
        Operador op = new Operador(String.valueOf(operador));
        NodoAritmetico nodo = new NodoAritmetico(op);
        nodo.setIzquierda(construirDesde(izquierda));
        nodo.setDerecha(construirDesde(derecha));
        return nodo;
    }

    public NodoAritmetico getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAritmetico izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAritmetico getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAritmetico derecha) {
        this.derecha = derecha;
    }

    public SimboloAritmetico getContenido() {
        return contenido;
    }

    public void setContenido(SimboloAritmetico contenido) {
        this.contenido = contenido;
    }

    public Numero evaluar() {
        if (derecha == null && izquierda == null)
            return (Numero)contenido;

        Numero izq = izquierda.evaluar();
        Numero der = derecha.evaluar();
        Operador op = (Operador)contenido;
        Numero resultado = op.evaluar(izq,der);

        return resultado;
    }

    @Override
    public String toString() {
        if (derecha == null && izquierda == null) {
            return contenido.toString();
        }

        String izq = izquierda.toString();
        String der = derecha.toString();

        return "(" + izq + " " + contenido.toString() + " " + der + ")";
    }
}
