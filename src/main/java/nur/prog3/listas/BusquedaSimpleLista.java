package nur.prog3.listas;

public class BusquedaSimpleLista {
    public static void main(String[] args) {
        Lista<PersonaParaLista> lista = new Lista<>();
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

        // Buscar a la persona con CI 9423889SC
        PersonaParaLista obj = null;
        for(PersonaParaLista i : lista) {
            if(i.getCi().equals("9423889SC")) {
                obj = i;
            }
        }

        if (obj == null) {
            System.out.println("No encontro el carnet 9423889SC");
        } else {
            System.out.println(obj);
        }
    }
}
