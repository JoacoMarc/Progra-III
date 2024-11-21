

public class Conexion implements Comparable<Conexion> {
    private String destino;
    private int tiempo;

    public Conexion(String destino, int tiempo) {
        this.destino = destino;
        this.tiempo = tiempo;
    }

    public String getDestino() {
        return destino;
    }

    public int getTiempo() {
        return tiempo;
    }

    // Método compareTo para ordenar las conexiones por tiempo
    @Override
    public int compareTo(Conexion otraConexion) {
        return Integer.compare(this.tiempo, otraConexion.tiempo);
    }

    @Override
    public String toString() {
        return "a " + destino + " con tiempo: " + tiempo + " minutos";
    }
}
