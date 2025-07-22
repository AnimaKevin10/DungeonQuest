package dquest.estructuras.lineales;
import dquest.jugador.Tesoro;

public class NodoTesoro {
    Tesoro tesoro;
    NodoTesoro izquierdo;
    NodoTesoro derecho;

    public NodoTesoro(Tesoro tesoro) {
        this.tesoro = tesoro;
    }
}
