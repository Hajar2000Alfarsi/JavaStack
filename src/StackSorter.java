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

}
