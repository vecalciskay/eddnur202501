package nur.prog3.arboles;

public class PersonaParaArbol implements Identificable, Comparable<PersonaParaArbol> {
    private String nombre;
    private String apellido;
    private String dni;

    public PersonaParaArbol(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String getId() {
        return dni;
    }

    @Override
    public int compareTo(PersonaParaArbol o) {

        if(nombre.contains(o.nombre)){
            return 0;
        }
        return nombre.compareTo(o.nombre);
    }
}
