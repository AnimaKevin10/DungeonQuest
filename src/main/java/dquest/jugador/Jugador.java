package dquest.jugador;
public class Jugador {
    private String nombre;
    private int posicionX;
    private int posicionY;
    // Luego se pone el hash inventory aqui
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicionX = 0; // posición inicial por defecto
        this.posicionY = 0;
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

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", posición=(" + posicionX + ", " + posicionY + ")" +
                '}';
    }
}
