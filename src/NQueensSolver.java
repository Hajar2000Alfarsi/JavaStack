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
            }
            if (n == 2 || n == 3) {
                System.out.println("No solutions exist for N = " + n);
                return;
            }

            // Stack to store queens
            Stack<Position> queens = new Stack<>();

            int row = 0;
            int col = 0;

            while (true) {

                boolean queenPlaced = false;

                // Try placing queen in current row
                while (col < n) {

                    Position pos = new Position(row, col);

                    // Check if safe
                    if (isSafe(pos, queens)) {

                        // Push queen onto stack
                        queens.push(pos);

                        System.out.println("\nPlaced Queen at: " + pos);
                        System.out.println("Stack: " + queens);

                        // Show detailed steps only for N=4
                        if (n == 4) {
                            displayBoard(queens, n);
                        }

                        queenPlaced = true;

                        row++;

                        col = 0;

                        break;
                    }

                    col++;
                }

                // If all queens placed
                if (row == n) {

                    System.out.println("\nSolution Found!");
                    displayBoard(queens, n);

                    // Store solution
                    allSolutions.add(new ArrayList<>(queens));

                    // Backtrack
                    Position last = queens.pop();

                    row = last.row;
                    col = last.col + 1;

                    continue;
                }

                // If queen not placed -> backtrack
                if (!queenPlaced) {

                    // No more solutions
                    if (queens.isEmpty()) {
                        break;
                    }

                    // Pop previous queen
                    Position last = queens.pop();

                    System.out.println("\nBacktracking from: " + last);
                    System.out.println("Stack After Pop: " + queens);

                    row = last.row;
                    col = last.col + 1;
                }

            }
        }

        // Check if queen position is safe
        public static boolean isSafe(Position pos,
                                     Stack<Position> queens) {

            for (Position queen : queens) {
                // Same column
                if (queen.col == pos.col) {
                    return false;
            }
}
