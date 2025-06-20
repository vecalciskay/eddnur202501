package nur.prog3.arboles;

public class NumeroIdentificable implements Identificable{

    private int numero;

    public NumeroIdentificable(int numero) {
        this.numero = numero;
    }

    @Override
    public String getId() {
        return String.valueOf(numero);
    }

    @Override
    public String toString() {
        return String.valueOf(numero);
    }
}
