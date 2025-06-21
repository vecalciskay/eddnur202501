package nur.prog3.basededatos.model;

public class Persona {

    private int id;
    private String nombreCompleto;
    private int edad;

    public Persona() {}

    public Persona(int id, String nombreCompleto, int edad) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    public Persona(String nombreCompleto, int edad) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", edad=" + edad +
                '}';
    }
}
