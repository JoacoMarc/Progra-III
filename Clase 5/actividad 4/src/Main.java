// Archivo: Principal.java

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregar centros de distribución
        grafo.agregarCentro("CentroPrincipal");
        grafo.agregarCentro("CiudadA");
        grafo.agregarCentro("CiudadB");
        grafo.agregarCentro("CiudadC");
        grafo.agregarCentro("CiudadD");
        grafo.agregarCentro("CiudadE");

        // Agregar carreteras con tiempos de viaje en minutos
        grafo.agregarCarretera("CentroPrincipal", "CiudadA", 10);
        grafo.agregarCarretera("CentroPrincipal", "CiudadB", 15);
        grafo.agregarCarretera("CiudadA", "CiudadC", 12);
        grafo.agregarCarretera("CiudadB", "CiudadD", 10);
        grafo.agregarCarretera("CiudadC", "CiudadD", 2);
        grafo.agregarCarretera("CiudadD", "CiudadE", 1);
        grafo.agregarCarretera("CiudadB", "CiudadE", 5);
        grafo.agregarCarretera("CiudadA", "CiudadE", 30);

        // Aplicar el Algoritmo de Dijkstra para obtener los tiempos mínimos de entrega
        String centroPrincipal = "CentroPrincipal";
        Map<String, Integer> tiemposMinimos = grafo.dijkstra(centroPrincipal);

        // Mostrar los resultados
        System.out.println("Tiempo mínimo de entrega desde " + centroPrincipal + " hasta los demás centros:");
        for (Map.Entry<String, Integer> entry : tiemposMinimos.entrySet()) {
            String centro = entry.getKey();
            int tiempo = entry.getValue();
            if (!centro.equals(centroPrincipal)) {
                if (tiempo != Integer.MAX_VALUE) {
                    System.out.println(centro + ": " + tiempo + " minutos");
                } else {
                    System.out.println(centro + ": No es alcanzable desde " + centroPrincipal);
                }
            }
        }
    }
}
