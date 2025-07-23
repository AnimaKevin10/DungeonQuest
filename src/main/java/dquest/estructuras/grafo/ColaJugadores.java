package dquest.estructuras.grafo;

public class ColaJugadores {
    private NodoColaJugador frente;
    private NodoColaJugador fin;

    public ColaJugadores() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(NodoColaJugador nodo) {
        if (frente == null) {
            frente = nodo;
            fin = nodo;
        } else {
            fin.setSiguiente(nodo);
            fin = nodo;
        }
    }

    public NodoColaJugador getFrente() {
        return frente;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    // Opcional: método para desencolar si lo necesitas
    public NodoColaJugador desencolar() {
        if (estaVacia()) return null;
        NodoColaJugador temp = frente;
        frente = frente.getSiguiente();
        if (frente == null) fin = null;
        return temp;
    }
}
