package dquest.estructuras.grafo;

import java.util.ArrayList;

public class NodoMapa {
    private String nombre;
    private int x, y;
    private ArrayList<NodoMapa> adyacentes;

    public NodoMapa(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.adyacentes = new ArrayList<>();
    }

    public void agregarAdyacente(NodoMapa nodo) {
        if (!adyacentes.contains(nodo)) {
            adyacentes.add(nodo);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<NodoMapa> getAdyacentes() {
        return adyacentes;
    }
}
