package dquest.estructuras.grafo;

import java.util.ArrayList;

public class Mapa {
    private ArrayList<NodoMapa> nodos;

    public Mapa() {
        nodos = new ArrayList<>();
    }

    public void agregarNodo(String nombre, int x, int y) {
        nodos.add(new NodoMapa(nombre, x, y));
    }

    public void agregarConexion(String nombre1, String nombre2) {
        NodoMapa nodo1 = buscarNodo(nombre1);
        NodoMapa nodo2 = buscarNodo(nombre2);

        if (nodo1 != null && nodo2 != null) {
            nodo1.agregarAdyacente(nodo2);
            nodo2.agregarAdyacente(nodo1);
        }
    }

    public NodoMapa buscarNodo(String nombre) {
        for (NodoMapa nodo : nodos) {
            if (nodo.getNombre().equals(nombre)) {
                return nodo;
            }
        }
        return null;
    }

    public ArrayList<NodoMapa> obtenerNodos() {
        return nodos;
    }

    // ✅ Alias para que funcione con MainMapa.java sin modificarlo
    public void conectarNodos(String nombre1, String nombre2) {
        agregarConexion(nombre1, nombre2);
    }

    public NodoMapa buscarNodoPorNombre(String nombre) {
        return buscarNodo(nombre);
    }
}
