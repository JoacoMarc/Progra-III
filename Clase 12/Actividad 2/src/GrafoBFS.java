import java.util.LinkedList;

public class GrafoBFS {
    private int V; // número de vértices
    private LinkedList<Integer>[] adj; // listas de adyacencia para cada vértice

    // Constructor
    public GrafoBFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>(); // Inicializar lista de adyacencia para cada vértice
        }
    }

    // Método para agregar una arista
    public void agregarArista(int v, int w) {
        adj[v].add(w); // Añadir w a la lista de adyacencia de v
    }

    // Implementación de BFS
    public void BFS(int inicio) {
        boolean[] visitado = new boolean[V]; // Array de visitados
        LinkedList<Integer> cola = new LinkedList<>(); // Cola para BFS

        visitado[inicio] = true; // Marcar el nodo de inicio como visitado
        cola.add(inicio); // Añadirlo a la cola

        while (!cola.isEmpty()) {
            inicio = cola.poll(); // Extraer el primer nodo de la cola
            System.out.print(inicio + " "); // Procesar el nodo

            // Obtener todos los nodos adyacentes de "inicio"
            for (int n : adj[inicio]) {
                if (!visitado[n]) {
                    visitado[n] = true; // Marcar como visitado
                    cola.add(n); // Añadir a la cola
                }
            }
        }
    }

    // Método main para ejecutar el ejemplo
    public static void main(String[] args) {
        GrafoBFS grafo = new GrafoBFS(9); // Crear un grafo con 9 vértices (0 a 8)

        // Agregar aristas al grafo
        grafo.agregarArista(0, 1);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(2, 5);

        // Imprimir el recorrido BFS desde el nodo 0
        System.out.println("Recorrido BFS empezando desde el vértice 0:");
        grafo.BFS(0);
    }
}
