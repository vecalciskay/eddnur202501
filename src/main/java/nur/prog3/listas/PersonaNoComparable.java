package nur.prog3.listas;

public class PersonaNoComparable {
    private String nombres;
    private String apellidos;
    private String ci;

    public PersonaNoComparable(String nombres, String apellidos, String ci) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @Override
    public String toString() {
        return apellidos + ", " + nombres + " (" + ci + ")";
    }
}
