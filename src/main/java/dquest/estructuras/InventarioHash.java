package dquest.estructuras;

public class InventarioHash {

    private final int capacidad;
    private final ListaTesoro[] tabla;

    public InventarioHash(int capacidad) {
        this.capacidad = capacidad;
        tabla = new ListaTesoro[capacidad];

        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new ListaTesoro();
        }
    }