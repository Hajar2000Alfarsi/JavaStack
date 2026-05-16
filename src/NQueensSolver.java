import java.util.ArrayList;
import java.util.List;

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

        }
    }
}
