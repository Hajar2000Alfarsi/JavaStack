import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NQueensSolver {
    // Class to store queen position
    static class Position {

        int row;
        int col;

        // Constructor
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + ")";
        }

        // Store all solutions
        static List<List<Position>> allSolutions = new ArrayList<>();

        public static void main(String[] args) {
            // Test edge cases
            int[] testCases = {0, 1, 2, 3, 4, 5, 6, 8};

            for (int n : testCases) {

                System.out.println("\n======================================");
                System.out.println("N-Queens Problem for N = " + n);
                System.out.println("======================================");

                displayAllSolutions(n);
            }

            // Compare iterative vs recursive
            comparePerformance(8);
        }


        // Main iterative stack-based solver
        public static void solveNQueens(int n) {
            // Edge cases
            if (n == 0) {
                System.out.println("No board exists.");
                return;
            }

            if (n == 1) {
                Stack<Position> queens = new Stack<>();
                queens.push(new Position(0, 0));

                System.out.println("One solution exists:");
                displayBoard(queens, n);

                return;
            }if (n == 2 || n == 3) {
                System.out.println("No solutions exist for N = " + n);
                return;
            }


        }
}
