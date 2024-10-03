import java.util.ArrayList;
import java.util.List;

public class SeleccionPaquetesInversionFuerzaBruta {

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25}; // Costos de los paquetes de inversión
        int[] ganancias = {150, 200, 100, 300}; // Ganancias esperadas de los paquetes
        int presupuesto = 35; // Presupuesto disponible

        int numeroPaquetes = costos.length;
        int maxGanancia = 0;
        List<Integer> mejorCombinacion = new ArrayList<>();

        // Generar todas las posibles combinaciones de paquetes
        int totalCombinaciones = (int) Math.pow(2, numeroPaquetes);
        for (int i = 1; i < totalCombinaciones; i++) {
            List<Integer> combinacionActual = new ArrayList<>();
            int gananciaActual = 0;
            int costoActual = 0;

            for (int j = 0; j < numeroPaquetes; j++) {
                if ((i & (1 << j)) != 0) {
                    costoActual += costos[j];
                    gananciaActual += ganancias[j];
                    combinacionActual.add(j + 1); // Guardamos el índice del paquete (1-based)
                }
            }

            // Verificar si la combinación es válida y si mejora la ganancia máxima
            if (costoActual <= presupuesto) {
                if (gananciaActual > maxGanancia) {
                    maxGanancia = gananciaActual;
                    mejorCombinacion = new ArrayList<>(combinacionActual);
                } else if (gananciaActual == maxGanancia && costoActual < presupuesto) {
                    // En caso de empate en ganancia, elegir la combinación con menor costo
                    mejorCombinacion = new ArrayList<>(combinacionActual);
                }
            }
        }

        // Mostrar los resultados
        System.out.println("Ganancia máxima obtenida (Fuerza Bruta): " + maxGanancia);
        System.out.print("Paquetes seleccionados: ");
        for (int paquete : mejorCombinacion) {
            System.out.print(paquete + " ");
        }
        System.out.println();
    }
}
