public class DosMayores {

    // Método para encontrar los dos números más grandes utilizando Divide y Conquista
    public int[] encontrarDosMayores(int[] lista, int inicio, int fin) {
        if (inicio == fin) {
            return new int[]{lista[inicio], Integer.MIN_VALUE};  // Un solo elemento
        }

        if (fin - inicio == 1) {  // Dos elementos
            if (lista[inicio] > lista[fin]) {
                return new int[]{lista[inicio], lista[fin]};
            } else {
                return new int[]{lista[fin], lista[inicio]};
            }
        }

        // Dividir el array en dos mitades
        int medio = (inicio + fin) / 2;
        int[] izquierda = encontrarDosMayores(lista, inicio, medio);
        int[] derecha = encontrarDosMayores(lista, medio + 1, fin);

        // Comparar los resultados de las dos mitades
        int mayor = Math.max(izquierda[0], derecha[0]);
        int segundoMayor;

        if (mayor == izquierda[0]) {
            segundoMayor = Math.max(izquierda[1], derecha[0]);
        } else {
            segundoMayor = Math.max(derecha[1], izquierda[0]);
        }

        return new int[]{mayor, segundoMayor};
    }
}
