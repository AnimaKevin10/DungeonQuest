package dquest.ui;

import dquest.juego.Juego;
import dquest.jugador.Jugador;

import javax.swing.*;
import java.awt.*;

public class VentanaJuego extends JFrame {

    private Juego juego;//Referencia al controlador
    private JLabel etiquetaNombre;//Para mostrar el nombre del jugador
    private JLabel info;//Mensaje central
    private Jugador jugadorActual; //Guardamos el jugador que está en turno

    public VentanaJuego(Juego juego) {
        this.juego = juego;
        configurarVentana();
        crearComponentes();
        setVisible(true);
    }
    private void configurarVentana() {
        setTitle("Dungeon Quest - Juego");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));
    }
    private void crearComponentes() {
        // Panel superior nombres
        etiquetaNombre = new JLabel("Jugador: ");
        etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 18));
        add(etiquetaNombre, BorderLayout.NORTH);
        // Panel central mensajes
        info = new JLabel("¡Explora la mazmorra!", SwingConstants.CENTER);
        add(info, BorderLayout.CENTER);

        // Panel inferior acciones
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));

        JButton botonInventario = new JButton("Ver Inventario");
        JButton botonMover      = new JButton("Mover");
        JButton botonBuscar     = new JButton("Buscar Objeto");
        JButton botonRobar      = new JButton("Robar");
        JButton botonPasar      = new JButton("Pasar Turno");

        //inventario
        botonInventario.addActionListener(e -> {
            if (jugadorActual != null) {
                new VentanaInventario(jugadorActual);
            }
        });

        //Acciones que llaman a los métodos de Juego
        botonMover.addActionListener(e -> juego.moverJugador());
        botonBuscar.addActionListener(e -> juego.buscarTesoro());
        botonRobar.addActionListener(e -> juego.robarJugador());
        botonPasar.addActionListener(e -> juego.pasarTurno());

        panelBotones.add(botonMover);
        panelBotones.add(botonBuscar);
        panelBotones.add(botonRobar);
        panelBotones.add(botonPasar);
        panelBotones.add(botonInventario);

        add(panelBotones, BorderLayout.SOUTH);
    }

    public void mostrarJugador(Jugador jugador) {
        this.jugadorActual = jugador;
        etiquetaNombre.setText("Jugador: " + jugador.getNombre());
    }
}
