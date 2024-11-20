import java.util.*;

public class Grafo {
    private Map<Integer, Almacen> almacenes; // Mapa para almacenar los almacenes por su ID
    private Map<Integer, List<Integer>> adyacencia; // Lista de adyacencia para las conexiones

    // Constructor
    public Grafo() {
        almacenes = new HashMap<>();
        adyacencia = new HashMap<>();
    }

    // Método para agregar un almacén
    public void agregarAlmacen(int id, String nombre) {
        if (!almacenes.containsKey(id)) {
            Almacen almacen = new Almacen(id, nombre);
            almacenes.put(id, almacen);
            adyacencia.put(id, new LinkedList<>()); // Crear lista de adyacencia para este almacén
        } else {
            System.out.println("El almacén con ID " + id + " ya existe.");
        }
    }

    // Método para conectar dos almacenes
    public void conectarAlmacenes(int id1, int id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            adyacencia.get(id1).add(id2); // Conexión desde id1 a id2
            adyacencia.get(id2).add(id1); // Conexión desde id2 a id1 (grafo no dirigido)
        } else {
            System.out.println("Uno o ambos almacenes no existen.");
        }
    }

    // Implementación de DFS
    public void DFS(int idInicio) {
        if (!almacenes.containsKey(idInicio)) {
            System.out.println("El almacén de inicio no existe.");
            return;
        }

        Set<Integer> visitado = new HashSet<>(); // Conjunto para almacenar los nodos visitados
        System.out.println("Recorrido DFS desde el almacén: " + almacenes.get(idInicio).getNombre());
        DFSUtil(idInicio, visitado);
        System.out.println();
    }

    private void DFSUtil(int id, Set<Integer> visitado) {
        visitado.add(id); // Marcar el nodo como visitado
        System.out.print(almacenes.get(id).getNombre() + " "); // Procesar el nodo

        // Explorar los vecinos
        for (int vecino : adyacencia.get(id)) {
            if (!visitado.contains(vecino)) {
                DFSUtil(vecino, visitado);
            }
        }
    }

    // Implementación de BFS
    public void BFS(int idInicio) {
        if (!almacenes.containsKey(idInicio)) {
            System.out.println("El almacén de inicio no existe.");
            return;
        }

        Set<Integer> visitado = new HashSet<>(); // Conjunto para almacenar los nodos visitados
        LinkedList<Integer> cola = new LinkedList<>(); // Cola para BFS

        visitado.add(idInicio); // Marcar el nodo de inicio como visitado
        cola.add(idInicio); // Añadirlo a la cola

        System.out.println("Recorrido BFS desde el almacén: " + almacenes.get(idInicio).getNombre());
        while (!cola.isEmpty()) {
            int id = cola.poll(); // Extraer el primer nodo de la cola
            System.out.print(almacenes.get(id).getNombre() + " "); // Procesar el nodo

            // Explorar los vecinos no visitados
            for (int vecino : adyacencia.get(id)) {
                if (!visitado.contains(vecino)) {
                    visitado.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }
}
