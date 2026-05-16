import java.util.Stack;

public class LargestRectangleInHistogram {
    // Stack to store indices of histogram bars
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        // Different histogram test cases
        int[][] testCases = {
                {2, 1, 5, 6, 2, 3},
                {2, 4},
                {6, 2, 5, 4, 5, 1, 6},
                {1, 1, 1, 1},
                {5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5},
                {7},
                {}
        };

        // Test all histograms
        for (int i = 0; i < testCases.length; i++) {

            System.out.println("\n======================================");
            System.out.println("Histogram Test Case " + (i + 1));

            int[] heights = testCases[i];

            displayHistogram(heights);

            int maxArea = findLargestRectangle(heights);

            displayResult(heights, maxArea);

            System.out.println("======================================");
        }
    }

}
