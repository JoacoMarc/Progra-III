public class Cliente {
    private int id;
    private String nombre;
    private int scoring;

    public Cliente(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    public int getScoring() {
        return scoring;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Scoring: " + scoring;
    }
}
