
import java.util.*;

public class Grafo {
    private Map<String, List<ConexionPrim>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    // Método para agregar un nodo al grafo
    public void agregarNodo(String nodo) {
        listaAdyacencia.putIfAbsent(nodo, new ArrayList<>());
    }

    // Método para agregar una conexión bidireccional entre dos nodos con un costo
    public void agregarConexion(String origen, String destino, int costo) {
        if (!listaAdyacencia.containsKey(origen) || !listaAdyacencia.containsKey(destino)) {
            System.out.println("Uno o ambos nodos no existen en el grafo.");
            return;
        }
        listaAdyacencia.get(origen).add(new ConexionPrim(origen, destino, costo));
        listaAdyacencia.get(destino).add(new ConexionPrim(destino, origen, costo));
    }

    // Método para aplicar el algoritmo de Prim y obtener el ARM
    public List<Conexion> prim(String inicio) {
        List<Conexion> arm = new ArrayList<>();
        Set<String> visitados = new HashSet<>();
        PriorityQueue<ConexionPrim> colaPrioridad = new PriorityQueue<>();

        // Agregar conexiones del nodo inicial a la cola
        visitados.add(inicio);
        for (ConexionPrim conexion : listaAdyacencia.get(inicio)) {
            colaPrioridad.offer(conexion);
        }

        while (!colaPrioridad.isEmpty() && arm.size() < listaAdyacencia.size() - 1) {
            ConexionPrim conexionPrim = colaPrioridad.poll();
            String destino = conexionPrim.getDestino();
            int costo = conexionPrim.getCosto();
            String origen = conexionPrim.getOrigen();

            if (!visitados.contains(destino)) {
                visitados.add(destino);
                arm.add(new Conexion(origen, destino, costo));

                for (ConexionPrim conexion : listaAdyacencia.get(destino)) {
                    if (!visitados.contains(conexion.getDestino())) {
                        colaPrioridad.offer(conexion);
                    }
                }
            }
        }

        // Verificar si el grafo es conexo
        if (arm.size() != listaAdyacencia.size() - 1) {
            System.out.println("El grafo no es conexo. No se puede formar un ARM que abarque todos los nodos.");
            return Collections.emptyList();
        }

        return arm;
    }

    // Clase interna para manejar conexiones en el algoritmo de Prim
    private class ConexionPrim implements Comparable<ConexionPrim> {
        private String origen;
        private String destino;
        private int costo;

        public ConexionPrim(String origen, String destino, int costo) {
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

        @Override
        public int compareTo(ConexionPrim otra) {
            return Integer.compare(this.costo, otra.costo);
        }
    }
}
