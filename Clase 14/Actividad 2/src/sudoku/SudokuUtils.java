package sudoku;

public class SudokuUtils {

    // Método para imprimir el tablero
    public static void printBoard(int[][] board) {
        int size = board.length; // Tamaño del tablero (6x6)
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
