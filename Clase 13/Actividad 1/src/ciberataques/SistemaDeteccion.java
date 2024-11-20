package ciberataques;

public class SistemaDeteccion {

    // Método principal de poda alfa-beta
    public static int alfaBeta(Nodo nodo, int profundidad, int alfa, int beta, boolean esMaximizador) {
        // Caso base: Si alcanzamos un nodo terminal o la profundidad máxima
        if (nodo == null || nodo.esNodoTerminal() || profundidad == 0) {
            return nodo != null ? nodo.obtenerValor() : 0;  // Evaluar el nodo
        }

        if (esMaximizador) {
            int mejorValor = Integer.MIN_VALUE;  // Peor valor inicial para el maximizador
            for (Nodo hijo : nodo.obtenerHijos()) {
                if (hijo != null) {  // Asegúrate de que el hijo no sea null
                    int valor = alfaBeta(hijo, profundidad - 1, alfa, beta, false);
                    mejorValor = Math.max(mejorValor, valor);  // Elegir el valor máximo
                    alfa = Math.max(alfa, mejorValor);  // Actualizar alfa
                    if (beta <= alfa) {
                        break;  // Poda beta
                    }
                }
            }
            return mejorValor;
        } else {
            int mejorValor = Integer.MAX_VALUE;  // Peor valor inicial para el minimizador
            for (Nodo hijo : nodo.obtenerHijos()) {
                if (hijo != null) {  // Asegúrate de que el hijo no sea null
                    int valor = alfaBeta(hijo, profundidad - 1, alfa, beta, true);
                    mejorValor = Math.min(mejorValor, valor);  // Elegir el valor mínimo
                    beta = Math.min(beta, mejorValor);  // Actualizar beta
                    if (beta <= alfa) {
                        break;  // Poda alfa
                    }
                }
            }
            return mejorValor;
        }
    }
}