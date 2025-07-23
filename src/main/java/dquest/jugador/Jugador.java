package dquest.jugador;
import dquest.estructuras.no_lineales.InventarioBST;

public class Jugador {
    private String nombre;
    private int posicionX;
    private int posicionY;
    private InventarioBST inventario = new InventarioBST();
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicionX = 0; // posición inicial por defecto
        this.posicionY = 0;
        this.inventario = new InventarioBST();
    }
    //getters
    public String getNombre() {
        return nombre;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void moverA(int nuevaX, int nuevaY) {
        this.posicionX = nuevaX;
        this.posicionY = nuevaY;
    }

    public void moverPor(int deltaX, int deltaY) {
        this.posicionX += deltaX;
        this.posicionY += deltaY;
    }
    public InventarioBST getInventario() {
        return inventario;}
        @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", posición=(" + posicionX + ", " + posicionY + ")" +
                '}';
    }
    public class Jugador {
    private String nombre;
    private InventarioBST inventario = new InventarioBST();

    public InventarioBST getInventario() { return inventario; }

    public boolean intentarRobar(Jugador victima, String nombreTesoro) {
        boolean exito = victima.getInventario().buscarConProbabilidad(nombreTesoro);
        if (exito) {
            Tesoro robado = victima.getInventario().buscar(nombreTesoro);
            if (robado != null && victima.getInventario().eliminar(nombreTesoro)) {
                this.inventario.insertar(robado);
                return true;
            }
        }
        return false;
    }
}
