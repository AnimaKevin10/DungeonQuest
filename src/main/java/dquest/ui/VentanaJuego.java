package dquest.ui;
import dquest.juego.Juego;
import dquest.jugador.Jugador;
import javax.swing.*;
import java.awt.*;

public class VentanaJuego extends JFrame {

    private Juego juego;  // Referencia al controlador del juego
    private JLabel etiquetaNombre;
    private JTextArea areaInventario;

    public VentanaJuego(Juego juego) {
        this.juego = juego;
        configurarVentana();
        crearComponentes();
        setVisible(true);
    }private void configurarVentana() {
        setTitle("Dungeon Quest - Juego");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
    private void crearComponentes() {
        // Panel superior
        etiquetaNombre = new JLabel("Jugador: ");
        etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 18));
        add(etiquetaNombre, BorderLayout.NORTH);

        // Panel central
        areaInventario = new JTextArea();
        areaInventario.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaInventario);
        add(scroll, BorderLayout.CENTER);

        // Panel inferior
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));
        JButton botonMover = new JButton("Mover");
        JButton botonBuscar = new JButton("Buscar Objeto");
        JButton botonRobar = new JButton("Robar");
        JButton botonPasar = new JButton("Pasar Turno");
        // Asignar acciones
        botonMover.addActionListener(e -> juego.moverJugador());
        botonBuscar.addActionListener(e -> juego.buscarTesoro());
        botonRobar.addActionListener(e -> juego.robarJugador());
        botonPasar.addActionListener(e -> juego.pasarTurno());
        panelBotones.add(botonMover);
        panelBotones.add(botonBuscar);
        panelBotones.add(botonRobar);
        panelBotones.add(botonPasar);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public void mostrarJugador(Jugador jugador) {
        etiquetaNombre.setText("Jugador: " + jugador.getNombre());
        areaInventario.setText("Inventario:\n" + jugador.getInventario().toString());
    }
}
