package nur.prog3.listas;

public class PersonaParaLista implements Comparable<PersonaParaLista> {
    private String nombres;
    private String apellidos;
    private String ci;

    public PersonaParaLista(String nombres, String apellidos, String ci) {
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

    @Override
    public int compareTo(PersonaParaLista o) {
        if (apellidos.compareTo(o.getApellidos()) < 0)
            return -1;
        if (apellidos.compareTo(o.getApellidos()) > 0)
            return 1;
        // apellidos iguales
        if (nombres.compareTo(o.getNombres()) < 0)
            return -1;
        if (nombres.compareTo(o.getNombres()) > 0)
            return 1;
        return 0;
        // nombres y apellidos iguales, compara ci
        //return ci.compareTo(o.getCi());
    }


}
