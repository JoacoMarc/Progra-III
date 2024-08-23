package src;

public class BusquedaBinariaAct {
    // Método para realizar la búsqueda binaria
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Verificar si el objetivo está en el medio
            if (arreglo[medio] == objetivo) {
                return medio; // Retorna el índice del objetivo
            }

            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1;
            }
            // Si el objetivo es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }

        // Si no se encuentra el objetivo, retorna -1
        return -1;
    }
}
