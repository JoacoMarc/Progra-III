import java.util.ArrayList;
import java.util.List;

public class SeleccionPaquetesInversionFuerzaBruta {

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300}; 
        int presupuesto = 35; 

        int numeroPaquetes = costos.length;
        int maxGanancia = 0;
        List<Integer> mejorCombinacion = new ArrayList<>();


        int totalCombinaciones = (int) Math.pow(2, numeroPaquetes);
        for (int i = 1; i < totalCombinaciones; i++) {
            List<Integer> combinacionActual = new ArrayList<>();
            int gananciaActual = 0;
            int costoActual = 0;

            for (int j = 0; j < numeroPaquetes; j++) {
                if ((i & (1 << j)) != 0) {
                    costoActual += costos[j];
                    gananciaActual += ganancias[j];
                    combinacionActual.add(j + 1); 
                }
            }

           
            if (costoActual <= presupuesto) {
                if (gananciaActual > maxGanancia) {
                    maxGanancia = gananciaActual;
                    mejorCombinacion = new ArrayList<>(combinacionActual);
                } else if (gananciaActual == maxGanancia && costoActual < presupuesto) {
                    mejorCombinacion = new ArrayList<>(combinacionActual);
                }
            }
        }

      
        System.out.println("Ganancia máxima obtenida (Fuerza Bruta): " + maxGanancia);
        System.out.print("Paquetes seleccionados: ");
        for (int paquete : mejorCombinacion) {
            System.out.print(paquete + " ");
        }
        System.out.println();
    }
}
