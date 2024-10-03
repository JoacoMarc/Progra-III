public class Main {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();
        red.agregarUsuario("Juan");
        red.agregarUsuario("María");
        red.agregarUsuario("Lucía");
        red.agregarUsuario("Carlos");

        // Intentar agregar un usuario existente
        red.agregarUsuario("Juan");

        // Establecer relaciones de seguimiento
        red.seguir("Juan", "María");
        red.seguir("Juan", "Lucía");
        red.seguir("María", "Lucía");
        red.seguir("Lucía", "Juan");
        red.seguir("Carlos", "Juan");
        red.seguir("Carlos", "María");

        // Intentar seguir a sí mismo
        red.seguir("Juan", "Juan");

        // Intentar seguir a un usuario ya seguido
        red.seguir("Juan", "María");

        // Dejar de seguir
        red.dejarDeSeguir("Juan", "Lucía");
        red.dejarDeSeguir("María", "Carlos"); // No está siguiendo

        // Obtener listas
        System.out.println("\nLista de usuarios que Juan sigue: " + red.obtenerSeguidos("Juan"));
        System.out.println("Lista de seguidores de Juan: " + red.obtenerSeguidores("Juan"));

        System.out.println("\nLista de usuarios que María sigue: " + red.obtenerSeguidos("María"));
        System.out.println("Lista de seguidores de María: " + red.obtenerSeguidores("María"));

        System.out.println("\nLista de usuarios que Lucía sigue: " + red.obtenerSeguidos("Lucía"));
        System.out.println("Lista de seguidores de Lucía: " + red.obtenerSeguidores("Lucía"));

        System.out.println("\nLista de usuarios que Carlos sigue: " + red.obtenerSeguidos("Carlos"));
        System.out.println("Lista de seguidores de Carlos: " + red.obtenerSeguidores("Carlos"));

    }
}