public class RedAlmacenes {
    public static void main(String[] args) {
        Grafo red = new Grafo();

        // Agregar almacenes
        red.agregarAlmacen(0, "Almacen Central");
        red.agregarAlmacen(1, "Almacen Norte");
        red.agregarAlmacen(2, "Almacen Sur");
        red.agregarAlmacen(3, "Almacen Este");
        red.agregarAlmacen(4, "Almacen Oeste");
        red.agregarAlmacen(5, "Almacen Secundario");
        red.agregarAlmacen(6, "Almacen Auxiliar");
        red.agregarAlmacen(7, "Almacen Principal");
        red.agregarAlmacen(8, "Almacen Regional");

        // Conectar almacenes
        red.conectarAlmacenes(0, 1);
        red.conectarAlmacenes(0, 2);
        red.conectarAlmacenes(1, 3);
        red.conectarAlmacenes(1, 4);
        red.conectarAlmacenes(2, 5);
        red.conectarAlmacenes(3, 6);
        red.conectarAlmacenes(4, 7);
        red.conectarAlmacenes(4, 8);

        // Realizar recorridos
        System.out.println("Exploración de la red de almacenes:");
        red.DFS(0); // Recorrido en profundidad (DFS) desde el almacén central
        red.BFS(0); // Recorrido en anchura (BFS) desde el almacén central
    }
}
