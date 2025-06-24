package nur.prog3.grafos;

public class Arista<E> {
    private NodoGrafo<E> destino;
    private int peso;

    public Arista(NodoGrafo<E> destino, int w) {
        this.destino = destino;
        peso = w;
    }

    public NodoGrafo<E> getDestino() {
        return destino;
    }

    public void setDestino(NodoGrafo<E> destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "---" + peso + "---" + destino.getId();
    }
}
