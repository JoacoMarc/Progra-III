public class DistribucionEquiposBacktracking {

    private static final int TAMANO = 4; // Tamaño del tablero (4x4)
    private static final int NUM_COMPUTADORAS = 4; // Número de computadoras a colocar
    private static final int NUM_IMPRESORAS = 4; // Número de impresoras a colocar
    private static int conteoSoluciones = 0; // Contador de soluciones encontradas

    public static void main(String[] args) {
        char[][] tablero = new char[TAMANO][TAMANO];

        // Inicializar el tablero con puntos (vacío)
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = '.';
            }
        }

        // Arreglos para rastrear filas y columnas ocupadas por computadoras
        boolean[] filasOcupadasComputadoras = new boolean[TAMANO];
        boolean[] columnasOcupadasComputadoras = new boolean[TAMANO];

        // Iniciar el backtracking para colocar las computadoras
        colocarComputadoras(tablero, 0, 0, filasOcupadasComputadoras, columnasOcupadasComputadoras);

        System.out.println("Total de configuraciones válidas: " + conteoSoluciones);
    }

    /**
     * Método recursivo para colocar las computadoras utilizando backtracking.
     *
     * @param tablero                    El tablero de 4x4.
     * @param computadoraActual          Número de computadoras colocadas hasta el momento.
     * @param fila                       Fila actual para intentar colocar una computadora.
     * @param filasOcupadas              Arreglo que rastrea las filas ocupadas por computadoras.
     * @param columnasOcupadas           Arreglo que rastrea las columnas ocupadas por computadoras.
     */
    private static void colocarComputadoras(char[][] tablero, int computadoraActual, int fila,
                                            boolean[] filasOcupadas, boolean[] columnasOcupadas) {
        // Caso base: si se han colocado todas las computadoras
        if (computadoraActual == NUM_COMPUTADORAS) {
            // Una vez colocadas las computadoras, proceder a colocar las impresoras
            colocarImpresoras(tablero, 0, 0, new boolean[TAMANO], new boolean[TAMANO]);
            return;
        }

        // Iterar sobre las filas a partir de la fila actual
        for (int i = fila; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                // Verificar si la fila y columna están libres para colocar una computadora
                if (!filasOcupadas[i] && !columnasOcupadas[j] && tablero[i][j] == '.') {
                    // Colocar la computadora
                    tablero[i][j] = 'C';
                    filasOcupadas[i] = true;
                    columnasOcupadas[j] = true;

                    // Llamada recursiva para colocar la siguiente computadora
                    colocarComputadoras(tablero, computadoraActual + 1, i + 1, filasOcupadas, columnasOcupadas);

                    // Backtrack: quitar la computadora y desmarcar las posiciones
                    tablero[i][j] = '.';
                    filasOcupadas[i] = false;
                    columnasOcupadas[j] = false;
                }
            }
        }
    }

    /**
     * Método recursivo para colocar las impresoras utilizando backtracking.
     *
     * @param tablero                   El tablero de 4x4 con computadoras ya colocadas.
     * @param impresoraActual           Número de impresoras colocadas hasta el momento.
     * @param fila                      Fila actual para intentar colocar una impresora.
     */
    private static void colocarImpresoras(char[][] tablero, int impresoraActual, int fila,
                                          boolean[] filasOcupadas, boolean[] columnasOcupadas) {
        // Caso base: si se han colocado todas las impresoras
        if (impresoraActual == NUM_IMPRESORAS) {
            // Imprimir la configuración válida del tablero
            imprimirTablero(tablero);
            conteoSoluciones++;
            return;
        }

        // Iterar sobre las filas a partir de la fila actual
        for (int i = fila; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                // Verificar si la celda está libre y las filas y columnas están libres para una impresora
                if (!filasOcupadas[i] && !columnasOcupadas[j] && tablero[i][j] == '.') {
                    // Colocar la impresora
                    tablero[i][j] = 'I';
                    filasOcupadas[i] = true;
                    columnasOcupadas[j] = true;

                    // Llamada recursiva para colocar la siguiente impresora
                    colocarImpresoras(tablero, impresoraActual + 1, i + 1, filasOcupadas, columnasOcupadas);

                    // Backtrack: quitar la impresora y desmarcar las posiciones
                    tablero[i][j] = '.';
                    filasOcupadas[i] = false;
                    columnasOcupadas[j] = false;
                }
            }
        }
    }

    /**
     * Imprime el tablero en la consola.
     *
     * @param tablero El tablero de 4x4 con computadoras e impresoras colocadas.
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
