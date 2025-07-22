package dquest.estructuras.no_lineales;
import dquest.jugador.Tesoro;

public class NodoTesoro {
    Tesoro tesoro;
    NodoTesoro izquierdo;
    NodoTesoro derecho;

    public NodoTesoro(Tesoro tesoro) {
        this.tesoro = tesoro;
    }
}
