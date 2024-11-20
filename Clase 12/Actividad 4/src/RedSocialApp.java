public class RedSocialApp {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        // Agregar usuarios a la red
        red.agregarUsuario(0, "Chiara");
        red.agregarUsuario(1, "Nicolás");
        red.agregarUsuario(2, "Joaquin");
        red.agregarUsuario(3, "Valentina");
        red.agregarUsuario(4, "Tomás");
        red.agregarUsuario(5, "Emma");
        red.agregarUsuario(6, "Lucio");
        red.agregarUsuario(7, "Lucila");
        red.agregarUsuario(8, "Manuel");

        // Crear amistades
        red.agregarAmistad(0, 1);
        red.agregarAmistad(0, 2);
        red.agregarAmistad(1, 3);
        red.agregarAmistad(1, 4);
        red.agregarAmistad(2, 5);
        red.agregarAmistad(3, 6);
        red.agregarAmistad(4, 7);
        red.agregarAmistad(4, 8);

        // Realizar recorridos desde un usuario dado
        System.out.println("Exploración de la red social:");
        red.DFS(0); // Recorrido en profundidad desde Alice
        red.BFS(0); // Recorrido en anchura desde Alice
    }
}
