public class Cliente {
    int id;
    String nombre;
    int scoring;

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
        return  "id= " + id +
                ", nombre= '" + nombre + '\'' +
                ", scoring= " + scoring;
    }
}
