package nur.prog3.listas;

import java.util.Comparator;

public class ComparadorPersonaApellido implements Comparator<PersonaNoComparable> {
    @Override
    public int compare(PersonaNoComparable o1, PersonaNoComparable o2) {
        return o1.getApellidos().compareTo(o2.getApellidos());
    }
}
