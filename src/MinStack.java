import java.util.Stack;

public class MinStack {
    // Main stack stores all elements
    private Stack<Integer> mainStack;

    // Min stack stores minimum values
    private Stack<Integer> minStack;

    // Constructor
    public MinStack() {

        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element into stack
    public void push(int value) {
        // Push into main stack
        mainStack.push(value);

        // Push into min stack if:
        // min stack is empty OR value <= current minimum
        if (minStack.isEmpty() || value <= minStack.peek()) {

            minStack.push(value);
        }

        System.out.println("\nPUSH: " + value);

        display();
    }


    // Pop element from stack
    public Integer pop() {
        // Check if stack is empty
        if (mainStack.isEmpty()) {

            System.out.println("\nStack is empty. Cannot pop.");

            return null;
        }

        // Remove top element
        int removed = mainStack.pop();

        // Sync min stack
        if (removed == minStack.peek()) {

            minStack.pop();
        }

        System.out.println("\nPOP: " + removed);

        display();

        return removed;
    }
}
