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
                int index = stack.pop();

                result[index] = arr[i];

                System.out.println(
                        "Popped Index: " + index +
                                " -> Next Greater for " + arr[index] +
                                " is " + arr[i]
                );
            }
            // Push current index
            stack.push(i);

            System.out.println("Pushed Index: " + i);
            System.out.println("Current Stack: " + stack);
        }
        // Remaining elements have no greater element
        while (!stack.isEmpty()) {
            int index = stack.pop();

            System.out.println(
                    "No greater element for " + arr[index]
            );
        }

        return result;
    }

    public static int[] findNextSmallerElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int n = arr.length;

        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {

                int index = stack.pop();

                result[index] = arr[i];
            }

            stack.push(i);
        }

        return result;
    }

    public static int[] findNextGreaterElementCircular(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int n = arr.length;

        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int currentIndex = i % n;

            while (!stack.isEmpty()
                    && arr[currentIndex] > arr[stack.peek()]) {

                int index = stack.pop();

                result[index] = arr[currentIndex];
            }
            if (i < n) {
                stack.push(currentIndex);
            }
        }
    }
}


