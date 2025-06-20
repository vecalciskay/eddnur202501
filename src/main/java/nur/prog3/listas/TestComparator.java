package nur.prog3.listas;

public class TestComparator {

    public static void main(String[] args) {
        PersonaNoComparable p1 = new PersonaNoComparable("Jorge", "Gonzales", "XYAZ1234");
        PersonaNoComparable p2 = new PersonaNoComparable("Jorge", "Fernandez", "ABCD1234");

        ComparadorPersonaNombre c1 = new ComparadorPersonaNombre();

        int comparacion = c1.compare(p1, p2);
        System.out.println("Comparación por nombre: " + comparacion);

        ComparadorPersonaApellido c2 = new ComparadorPersonaApellido();

        comparacion = c2.compare(p1, p2);

        System.out.println("Comparación por apellido: " + comparacion);
    }
}
