import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementFinder {
    public static int[] findNextGreaterElement(int[] arr) {
        // Handle empty array
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int n = arr.length;

        // Result array
        int[] result = new int[n];

        // Fill with -1 by default
        Arrays.fill(result, -1);

        // Stack stores indices
        Stack<Integer> stack = new Stack<>();
        System.out.println("\n=== NEXT GREATER ELEMENT PROCESS ===");

        // Traverse array
        for (int i = 0; i < n; i++) {
            System.out.println("\nCurrent Element: " + arr[i]);

            // Pop while current element is greater
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {

            }
        }
    }
}
