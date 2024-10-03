import java.util.Arrays;
import java.util.Comparator;

public class SeleccionPaquetesInversionGreedy {

    public static void main(String[] args) {
        int[] costos = { 12, 20, 15, 25 };
        int[] ganancias = { 150, 200, 100, 300 };
        int presupuesto = 35;

        int numeroPaquetes = costos.length;

  
        Paquete[] paquetes = new Paquete[numeroPaquetes];
        for (int i = 0; i < numeroPaquetes; i++) {
            paquetes[i] = new Paquete(i + 1, costos[i], ganancias[i]);
        }

      
        Arrays.sort(paquetes, new Comparator<Paquete>() {
            @Override
            public int compare(Paquete p1, Paquete p2) {
                double ratio1 = (double) p1.ganancia / p1.costo;
                double ratio2 = (double) p2.ganancia / p2.costo;
                return Double.compare(ratio2, ratio1); // Orden descendente
            }
        });

        int gananciaTotal = 0;
        int costoTotal = 0;
        StringBuilder paquetesSeleccionados = new StringBuilder();

        // Seleccionar paquetes mientras no se exceda el presupuesto
        for (Paquete paquete : paquetes) {
            if (costoTotal + paquete.costo <= presupuesto) {
                costoTotal += paquete.costo;
                gananciaTotal += paquete.ganancia;
                paquetesSeleccionados.append(paquete.id).append(" ");
            }
        }

        
        System.out.println("Ganancia total obtenida (Greedy): " + gananciaTotal);
        System.out.println("Paquetes seleccionados: " + paquetesSeleccionados.toString());
    }
}

class Paquete {
    int id;
    int costo;
    int ganancia;

    Paquete(int id, int costo, int ganancia) {
        this.id = id;
        this.costo = costo;
        this.ganancia = ganancia;
    }
}
