package nur.prog3.listas;

public class BusquedaDicotomica {
    public static void main(String[] args) {
        ListaOrdenada<PersonaParaLista> lista = new ListaOrdenada<>();
        PersonaParaLista p = new PersonaParaLista(
                "Jorge","Gonzales", "9093809SC");
        lista.insertar(p);
        p = new PersonaParaLista(
                "Daniel","Morales", "9423889SC");
        lista.insertar(p);
        p = new PersonaParaLista(
                "Diego","Perez", "2393809SC");
        lista.insertar(p);
        p = new PersonaParaLista(
                "Hugo","Morales", "962189SC");
        lista.insertar(p);

        PersonaParaLista buscandoA = new PersonaParaLista("Diego","Perez","");

        PersonaParaLista encontrado = lista.buscar(buscandoA);

        System.out.println(encontrado);
    }
}
