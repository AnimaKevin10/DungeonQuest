package dquest.juego;

import dquest.jugador.Jugador;
import dquest.estructuras.no_lineales.InventarioBST;
import dquest.jugador.Tesoro;
import dquest.ui.VentanaJuego;
import javax.swing.*;

public class Juego {
    private TurnoManager turnoManager;
    private VentanaJuego ventana;
    private Jugador[] jugadores;
    public Juego() {
        inicializarJugadores();      // Crea los jugadores
        turnoManager = new TurnoManager();
        turnoManager.iniciarTurnos(jugadores);  // Encola a los jugadores
        ventana = new VentanaJuego(this);  // Pasa referencia del juego a la ventana
        actualizarInterfaz();              // Muestra el jugador actual
    }
    private void inicializarJugadores() {
        jugadores = new Jugador[3];
        jugadores[0] = new Jugador("Kevin");
        jugadores[1] = new Jugador("Rosario");
        jugadores[2] = new Jugador("Víctor");
    }
    public Jugador getJugadorActual() {
        return turnoManager.obtenerJugadorActual();
    }
    public void pasarTurno() {
        turnoManager.avanzarTurno();
        actualizarInterfaz();
    }
    public void actualizarInterfaz() {
        Jugador actual = getJugadorActual();
        ventana.mostrarJugador(actual);
    }
    public void moverJugador() {
        JOptionPane.showMessageDialog(null, "Moviendo al jugador " + getJugadorActual().getNombre());
        // Aquí podrías usar lógica del mapa (de Persona 2)
        pasarTurno();
    }
    private Tesoro generarTesoroAleatorio() {
        String[] nombres = {"Espada", "Escudo", "Poción", "Llave", "Armadura"};
        int[] valores = {10, 15, 5, 1, 20};

        int i = (int) (Math.random() * nombres.length);
        return new Tesoro(nombres[i],valores[i]);
    }

    public void buscarTesoro() {
        Jugador actual = getJugadorActual();
        Tesoro tesoro = generarTesoroAleatorio(); // 🔥 aquí lo generas
        actual.getInventario().insertar(tesoro);
        JOptionPane.showMessageDialog(null, actual.getNombre() + " encontró un objeto: " + tesoro.getNombre());
        pasarTurno();
    }

    public void robarJugador() {
        JOptionPane.showMessageDialog(null, getJugadorActual().getNombre() + " intenta robar...");
        // Aquí deberías mostrar la ventana de robo (de Persona 3)
        pasarTurno();
    }
}

