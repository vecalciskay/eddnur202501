package nur.prog3.arboles.aritmeticos;

public class ArbolAritmetico {
    private NodoAritmetico raiz;

    public ArbolAritmetico() {
        raiz= null;
    }

    public ArbolAritmetico(String expresion) {
        raiz = new NodoAritmetico(expresion);
    }

    public NodoAritmetico getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAritmetico raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        if (raiz == null)
            return "[VACIO]";
        return raiz.toString();
    }

    public Numero evaluar() {
        if (raiz == null)
            return new Numero(0);
        return raiz.evaluar();
    }
}
