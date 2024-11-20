package sudoku;

public class SudokuSolver {
    private static final int SIZE = 6; // Tamaño del tablero
    private static final int SUBGRID_ROWS = 2; // Filas en cada subcuadrante
    private static final int SUBGRID_COLS = 3; // Columnas en cada subcuadrante

    // Método que resuelve el Sudoku usando backtracking
    public boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { // Encuentra una celda vacía
                    for (int num = 1; num <= SIZE; num++) { // Números válidos del 1 al 6
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursivamente intenta resolver el tablero
                            if (solveSudoku(board)) {
                                return true;
                            }

                            // Deshacer el intento si falla
                            board[row][col] = 0;
                        }
                    }
                    return false; // Si ningún número es válido, retrocede
                }
            }
        }
        return true; // El tablero está completo y es válido
    }

    // Método para verificar si un número puede ser colocado en una posición
    private boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar si el número está en la fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verificar si el número está en la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verificar si el número está en el subcuadrante 2x3
        int startRow = row - row % SUBGRID_ROWS;
        int startCol = col - col % SUBGRID_COLS;
        for (int i = 0; i < SUBGRID_ROWS; i++) {
            for (int j = 0; j < SUBGRID_COLS; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true; // Si pasa todas las pruebas, es válido
    }
}

