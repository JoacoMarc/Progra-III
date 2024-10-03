

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregar nodos (estaciones eléctricas)
        grafo.agregarNodo("Nodo1");
        grafo.agregarNodo("Nodo2");
        grafo.agregarNodo("Nodo3");
        grafo.agregarNodo("Nodo4");
        grafo.agregarNodo("Nodo5");
        grafo.agregarNodo("Nodo6");

        // Agregar conexiones con costos (por ejemplo, kilómetros o costos monetarios)
        grafo.agregarConexion("Nodo1", "Nodo2", 4);
        grafo.agregarConexion("Nodo1", "Nodo3", 3);
        grafo.agregarConexion("Nodo2", "Nodo3", 1);
        grafo.agregarConexion("Nodo2", "Nodo4", 2);
        grafo.agregarConexion("Nodo3", "Nodo4", 4);
        grafo.agregarConexion("Nodo3", "Nodo5", 2);
        grafo.agregarConexion("Nodo4", "Nodo5", 3);
        grafo.agregarConexion("Nodo4", "Nodo6", 2);
        grafo.agregarConexion("Nodo5", "Nodo6", 3);

        // Aplicar el algoritmo de Prim para obtener el ARM
        String nodoInicial = "Nodo1";
        List<Conexion> arm = grafo.prim(nodoInicial);

        if (!arm.isEmpty()) {
            // Mostrar las conexiones en el ARM y calcular el costo total
            System.out.println("Conjunto de conexiones en el Árbol de Recubrimiento Mínimo (ARM):");
            int costoTotal = 0;
            for (Conexion conexion : arm) {
                System.out.println(conexion);
                costoTotal += conexion.getCosto();
            }
            System.out.println("Costo total del ARM: " + costoTotal);
        }
    }
}
