package dquest.estructuras.lineales;
import dquest.jugador.Jugador;

public class ColaJugadores {
    private NodoColaJugador frente;
    private NodoColaJugador fin;

    public ColaJugadores() {
        frente = null;
        fin = null;
    }

    // nuevo jugador a la cola
    public void encolar(Jugador jugador) {
        NodoColaJugador nuevo = new NodoColaJugador(jugador);
        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
            fin.setSiguiente(frente); // cola circular (turnos)
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(frente);
        }
    }
    //Pasa al siguiente jugador
    public void avanzarTurno() {
        if (frente != null) {
            frente = frente.getSiguiente();
            fin = fin.getSiguiente();
        }
    }
    //Obtener el jugador en turno
    public Jugador obtenerJugadorActual() {
        if (frente != null) {
            return frente.getJugador();
        }
        return null;
    }
    //Booleano para ver si el frente esta bacio
    public boolean estaVacia() {
        return frente == null;
    }
    // Imprime la cola (para pruebas)
    public void imprimirCola(int cantidad) {
        NodoColaJugador actual = frente;
        int count = 0;
        while (actual != null && count < cantidad) {
            System.out.println("Jugador: " + actual.getJugador().getNombre());
            actual = actual.getSiguiente();
            count++;
        }
    }
}
