package nur.prog3.diccionarios;

class Nodo<TKEY, TVALUE> {
    private TKEY llave;
    private TVALUE valor;

    private Nodo<TKEY, TVALUE> anterior;
    private Nodo<TKEY, TVALUE> siguiente;

    public Nodo(TKEY llave, TVALUE valor) {
        this.llave = llave;
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }

    public TKEY getLlave() {
        return llave;
    }

    public void setLlave(TKEY llave) {
        this.llave = llave;
    }

    public TVALUE getValor() {
        return valor;
    }

    public void setValor(TVALUE valor) {
        this.valor = valor;
    }

    public Nodo<TKEY, TVALUE> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<TKEY, TVALUE> anterior) {
        this.anterior = anterior;
    }

    public Nodo<TKEY, TVALUE> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<TKEY, TVALUE> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "{" +llave + ": " + valor + '}';
    }
}
