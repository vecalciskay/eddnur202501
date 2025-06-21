package nur.prog3.diccionarios.main;

import nur.prog3.diccionarios.Comparador;

public class Persona {
    private String nombre;
    private String apellido;
    private String id;

    public Persona(String nombre, String apellido, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Persona p1 = new Persona("Jorge", "Gonzales", "9093809SC");
        Persona p2 = new Persona("Jorge", "Gonzales", "9093809SC");

        ComparadorPesona comparador = new ComparadorPesona();

        System.out.println("P1: " + comparador.hashCode(p1));
        System.out.println("P2: " + comparador.hashCode(p2));
        System.out.println("Son iguales? " + (comparador.equals(p1, p2)));

    }
}
