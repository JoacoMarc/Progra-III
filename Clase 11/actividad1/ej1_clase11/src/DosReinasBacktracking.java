public class DosReinasBacktracking {

    private static final int TAMAÑO = 4; // Tamaño del tablero (4x4)
    private static final int NUM_REINAS = 2; // Número de reinas a colocar
    private static int conteoSoluciones = 0; // Contador de soluciones encontradas

    public static void main(String[] args) {
        char[][] tablero = new char[TAMAÑO][TAMAÑO];

        // Inicializar el tablero con puntos (vacío)
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                tablero[i][j] = '.';
            }
        }

        // Arreglos para rastrear columnas y diagonales ocupadas
        boolean[] columnas = new boolean[TAMAÑO];
        boolean[] diagonalesPrincipales = new boolean[2 * TAMAÑO - 1]; // Diagonales principales
        boolean[] diagonalesSecundarias = new boolean[2 * TAMAÑO - 1]; // Diagonales secundarias

        // Iniciar el backtracking
        resolver(tablero, 0, 0, columnas, diagonalesPrincipales, diagonalesSecundarias);

        System.out.println("Total de configuraciones válidas: " + conteoSoluciones);
    }

    /**
     * Método recursivo para colocar las reinas utilizando backtracking.
     *
     * @param tablero             El tablero de ajedrez.
     * @param filaActual          La fila actual.
     * @param reinasColocadas     Número de reinas colocadas hasta el momento.
     * @param columnasOcupadas    Columnas ocupadas.
     * @param diagPrincipales     Diagonales principales ocupadas.
     * @param diagSecundarias     Diagonales secundarias ocupadas.
     */
    private static void resolver(char[][] tablero, int filaActual, int reinasColocadas, boolean[] columnasOcupadas,
                                 boolean[] diagPrincipales, boolean[] diagSecundarias) {
        // Caso base: si se han colocado todas las reinas
        if (reinasColocadas == NUM_REINAS) {
            imprimirTablero(tablero);
            conteoSoluciones++;
            return;
        }

        // Recorrer todas las filas y columnas para colocar la siguiente reina
        for (int fila = filaActual; fila < TAMAÑO; fila++) {
            for (int columna = 0; columna < TAMAÑO; columna++) {
                if (esSeguro(fila, columna, columnasOcupadas, diagPrincipales, diagSecundarias)) {
                    // Colocar la reina
                    tablero[fila][columna] = 'Q';
                    columnasOcupadas[columna] = true;
                    diagPrincipales[fila + columna] = true;
                    diagSecundarias[fila - columna + TAMAÑO - 1] = true;

                    // Llamada recursiva para colocar la siguiente reina
                    resolver(tablero, fila + 1, reinasColocadas + 1, columnasOcupadas, diagPrincipales, diagSecundarias);

                    // Backtrack: quitar la reina y desmarcar las posiciones
                    tablero[fila][columna] = '.';
                    columnasOcupadas[columna] = false;
                    diagPrincipales[fila + columna] = false;
                    diagSecundarias[fila - columna + TAMAÑO - 1] = false;
                }
            }
        }
    }

    /**
     * Verifica si es seguro colocar una reina en la posición (fila, columna).
     *
     * @param fila               La fila.
     * @param columna            La columna.
     * @param columnasOcupadas   Columnas ocupadas.
     * @param diagPrincipales    Diagonales principales ocupadas.
     * @param diagSecundarias    Diagonales secundarias ocupadas.
     * @return True si es seguro, de lo contrario, false.
     */
    private static boolean esSeguro(int fila, int columna, boolean[] columnasOcupadas,
                                    boolean[] diagPrincipales, boolean[] diagSecundarias) {
        return !columnasOcupadas[columna] &&
                !diagPrincipales[fila + columna] &&
                !diagSecundarias[fila - columna + TAMAÑO - 1];
    }

    /**
     * Imprime el tablero en la consola.
     *
     * @param tablero El tablero de ajedrez.
     */
    private static void imprimirTablero(char[][] tablero) {
        System.out.println("Configuración #" + (conteoSoluciones + 1));
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
