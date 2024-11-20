package viajes;
import java.util.*;

public class SeleccionDeViajes {
    private final Map<String, List<Destino>> grafo = new HashMap<>();

    // Método para agregar rutas entre destinos
    public void agregarRuta(String origen, String destino, int costo) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(new Destino(destino, costo));
    }

    // Implementación del algoritmo de búsqueda UCS
    public int buscarCostoMinimo(String inicio, String objetivo) {
        PriorityQueue<Destino> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(d -> d.costo));
        colaPrioridad.add(new Destino(inicio, 0));
        Set<String> visitados = new HashSet<>();

        while (!colaPrioridad.isEmpty()) {
            Destino actual = colaPrioridad.poll();

            // Si llegamos al destino objetivo, retornamos el costo
            if (actual.nombre.equals(objetivo)) {
                return actual.costo;
            }

            // Ignoramos nodos ya visitados
            if (visitados.contains(actual.nombre)) continue;
            visitados.add(actual.nombre);

            // Explorar las rutas desde el nodo actual
            for (Destino vecino : grafo.getOrDefault(actual.nombre, new ArrayList<>())) {
                if (!visitados.contains(vecino.nombre)) {
                    colaPrioridad.add(new Destino(vecino.nombre, actual.costo + vecino.costo));
                }
            }
        }

        return -1; // Si no hay un camino al destino
    }
}

