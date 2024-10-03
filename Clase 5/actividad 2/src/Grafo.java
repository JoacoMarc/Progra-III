import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Grafo {
    private List<String> nodos; // Lista de nodos
    private Map<String, Integer> indicesNodos; // Mapa de nodos a sus índices
    private ArrayList<ArrayList<Boolean>> matrizAdyacencia; // Matriz de adyacencia

    // Constructor: Inicializa las estructuras de datos
    public Grafo() {
        nodos = new ArrayList<>();
        indicesNodos = new HashMap<>();
        matrizAdyacencia = new ArrayList<>();
    }

    // Método para agregar un nuevo nodo al grafo
    public boolean agregarNodo(String nodo) {
        if (indicesNodos.containsKey(nodo)) {
            System.out.println("El nodo '" + nodo + "' ya existe.");
            return false;
        }

        nodos.add(nodo);
        int nuevoIndice = nodos.size() - 1;
        indicesNodos.put(nodo, nuevoIndice);

        // Agregar una nueva columna a cada fila existente
        for (ArrayList<Boolean> fila : matrizAdyacencia) {
            fila.add(false);
        }

        // Crear una nueva fila para el nuevo nodo
        ArrayList<Boolean> nuevaFila = new ArrayList<>();
        for (int i = 0; i < nodos.size(); i++) {
            nuevaFila.add(false);
        }
        matrizAdyacencia.add(nuevaFila);

        System.out.println("Nodo '" + nodo + "' agregado exitosamente.");
        return true;
    }

    // Método para agregar una arista dirigida desde 'desde' hasta 'hasta'
    public boolean agregarArista(String desde, String hasta) {
        if (!indicesNodos.containsKey(desde)) {
            System.out.println("El nodo origen '" + desde + "' no existe.");
            return false;
        }
        if (!indicesNodos.containsKey(hasta)) {
            System.out.println("El nodo destino '" + hasta + "' no existe.");
            return false;
        }

        int indiceDesde = indicesNodos.get(desde);
        int indiceHasta = indicesNodos.get(hasta);

        if (matrizAdyacencia.get(indiceDesde).get(indiceHasta)) {
            System.out.println("Ya existe una arista de '" + desde + "' a '" + hasta + "'.");
            return false;
        }

        matrizAdyacencia.get(indiceDesde).set(indiceHasta, true);
        System.out.println("Arista de '" + desde + "' a '" + hasta + "' agregada exitosamente.");
        return true;
    }

    // Método para eliminar una arista dirigida desde 'desde' hasta 'hasta'
    public boolean eliminarArista(String desde, String hasta) {
        if (!indicesNodos.containsKey(desde)) {
            System.out.println("El nodo origen '" + desde + "' no existe.");
            return false;
        }
        if (!indicesNodos.containsKey(hasta)) {
            System.out.println("El nodo destino '" + hasta + "' no existe.");
            return false;
        }

        int indiceDesde = indicesNodos.get(desde);
        int indiceHasta = indicesNodos.get(hasta);

        if (!matrizAdyacencia.get(indiceDesde).get(indiceHasta)) {
            System.out.println("No existe una arista de '" + desde + "' a '" + hasta + "'.");
            return false;
        }

        matrizAdyacencia.get(indiceDesde).set(indiceHasta, false);
        System.out.println("Arista de '" + desde + "' a '" + hasta + "' eliminada exitosamente.");
        return true;
    }

    // Método para verificar si existe una arista dirigida desde 'desde' hasta 'hasta'
    public boolean existeArista(String desde, String hasta) {
        if (!indicesNodos.containsKey(desde)) {
            System.out.println("El nodo origen '" + desde + "' no existe.");
            return false;
        }
        if (!indicesNodos.containsKey(hasta)) {
            System.out.println("El nodo destino '" + hasta + "' no existe.");
            return false;
        }

        int indiceDesde = indicesNodos.get(desde);
        int indiceHasta = indicesNodos.get(hasta);

        return matrizAdyacencia.get(indiceDesde).get(indiceHasta);
    }

    // Método para listar todos los nodos adyacentes a un nodo dado
    public List<String> listarAdyacentes(String nodo) {
        List<String> adyacentes = new ArrayList<>();

        if (!indicesNodos.containsKey(nodo)) {
            System.out.println("El nodo '" + nodo + "' no existe.");
            return adyacentes;
        }

        int indiceNodo = indicesNodos.get(nodo);
        ArrayList<Boolean> fila = matrizAdyacencia.get(indiceNodo);

        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i)) {
                adyacentes.add(nodos.get(i));
            }
        }

        return adyacentes;
    }

    // Método para contar el grado de salida de un nodo
    public int contarGradoSalida(String nodo) {
        if (!indicesNodos.containsKey(nodo)) {
            System.out.println("El nodo '" + nodo + "' no existe.");
            return 0;
        }

        int indiceNodo = indicesNodos.get(nodo);
        ArrayList<Boolean> fila = matrizAdyacencia.get(indiceNodo);
        int contador = 0;

        for (boolean existe : fila) {
            if (existe) {
                contador++;
            }
        }

        return contador;
    }

    // Método para contar el grado de entrada de un nodo
    public int contarGradoEntrada(String nodo) {
        if (!indicesNodos.containsKey(nodo)) {
            System.out.println("El nodo '" + nodo + "' no existe.");
            return 0;
        }

        int indiceNodo = indicesNodos.get(nodo);
        int contador = 0;

        for (ArrayList<Boolean> fila : matrizAdyacencia) {
            if (fila.get(indiceNodo)) {
                contador++;
            }
        }

        return contador;
    }

    // Método para imprimir la matriz de adyacencia (opcional, para depuración)
    public void imprimirMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        System.out.print("    ");
        for (String nodo : nodos) {
            System.out.print(nodo + " ");
        }
        System.out.println();
        for (int i = 0; i < matrizAdyacencia.size(); i++) {
            System.out.print(nodos.get(i) + " ");
            for (int j = 0; j < matrizAdyacencia.get(i).size(); j++) {
                System.out.print("   " + (matrizAdyacencia.get(i).get(j) ? "1" : "0"));
            }
            System.out.println();
        }
    }
}

