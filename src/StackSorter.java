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
        }
    }
}
