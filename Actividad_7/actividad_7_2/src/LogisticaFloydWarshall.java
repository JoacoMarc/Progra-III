public class LogisticaFloydWarshall {
    final static int INF = 99999;  // Un valor grande para representar infinito

    // Método que aplica el algoritmo de Floyd-Warshall
    public void floydWarshall(int[][] graph, int V) {
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
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias más cortas
        printSolution(dist, V);

        // Verificar si hay ciclos negativos
        checkNegativeCycle(dist, V);
    }

    // Método para imprimir la solución
    public void printSolution(int[][] dist, int V) {
        System.out.println("Matriz de tiempos mínimos entre cada par de centros:");
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

    // Método para detectar ciclos negativos
    public void checkNegativeCycle(int[][] dist, int V) {
        boolean negativeCycle = false;
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                negativeCycle = true;
                System.out.println("Se detecta un ciclo negativo en el nodo " + i);
            }
        }
        if (!negativeCycle) {
            System.out.println("No se detectaron ciclos negativos.");
        }
    }

    public static void main(String[] args) {
        LogisticaFloydWarshall fw = new LogisticaFloydWarshall();

        // Ejemplo de matriz de tiempos de viaje entre centros de distribución (grafo)
        int V = 4;  // Número de centros
        int[][] graph = {
                { 0, 3, INF, 7 },  // Centro 1
                { 8, 0, 2, INF },  // Centro 2
                { 5, INF, 0, 1 },  // Centro 3
                { 2, INF, INF, 0 }  // Centro 4
        };

        // Ejecutar el algoritmo de Floyd-Warshall
        fw.floydWarshall(graph, V);
    }
}
