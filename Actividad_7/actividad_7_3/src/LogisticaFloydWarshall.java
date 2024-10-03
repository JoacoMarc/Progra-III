import java.util.Scanner;

public class LogisticaFloydWarshall {
    final static int INF = 99999;  // Un valor grande para representar infinito

    // Método que aplica el algoritmo de Floyd-Warshall y también rastrea predecesores
    public void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];
        int[][] pred = new int[V][V]; // Matriz de predecesores

        // Inicializar las matrices de distancias y predecesores
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    pred[i][j] = i; // El predecesor inicial es el nodo de origen
                } else {
                    pred[i][j] = -1; // No hay predecesor si no hay conexión
                }
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pred[i][j] = pred[k][j]; // Actualizar el predecesor
                    }
                }
            }
        }

        // Pedir al usuario el origen y el destino
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nodo de origen (0 a " + (V-1) + "): ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el nodo de destino (0 a " + (V-1) + "): ");
        int destino = scanner.nextInt();

        // Imprimir el camino más corto
        if (dist[origen][destino] == INF) {
            System.out.println("No existe un camino entre el nodo " + origen + " y el nodo " + destino);
        } else {
            System.out.println("El tiempo mínimo de viaje entre " + origen + " y " + destino + " es: " + dist[origen][destino]);
            System.out.print("El camino más corto es: ");
            printPath(origen, destino, pred);
            System.out.println(destino); // Imprimir el nodo de destino
        }
    }

    // Método para reconstruir e imprimir el camino más corto
    public void printPath(int origen, int destino, int[][] pred) {
        if (origen == destino) {
            return;
        }
        if (pred[origen][destino] == -1) {
            System.out.print("No hay camino");
            return;
        }
        printPath(origen, pred[origen][destino], pred);
        System.out.print(pred[origen][destino] + " -> ");
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
