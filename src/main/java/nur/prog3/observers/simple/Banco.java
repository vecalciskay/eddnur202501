package nur.prog3.observers.simple;

public class Banco {
    public static void main(String[] args) {
        Cuenta c =  new Cuenta();
        OfertaComercial19Marzo oferta =
                new OfertaComercial19Marzo();
        c.addObserver(oferta);
        System.out.println(c);

        c.deposito(150);
        c.deposito(75);

        System.out.println(c);
    }
}
