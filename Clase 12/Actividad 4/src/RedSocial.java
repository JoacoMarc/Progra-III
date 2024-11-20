import java.util.*;

public class RedSocial {
    private Map<Integer, Usuario> usuarios; // Mapa para almacenar usuarios por ID
    private Map<Integer, List<Integer>> amistades; // Lista de adyacencia para representar las amistades

    // Constructor
    public RedSocial() {
        usuarios = new HashMap<>();
        amistades = new HashMap<>();
    }

    // Método para agregar un usuario a la red
    public void agregarUsuario(int id, String nombre) {
        if (!usuarios.containsKey(id)) {
            Usuario usuario = new Usuario(id, nombre);
            usuarios.put(id, usuario);
            amistades.put(id, new LinkedList<>()); // Crear lista de adyacencia para este usuario
        } else {
            System.out.println("El usuario con ID " + id + " ya existe.");
        }
    }

    // Método para conectar dos usuarios como amigos
    public void agregarAmistad(int id1, int id2) {
        if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
            amistades.get(id1).add(id2); // Amistad de id1 a id2
            amistades.get(id2).add(id1); // Amistad de id2 a id1 (bidireccional)
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }

    // Implementación de DFS
    public void DFS(int idInicio) {
        if (!usuarios.containsKey(idInicio)) {
            System.out.println("El usuario de inicio no existe.");
            return;
        }

        Set<Integer> visitado = new HashSet<>(); // Conjunto para rastrear usuarios visitados
        System.out.println("Recorrido DFS desde el usuario: " + usuarios.get(idInicio).getNombre());
        DFSUtil(idInicio, visitado);
        System.out.println();
    }

    private void DFSUtil(int id, Set<Integer> visitado) {
        visitado.add(id); // Marcar el usuario como visitado
        System.out.print(usuarios.get(id).getNombre() + " "); // Mostrar el usuario

        // Explorar las amistades no visitadas
        for (int amigo : amistades.get(id)) {
            if (!visitado.contains(amigo)) {
                DFSUtil(amigo, visitado);
            }
        }
    }

    // Implementación de BFS
    public void BFS(int idInicio) {
        if (!usuarios.containsKey(idInicio)) {
            System.out.println("El usuario de inicio no existe.");
            return;
        }

        Set<Integer> visitado = new HashSet<>(); // Conjunto para rastrear usuarios visitados
        LinkedList<Integer> cola = new LinkedList<>(); // Cola para gestionar el recorrido

        visitado.add(idInicio); // Marcar el usuario de inicio como visitado
        cola.add(idInicio); // Añadir a la cola

        System.out.println("Recorrido BFS desde el usuario: " + usuarios.get(idInicio).getNombre());
        while (!cola.isEmpty()) {
            int id = cola.poll(); // Extraer el primer usuario de la cola
            System.out.print(usuarios.get(id).getNombre() + " "); // Mostrar el usuario

            // Explorar las amistades no visitadas
            for (int amigo : amistades.get(id)) {
                if (!visitado.contains(amigo)) {
                    visitado.add(amigo);
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }
}
