import java.util.LinkedList;

public class GrafoDFS {
    private int V; // número de vértices
    private LinkedList<Integer>[] adj; // listas de adyacencia para cada vértice

    // Constructor
    public GrafoDFS(int V) {
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

    // Método auxiliar de DFS que se llama recursivamente
    private void DFSUtil(int v, boolean[] visitado) {
        // Marcar el vértice actual como visitado y mostrarlo
        visitado[v] = true;
        System.out.print(v + " ");

        // Recorrer todos los vértices adyacentes al vértice actual
        for (int n : adj[v]) {
            if (!visitado[n]) {
                DFSUtil(n, visitado); // Llamada recursiva para los vértices no visitados
            }
        }
    }

    // Método principal DFS que llama a DFSUtil
    public void DFS(int inicio) {
        // Array de booleanos para marcar los vértices visitados
        boolean[] visitado = new boolean[V];

        // Llamar al método recursivo DFSUtil comenzando desde el vértice "inicio"
        DFSUtil(inicio, visitado);
    }

    // Método main para ejecutar el ejemplo
    public static void main(String[] args) {
        GrafoDFS grafo = new GrafoDFS(9); // Crear un grafo con 9 vértices (0 a 8)

        // Agregar aristas al grafo
        grafo.agregarArista(0, 1);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(2, 5);

        // Imprimir el recorrido DFS desde el nodo 0
        System.out.println("Recorrido DFS empezando desde el vértice 0:");
        grafo.DFS(0);
    }
}
