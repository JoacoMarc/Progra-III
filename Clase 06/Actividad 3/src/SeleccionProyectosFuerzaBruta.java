import java.util.ArrayList;
import java.util.List;

public class SeleccionProyectosFuerzaBruta {

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25}; 
        int[] beneficios = {100, 200, 150, 300}; 
        int presupuesto = 40; 

        int numeroProyectos = costos.length;
        int maxBeneficio = 0;
        List<Integer> mejorCombinacion = new ArrayList<>();

        // Generar todas las posibles combinaciones de proyectos
        int totalCombinaciones = (int) Math.pow(2, numeroProyectos);
        for (int i = 1; i < totalCombinaciones; i++) {
            List<Integer> combinacionActual = new ArrayList<>();
            int beneficioActual = 0;
            int costoActual = 0;

            for (int j = 0; j < numeroProyectos; j++) {
                if ((i & (1 << j)) != 0) {
                    costoActual += costos[j];
                    beneficioActual += beneficios[j];
                    combinacionActual.add(j + 1);
                }
            }

            // Verificar si la combinación es válida y si mejora el beneficio máximo
            if (costoActual <= presupuesto && beneficioActual > maxBeneficio) {
                maxBeneficio = beneficioActual;
                mejorCombinacion = new ArrayList<>(combinacionActual);
            }
        }

        // Mostrar los resultados
        System.out.println("Beneficio máximo obtenido (Fuerza Bruta): " + maxBeneficio);
        System.out.print("Proyectos seleccionados: ");
        for (int proyecto : mejorCombinacion) {
            System.out.print(proyecto + " ");
        }
        System.out.println();
    }
}
