public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregar nodos con identificadores genéricos
        grafo.agregarNodo("Nodo1");
        grafo.agregarNodo("Nodo2");
        grafo.agregarNodo("Nodo3");
        grafo.agregarNodo("Nodo4");
        grafo.agregarNodo("Nodo5");

        // Intentar agregar un nodo existente
        grafo.agregarNodo("Nodo1");

        // Agregar aristas
        grafo.agregarArista("Nodo1", "Nodo2");
        grafo.agregarArista("Nodo1", "Nodo3");
        grafo.agregarArista("Nodo2", "Nodo3");
        grafo.agregarArista("Nodo3", "Nodo1");
        grafo.agregarArista("Nodo4", "Nodo1");
        grafo.agregarArista("Nodo4", "Nodo2");
        grafo.agregarArista("Nodo5", "Nodo4");

        // Intentar agregar una arista existente
        grafo.agregarArista("Nodo1", "Nodo2");

        // Intentar agregar una arista con nodos inexistentes
        grafo.agregarArista("Nodo1", "Nodo6"); // Nodo6 no existe

        // Verificar la existencia de aristas
        System.out.println("\nVerificación de aristas:");
        System.out.println("¿Nodo1 sigue a Nodo2? " + (grafo.existeArista("Nodo1", "Nodo2") ? "Sí" : "No"));
        System.out.println("¿Nodo2 sigue a Nodo4? " + (grafo.existeArista("Nodo2", "Nodo4") ? "Sí" : "No"));

        // Listar adyacentes
        System.out.println("\nLista de adyacentes:");
        System.out.println("Nodo1 sigue a: " + grafo.listarAdyacentes("Nodo1"));
        System.out.println("Nodo2 sigue a: " + grafo.listarAdyacentes("Nodo2"));
        System.out.println("Nodo3 sigue a: " + grafo.listarAdyacentes("Nodo3"));
        System.out.println("Nodo4 sigue a: " + grafo.listarAdyacentes("Nodo4"));
        System.out.println("Nodo5 sigue a: " + grafo.listarAdyacentes("Nodo5"));

        // Contar grados de entrada y salida
        System.out.println("\nGrados de los nodos:");
        for (String nodo : new String[]{"Nodo1", "Nodo2", "Nodo3", "Nodo4", "Nodo5"}) {
            System.out.println("Nodo '" + nodo + "':");
            System.out.println("  Grado de Salida: " + grafo.contarGradoSalida(nodo));
            System.out.println("  Grado de Entrada: " + grafo.contarGradoEntrada(nodo));
        }

        // Eliminar una arista
        grafo.eliminarArista("Nodo1", "Nodo3");
        grafo.eliminarArista("Nodo2", "Nodo4"); // No existe

        // Listar adyacentes después de eliminar aristas
        System.out.println("\nLista de adyacentes después de eliminar aristas:");
        System.out.println("Nodo1 sigue a: " + grafo.listarAdyacentes("Nodo1"));
        System.out.println("Nodo2 sigue a: " + grafo.listarAdyacentes("Nodo2"));

        // Imprimir la matriz de adyacencia
        System.out.println();
        grafo.imprimirMatrizAdyacencia();
    }
}