// Archivo: Grafo.java

import java.util.*;

public class Grafo {
    private Map<String, List<Conexion>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    // Método para agregar un centro de distribución al grafo
    public void agregarCentro(String centro) {
        listaAdyacencia.putIfAbsent(centro, new ArrayList<>());
    }

    // Método para agregar una carretera bidireccional entre dos centros con un tiempo de viaje
    public void agregarCarretera(String origen, String destino, int tiempo) {
        if (!listaAdyacencia.containsKey(origen) || !listaAdyacencia.containsKey(destino)) {
            System.out.println("Uno o ambos centros no existen en el grafo.");
            return;
        }
        listaAdyacencia.get(origen).add(new Conexion(destino, tiempo));
        listaAdyacencia.get(destino).add(new Conexion(origen, tiempo));
    }

    // Método para aplicar el Algoritmo de Dijkstra y obtener los tiempos mínimos de entrega
    public Map<String, Integer> dijkstra(String inicio) {
        // Mapa para almacenar el tiempo mínimo desde el inicio a cada centro
        Map<String, Integer> tiemposMinimos = new HashMap<>();
        // Inicializar todos los tiempos como infinito
        for (String centro : listaAdyacencia.keySet()) {
            tiemposMinimos.put(centro, Integer.MAX_VALUE);
        }
        // Tiempo desde el inicio a sí mismo es 0
        tiemposMinimos.put(inicio, 0);

        // Cola de prioridad para seleccionar el centro con el tiempo mínimo
        PriorityQueue<CentroTiempo> colaPrioridad = new PriorityQueue<>();
        colaPrioridad.offer(new CentroTiempo(inicio, 0));

        while (!colaPrioridad.isEmpty()) {
            CentroTiempo actual = colaPrioridad.poll();
            String centroActual = actual.getCentro();
            int tiempoActual = actual.getTiempo();

            // Iterar sobre las conexiones del centro actual
            for (Conexion conexion : listaAdyacencia.get(centroActual)) {
                String centroDestino = conexion.getDestino();
                int tiempoNuevaRuta = tiempoActual + conexion.getTiempo();

                // Si se encuentra una ruta más rápida hacia el centro destino
                if (tiempoNuevaRuta < tiemposMinimos.get(centroDestino)) {
                    tiemposMinimos.put(centroDestino, tiempoNuevaRuta);
                    colaPrioridad.offer(new CentroTiempo(centroDestino, tiempoNuevaRuta));
                }
            }
        }

        return tiemposMinimos;
    }

    // Clase interna para manejar centros y sus tiempos en la cola de prioridad
    private class CentroTiempo implements Comparable<CentroTiempo> {
        private String centro;
        private int tiempo;

        public CentroTiempo(String centro, int tiempo) {
            this.centro = centro;
            this.tiempo = tiempo;
        }

        public String getCentro() {
            return centro;
        }

        public int getTiempo() {
            return tiempo;
        }

        @Override
        public int compareTo(CentroTiempo otro) {
            return Integer.compare(this.tiempo, otro.tiempo);
        }
    }
}
