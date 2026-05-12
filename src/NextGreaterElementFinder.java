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
        return result;
    }


    public static int[] bruteForceNextGreater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int n = arr.length;

        int[] result = new int[n];

        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[j] > arr[i]) {

                    result[i] = arr[j];

                    break;
                }
            }
        }

        return result;
    }

    public static void displayResults(int[] arr, int[] result) {
        System.out.println("\n---------------------------------------");
        System.out.printf("%-10s %-15s%n", "Element", "Next Value");
        System.out.println("---------------------------------------");

        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%-10d %-15d%n",
                    arr[i],
                    result[i]);
        }

        System.out.println("---------------------------------------");
    }

    public static void compareApproaches() {

        System.out.println("\n=== TIME COMPLEXITY COMPARISON ===");

        System.out.println("Brute Force Approach:");
        System.out.println("- Uses nested loops");
        System.out.println("- Time Complexity: O(n²)");

        System.out.println("\nStack-Based Approach:");
        System.out.println("- Each element pushed once");
        System.out.println("- Each element popped once");
        System.out.println("- Time Complexity: O(n)");
    }

    public static void main(String[] args) {
        int[] test1 = {4, 5, 2, 25};
        int[] test2 = {13, 7, 6, 12};
        int[] test3 = {1, 2, 3, 4, 5};
        int[] test4 = {9, 8, 7, 6, 5};
        int[] test5 = {10};
        int[] test6 = {};

        int[][] testArrays = {
                test1,
                test2,
                test3,
                test4,
                test5,
                test6
        };

        for (int i = 0; i < testArrays.length; i++) {

            System.out.println("\n=====================================");
            System.out.println("TEST CASE " + (i + 1));
            System.out.println("=====================================");

            int[] arr = testArrays[i];

            System.out.println("Input Array: "
                    + Arrays.toString(arr));


            if (arr.length == 0) {

                System.out.println("Array is empty.");
                continue;
            }
        }
    }
}


