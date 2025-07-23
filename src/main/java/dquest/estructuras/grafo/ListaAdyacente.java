package dquest.estructuras.grafo;

public class ListaAdyacente {
    private NodoAdyacente cabeza;

    public void agregarAdyacente(NodoMapa nodo) {
        NodoAdyacente nuevo = new NodoAdyacente(nodo);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public NodoAdyacente getCabeza() {
        return cabeza;
    }
}
