import viajes.SeleccionDeViajes;

public class Main {
    public static void main(String[] args) {
        SeleccionDeViajes sistemaViajes = new SeleccionDeViajes();

        // Agregar rutas entre destinos
        sistemaViajes.agregarRuta("CiudadA", "CiudadB", 50);
        sistemaViajes.agregarRuta("CiudadA", "CiudadC", 100);
        sistemaViajes.agregarRuta("CiudadB", "CiudadC", 30);
        sistemaViajes.agregarRuta("CiudadB", "CiudadD", 80);
        sistemaViajes.agregarRuta("CiudadC", "CiudadE", 60);
        sistemaViajes.agregarRuta("CiudadD", "CiudadE", 40);

        // Especificar ciudad de inicio y destino final
        String ciudadInicio = "CiudadA";
        String ciudadDestino = "CiudadE";

        // Ejecutar UCS para encontrar el costo mínimo
        int costoTotal = sistemaViajes.buscarCostoMinimo(ciudadInicio, ciudadDestino);

        if (costoTotal != -1) {
            System.out.println("El costo mínimo desde " + ciudadInicio + " hasta " + ciudadDestino + " es: " + costoTotal);
        } else {
            System.out.println("No se encontró un camino desde " + ciudadInicio + " hasta " + ciudadDestino);
        }
    }
}