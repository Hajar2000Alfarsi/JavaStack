import java.util.Stack;

public class StackSorter {
    // Iterative method using temporary stack
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        // Temporary stack
        Stack<Integer> tempStack = new Stack<>();

        System.out.println("\n=== ITERATIVE SORTING PROCESS ===");

        // Process until original stack becomes empty
        while (!stack.isEmpty()) {
            // Remove top element
            int current = stack.pop();

            System.out.println("\nPopped from Original Stack: " + current);

            //Move elements back if they are smaller
            while (!tempStack.isEmpty()
                    && tempStack.peek() < current) {

                int moved = tempStack.pop();

                stack.push(moved);

                System.out.println(
                        "Moved " + moved +
                                " back to Original Stack"
                );
            }
            // Push current element in correct position
            tempStack.push(current);

            System.out.println(
                    "Pushed " + current +
                            " into Temp Stack"
            );

            // Display stacks
            displayStack(stack, "Original Stack");
            displayStack(tempStack, "Temp Stack");

        }
        return tempStack;
    }


    // Recursive sorting method
    public static void sortStackRecursive(Stack<Integer> stack) {
        // Base case
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int top = stack.pop();

        // Recursively sort remaining stack
        sortStackRecursive(stack);

        // Insert in sorted order
        insertInSortedOrder(stack, top);
    }


    // Helper method for recursive sort
    public static void insertInSortedOrder(Stack<Integer> stack, int value) {
        // Insert if stack empty OR value larger
        if (stack.isEmpty() || value > stack.peek()) {

            stack.push(value);

            return;
        }

        // Remove top element
        int top = stack.pop();

        // Recursive call
        insertInSortedOrder(stack, value);

        // Restore removed element
        stack.push(top);
    }


    // Display stack contents
    public static void displayStack(
            Stack<Integer> stack,
            String name) {

        System.out.println(name + ": " + stack);
    }


    // Compare iterative and recursive approaches
    public static void compareApproaches() {

        System.out.println("\n========== COMPARISON ==========");

        System.out.println("\nIterative Approach:");
        System.out.println("- Uses temporary stack");
        System.out.println("- Easier to understand");
        System.out.println("- Space Complexity: O(n)");

        System.out.println("\nRecursive Approach:");
        System.out.println("- Uses recursion call stack");
        System.out.println("- Cleaner implementation");
        System.out.println("- Space Complexity: O(n)");

        System.out.println("\nTime Complexity:");
        System.out.println("- Best Case: O(n)");
        System.out.println("- Worst Case: O(n²)");
    }


    // Main method
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(1);
        s1.push(4);
        s1.push(2);

        System.out.println("Befor sorting : ");
        displayStack(s1,"Stak1");
        System.out.println("After sorting : ");
        Stack <Integer>sorted1 =sortStack(s1);
        displayStack(sorted1,"sorted Stack");

        Stack<Integer> s2 = new Stack<>();
        s2.push(3);
        s2.push(1);
        s2.push(4);
        s2.push(2);
        System.out.println("Befor sorting : ");
        displayStack(s2,"Stak2");
        sortStackRecursive(s2);
        displayStack(s2, "Sorted Stack (Recursive)");
    }


    }
