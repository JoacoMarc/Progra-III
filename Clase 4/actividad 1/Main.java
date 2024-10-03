//Dada una lista de monedas con denominaciones convencionales (1, 5, 10, 25, etc.), 
//implementar una función greedy que determine si es posible entregar un cambio exacto utilizando una lista de monedas disponible. 
//Realizar pseudocódigo e implementación en Java. Indicar la complejidad algorítmica.

package clase_4.actividad_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> denominaciones = new ArrayList<>();
        denominaciones.add(1);
        denominaciones.add(5);
        denominaciones.add(10);
        denominaciones.add(25);
        denominaciones.add(50);
        denominaciones.add(100);

        double cambio = 525;
        System.out.println("Es posible dar cambio: " + darCambio(denominaciones, cambio));
    }

    public static boolean darCambio(List<Integer> denominaciones, double cambio) {
        Collections.sort(denominaciones, Collections.reverseOrder());
        int i = 0;
        while (cambio > 0 && i < denominaciones.size()) {
            if (denominaciones.get(i) <= cambio) {
                cambio -= denominaciones.get(i);
            } else {
                i++;
            }
        }
        return cambio == 0;
    }
}
