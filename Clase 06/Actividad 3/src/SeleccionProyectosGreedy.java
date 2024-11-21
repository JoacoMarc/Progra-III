import java.util.Arrays;
import java.util.Comparator;


public class SeleccionProyectosGreedy {

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25}; 
        int[] beneficios = {100, 200, 150, 300}; 
        int presupuesto = 40; 

        int numeroProyectos = costos.length;

        // Arreglo de proyectos con costo, beneficio y ratio beneficio/costo
        Proyecto[] proyectos = new Proyecto[numeroProyectos];
        for (int i = 0; i < numeroProyectos; i++) {
            proyectos[i] = new Proyecto(i + 1, costos[i], beneficios[i]);
        }

        // Ordenar los proyectos por ratio beneficio/costo en orden descendente
        Arrays.sort(proyectos, new Comparator<Proyecto>() {
            @Override
            public int compare(Proyecto p1, Proyecto p2) {
                double ratio1 = (double) p1.beneficio / p1.costo;
                double ratio2 = (double) p2.beneficio / p2.costo;
                return Double.compare(ratio2, ratio1); // Orden descendente
            }
        });

        int beneficioTotal = 0;
        int costoTotal = 0;
        StringBuilder proyectosSeleccionados = new StringBuilder();

        // Seleccionar proyectos mientras no se exceda el presupuesto
        for (Proyecto proyecto : proyectos) {
            if (costoTotal + proyecto.costo <= presupuesto) {
                costoTotal += proyecto.costo;
                beneficioTotal += proyecto.beneficio;
                proyectosSeleccionados.append(proyecto.id).append(" ");
            }
        }

        System.out.println("Beneficio total obtenido (Greedy): " + beneficioTotal);
        System.out.println("Proyectos seleccionados: " + proyectosSeleccionados.toString());
    }
}

class Proyecto {
    int id;
    int costo;
    int beneficio;

    Proyecto(int id, int costo, int beneficio) {
        this.id = id;
        this.costo = costo;
        this.beneficio = beneficio;
    }
}
