public class Usuario {
    private int id; // Identificador único del usuario
    private String nombre; // Nombre del usuario

    // Constructor
    public Usuario(int id, String nombre) {
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
