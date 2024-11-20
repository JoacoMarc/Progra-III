public class Almacen {
    private int id; // Identificador único del almacén
    private String nombre; // Nombre del almacén

    // Constructor
    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos para obtener los atributos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}
