// Archivo: Conexion.java

public class Conexion implements Comparable<Conexion> {
    private String origen;
    private String destino;
    private int costo;

    public Conexion(String origen, String destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getCosto() {
        return costo;
    }

    // Método compareTo para ordenar las conexiones por costo
    @Override
    public int compareTo(Conexion otraConexion) {
        return Integer.compare(this.costo, otraConexion.costo);
    }

    @Override
    public String toString() {
        return origen + " <--> " + destino + " con costo: " + costo;
    }
}



