package dquest.ui;

import dquest.estructuras.grafo.*;
import dquest.jugador.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.util.HashMap;

public class PanelMapa extends JPanel {
    private Mapa mapa;
    private ColaJugadores jugadores;
    private HashMap<String, Image> imagenesNodos;
    private String nodoHover = null;

    public PanelMapa(Mapa mapa, ColaJugadores jugadores) {
        this.mapa = mapa;
        this.jugadores = jugadores;
        this.imagenesNodos = new HashMap<>();
        setBackground(Color.BLACK);
        cargarImagenes();

        // Detectar si el cursor está sobre un nodo
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                nodoHover = null;
                for (NodoMapa nodo : mapa.obtenerNodos()) {
                    int dx = e.getX() - nodo.getX();
                    int dy = e.getY() - nodo.getY();
                    if (Math.sqrt(dx * dx + dy * dy) < 30) {
                        nodoHover = nodo.getNombre();
                        break;
                    }
                }
                repaint();
            }
        });
    }

    private void cargarImagenes() {
        imagenesNodos.put("Aldea", cargarImagen("aldea.png"));
        imagenesNodos.put("Bosque", cargarImagen("bosque.png"));
        imagenesNodos.put("Cueva", cargarImagen("cueva.png"));
        imagenesNodos.put("Ruinas", cargarImagen("ruinas.png"));
        imagenesNodos.put("Calaveras", cargarImagen("calaveras.png"));
        imagenesNodos.put("Templo", cargarImagen("templo.png"));
    }

    private Image cargarImagen(String nombreArchivo) {
        URL location = getClass().getResource(nombreArchivo);
        if (location == null) {
            System.err.println("❌ No se encontró la imagen: " + nombreArchivo);
            return null;
        }
        return new ImageIcon(location).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar conexiones
        g.setColor(Color.WHITE);
        for (NodoMapa nodo : mapa.obtenerNodos()) {
            for (NodoMapa ady : nodo.getAdyacentes()) {
                g.drawLine(nodo.getX(), nodo.getY(), ady.getX(), ady.getY());
            }
        }

        // Dibujar nodos con imagen
        for (NodoMapa nodo : mapa.obtenerNodos()) {
            Image img = imagenesNodos.get(nodo.getNombre());
            if (img != null) {
                g.drawImage(img, nodo.getX() - 25, nodo.getY() - 25, 50, 50, this);
            } else {
                g.setColor(Color.GRAY);
                g.fillOval(nodo.getX() - 25, nodo.getY() - 25, 50, 50);
            }

            // Mostrar nombre si está en hover
            if (nodoHover != null && nodoHover.equals(nodo.getNombre())) {
                g.setColor(Color.YELLOW);
                g.drawString(nodo.getNombre(), nodo.getX() - 15, nodo.getY() - 30);
            }
        }

        // Dibujar jugadores como círculos de colores
        g.setColor(Color.CYAN);
        NodoColaJugador actual = jugadores.getFrente(); // ✅ corrección aquí
        while (actual != null) {
            Jugador jugador = actual.getJugador();
            int x = jugador.getPosicionX();
            int y = jugador.getPosicionY();

            g.setColor(Color.MAGENTA);
            g.fillOval(x - 10, y - 10, 20, 20);
            g.setColor(Color.WHITE);
            g.drawString(jugador.getNombre(), x - 15, y - 15);

            actual = actual.getSiguiente();
        }
    }
}

