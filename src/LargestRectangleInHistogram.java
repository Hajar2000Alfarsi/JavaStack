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

        // Bonus Test: Largest rectangle in binary matrix
        System.out.println("\n=========== BONUS: BINARY MATRIX ===========");

        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        int maxRectangle = largestRectangleInBinaryMatrix(matrix);

        System.out.println("Largest Rectangle in Binary Matrix = " + maxRectangle);
    }


    // Main O(n) stack-based algorithm
    public static int findLargestRectangle(int[] heights) {
        // Edge case: empty histogram
        if (heights.length == 0) {
            System.out.println("Empty histogram.");
            return 0;
        }

        stack.clear();

        int maxArea = 0;
        int index = 0;

        System.out.println("\n--- Step-by-Step Stack Processing ---");

        while (index < heights.length) {
            // Push index if stack is empty or current bar is taller
            if (stack.isEmpty()
                    || heights[index] >= heights[stack.peek()]) {

                stack.push(index);

                System.out.println("Push index " + index +
                        " (height = " + heights[index] + ")");

                System.out.println("Stack: " + stack);

                index++;
            }

            else {
        }
    }

}
