package nur.prog3.diccionarios;


import java.util.Arrays;
import java.util.List;

public class DiccionarioTablaHash<TKEY, TVALUE> extends Diccionario<TKEY, TVALUE>{

    private DiccionarioLista<TKEY, TVALUE>[] tabla;
    private double factorCargaMaximo;
    private int capacidad;

    public DiccionarioTablaHash(){
        this(new ComparadorGenerico<>());
    }

    public DiccionarioTablaHash(Comparador<TKEY> comparador){
        super(comparador);
        this.factorCargaMaximo = 0.75; // Factor de carga por defecto
        this.capacidad = 11;
        this.tabla = new DiccionarioLista[capacidad];
    }

    @Override
    public void insertar(TKEY key, TVALUE value) {

        if (key == null || value == null) {
            throw new IllegalArgumentException("La clave y el valor no pueden ser nulos");
        }

        int index = getPosicionLlave(key, capacidad);

        DiccionarioLista<TKEY, TVALUE> lista = null;
        if (tabla[index] == null) {
            lista = new DiccionarioLista<>(comparador);
            tabla[index] = lista;
        }else{
            lista = tabla[index];
        }

        lista.insertar(key, value);
        size++;

        double factorCargaActual = (double) size / capacidad;
        // Verificar si es necesario redimensionar
        if (factorCargaActual > factorCargaMaximo) {
            redimensionar();
        }
    }

    private void redimensionar() {

        int nuevaCapacidad = capacidad * 2 + 1; // Aumentar la capacidad
        DiccionarioLista<TKEY, TVALUE>[] nuevaTabla =
                new DiccionarioLista[nuevaCapacidad];

        for (int i = 0; i < capacidad; i++) {
            if(tabla[i] == null) {
                continue;
            }
            DiccionarioLista<TKEY, TVALUE> lista = tabla[i];
            for (TKEY key : lista.llaves()) { // Asumiendo que DiccionarioLista tiene un método llaves()
                int nuevoIndex = getPosicionLlave(key, nuevaCapacidad);
                if (nuevaTabla[nuevoIndex] == null) {
                    nuevaTabla[nuevoIndex] = new DiccionarioLista<>(comparador);
                }
                TVALUE valor = lista.buscar(key); // Asumiendo que DiccionarioLista tiene un método buscar()
                nuevaTabla[nuevoIndex].insertar(key, valor); // Asumiendo que DiccionarioLista tiene un método buscar()
            }

        }

        this.tabla = nuevaTabla;
        this.capacidad = nuevaCapacidad;
    }

    @Override
    public TVALUE buscar(TKEY key) {
        int index = getPosicionLlave(key, capacidad);
        if (tabla[index] != null) {
            return tabla[index].buscar(key);
        }
        return null;
    }

    @Override
    public TVALUE eliminar(TKEY key) {
        int index = getPosicionLlave(key, capacidad);
        if (tabla[index] != null) {
            return tabla[index].eliminar(key);
        }
        return null;
    }

    @Override
    public boolean contiene(TKEY key) {

        int index = getPosicionLlave(key, capacidad);
        if (tabla[index] != null) {
            return tabla[index].contiene(key);
        }
        return false;
    }

    @Override
    public List<TKEY> llaves() {
        return Arrays.stream(tabla).filter(lista -> lista != null)
                .flatMap(lista -> lista.llaves().stream())
                .toList();
    }

    @Override
    public List<TVALUE> valores() {
        return Arrays.stream(tabla).filter(lista -> lista != null)
                .flatMap(lista -> lista.valores().stream())
                .toList();
    }

    private int getPosicionLlave(TKEY key, int capacidad) {
        int hashCode = comparador.hashCode(key);
        return (hashCode & 0x7FFFFFFF) % capacidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[\n\t");
        String separator = "";
        for (int i = 0; i < tabla.length; i++) {
            sb.append(separator);
            if (tabla[i] != null) {
                sb.append(tabla[i]);
            }else{
                sb.append("X");
            }
            separator = ",\n\t";
        }
        sb.append("\n]");

        return sb.toString();
    }
}
