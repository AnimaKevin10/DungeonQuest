package dquest.estructuras.grafo;

public class NodoAdyacente {
    private NodoMapa nodo;
    public NodoAdyacente siguiente;

    public NodoAdyacente(NodoMapa nodo) {
        this.nodo = nodo;
        this.siguiente = null;
    }

    public NodoMapa getNodo() {
        return nodo;
    }
}

