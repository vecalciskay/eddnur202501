package nur.prog3.arboles.aritmeticos;

public class Numero extends SimboloAritmetico {
    private double valor;

    public Numero(double v) {
        valor = v;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
