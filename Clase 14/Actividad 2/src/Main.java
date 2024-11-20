package sudoku;

public class Main {

    public static void main(String[] args) {
        // Tablero inicial de 6x6 con solución válida
        int[][] board = {
                {1, 0, 0, 4, 0, 0},
                {0, 4, 0, 0, 0, 6},
                {0, 0, 6, 0, 1, 0},
                {0, 5, 0, 0, 6, 0},
                {6, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 0}
        };

        SudokuSolver solver = new SudokuSolver();

        if (solver.solveSudoku(board)) {
            SudokuUtils.printBoard(board);
        } else {
            System.out.println("No existe solución para este Sudoku.");
        }
    }
}
