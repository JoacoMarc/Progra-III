import java.util.Arrays;

public class FloydWarshall {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    public static void floydWarshall(int[][] graph, int V) {
        // Crear una matriz para almacenar las distancias más cortas
        int[][] dist = new int[V][V];

        // Inicializar la matriz de distancias igual a la del grafo de entrada
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Si el nodo k está en el camino más corto de i a j, actualizamos dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias más cortas
        printSolution(dist, V);
    }

    // Función para imprimir la solución
    public static void printSolution(int[][] dist, int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de nodos:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Número de nodos
        int V = 4;

        // Matriz de adyacencia del grafo basado en los pesos dados en la actividad
        int[][] graph = {
                { 0, 2, INF, 5 },  // Nodo 1
                { INF, 0, INF, 4 },  // Nodo 2
                { INF, INF, 0, INF },  // Nodo 3
                { INF, INF, 2, 0 }  // Nodo 4
        };

        // Ejecutar el algoritmo de Floyd-Warshall
        floydWarshall(graph, V);
    }
}
