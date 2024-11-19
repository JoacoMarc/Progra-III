public class DiseñoInterioresBacktracking {

    private static final int TAMANO = 4; // Tamaño del tablero (4x4)
    private static final int NUM_ESCRITORIOS = 2; // Número de escritorios a colocar
    private static final int NUM_SILLAS = 2; // Número de sillas a colocar
    private static int conteoSoluciones = 0; // Contador de soluciones encontradas

    public static void main(String[] args) {
        char[][] tablero = new char[TAMANO][TAMANO];

        // Inicializar el tablero con puntos (vacío)
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = '.';
            }
        }

        // Arreglos para rastrear filas y columnas ocupadas
        boolean[] filasOcupadas = new boolean[TAMANO];
        boolean[] columnasOcupadas = new boolean[TAMANO];

        // Iniciar el backtracking
        resolver(tablero, 0, 0, 0, filasOcupadas, columnasOcupadas);

        System.out.println("Total de configuraciones válidas: " + conteoSoluciones);
    }

    /**
     * Método recursivo para colocar escritorios y sillas utilizando backtracking.
     *
     * @param tablero          El tablero de 4x4.
     * @param fila             La fila actual en el tablero.
     * @param escritoriosCol   Número de escritorios colocados hasta el momento.
     * @param sillasCol        Número de sillas colocadas hasta el momento.
     * @param filasOcupadas    Arreglo que rastrea las filas ocupadas.
     * @param columnasOcupadas Arreglo que rastrea las columnas ocupadas.
     */
    private static void resolver(char[][] tablero, int fila, int escritoriosCol, int sillasCol,
                                 boolean[] filasOcupadas, boolean[] columnasOcupadas) {
        // Caso base: si se han colocado todos los escritorios y sillas
        if (escritoriosCol == NUM_ESCRITORIOS && sillasCol == NUM_SILLAS) {
            imprimirTablero(tablero);
            conteoSoluciones++;
            return;
        }

        // Si hemos pasado todas las filas, retornar
        if (fila == TAMANO) {
            return;
        }

        // Intentar no colocar ningún elemento en la fila actual
        resolver(tablero, fila + 1, escritoriosCol, sillasCol, filasOcupadas, columnasOcupadas);

        // Recorrer todas las columnas en la fila actual para intentar colocar un escritorio o una silla
        for (int columna = 0; columna < TAMANO; columna++) {
            if (!filasOcupadas[fila] && !columnasOcupadas[columna]) {
                // Intentar colocar un Escritorio
                if (escritoriosCol < NUM_ESCRITORIOS) {
                    tablero[fila][columna] = 'E';
                    filasOcupadas[fila] = true;
                    columnasOcupadas[columna] = true;

                    resolver(tablero, fila + 1, escritoriosCol + 1, sillasCol, filasOcupadas, columnasOcupadas);

                    // Backtrack: quitar el Escritorio y desmarcar las posiciones
                    tablero[fila][columna] = '.';
                    filasOcupadas[fila] = false;
                    columnasOcupadas[columna] = false;
                }

                // Intentar colocar una Silla
                if (sillasCol < NUM_SILLAS) {
                    tablero[fila][columna] = 'S';
                    filasOcupadas[fila] = true;
                    columnasOcupadas[columna] = true;

                    resolver(tablero, fila + 1, escritoriosCol, sillasCol + 1, filasOcupadas, columnasOcupadas);

                    // Backtrack: quitar la Silla y desmarcar las posiciones
                    tablero[fila][columna] = '.';
                    filasOcupadas[fila] = false;
                    columnasOcupadas[columna] = false;
                }
            }
        }
    }

    /**
     * Imprime el tablero en la consola.
     *
     * @param tablero El tablero de 4x4.
     */
    private static void imprimirTablero(char[][] tablero) {
        System.out.println("Configuración #" + (conteoSoluciones + 1));
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
