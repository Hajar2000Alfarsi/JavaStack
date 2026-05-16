import java.util.Arrays;
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
                // Pop top index
                int topIndex = stack.pop();

                System.out.println("Pop index " + topIndex +
                        " (height = " + heights[topIndex] + ")");
            }
            // Calculate width
            int width;

            if (stack.isEmpty()) {
                width = index;
            } else {
                width = index - stack.peek() - 1;
            }

            // Calculate area
            int area = heights[topIndex] * width;

            System.out.println("Area = " +
                    heights[topIndex] + " x " + width +
                    " = " + area);

            // Update maximum area
            maxArea = Math.max(maxArea, area);

            System.out.println("Current Max Area = " + maxArea);

            System.out.println("Stack: " + stack);
        }

        // Process remaining bars in stack
        while (!stack.isEmpty()) {

            int topIndex = stack.pop();

            System.out.println("Final Pop index " + topIndex +
                    " (height = " + heights[topIndex] + ")");

            int width;

            if (stack.isEmpty()) {
                width = index;
            } else {
                width = index - stack.peek() - 1;
            }

            int area = heights[topIndex] * width;

            System.out.println("Area = " +
                    heights[topIndex] + " x " + width +
                    " = " + area);

            maxArea = Math.max(maxArea, area);

            System.out.println("Current Max Area = " + maxArea);

            System.out.println("Stack: " + stack);
        }

        return maxArea;

    }

    // Area calculation helper method
    public static int calculateArea(int[] heights,
                                    int start,
                                    int end,
                                    int height) {

        int width = end - start + 1;

        return width * height;
    }


    // Display histogram using ASCII art
    public static void displayHistogram(int[] heights) {

        System.out.println("\nHistogram:");

        // Edge case
        if (heights.length == 0) {
            System.out.println("(empty)");
            return;
        }

        // Find maximum height
        int maxHeight = 0;

        for (int height : heights) {
            maxHeight = Math.max(maxHeight, height);
        }


        // Print histogram vertically
        for (int level = maxHeight; level >= 1; level--) {

            for (int height : heights) {

                if (height >= level) {
                    System.out.print(" █ ");
                } else {
                    System.out.print("   ");
                }
            }

            System.out.println();
        }

        // Print separator
        for (int i = 0; i < heights.length; i++) {
            System.out.print("---");
        }

        System.out.println();

        // Print values
        for (int height : heights) {
            System.out.printf("%2d ", height);
        }

        System.out.println();
    }

    // Display final result
    public static void displayResult(int[] heights, int maxArea) {

        System.out.println("\nHistogram Array: "
                + Arrays.toString(heights));

        System.out.println("Largest Rectangle Area = "
                + maxArea);
    }

    // Brute force O(n²) solution
    public static int bruteForceLargestRectangle(int[] heights) {

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            int minHeight = heights[i];

            for (int j = i; j < heights.length; j++) {

                minHeight = Math.min(minHeight, heights[j]);

                int area = minHeight * (j - i + 1);

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }



}
