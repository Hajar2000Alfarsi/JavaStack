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

    // Peek top element
    public Integer peek() {

        if (mainStack.isEmpty()) {

            System.out.println("\nStack is empty. Nothing to peek.");

            return null;
        }

        int top = mainStack.peek();

        System.out.println("\nPEEK: " + top);

        display();

        return top;
    }


    // Get minimum element in O(1)
    public Integer getMin() {

        if (minStack.isEmpty()) {

            System.out.println("\nStack is empty. No minimum value.");

            return null;
        }

        int min = minStack.peek();

        System.out.println("\nCURRENT MINIMUM: " + min);

        display();

        return min;
    }

    // Check if stack is empty
    public boolean isEmpty() {

        return mainStack.isEmpty();
    }

    // Display both stacks
    public void display() {

        System.out.println("--------------------------------");

        System.out.println("Main Stack : " + mainStack);

        System.out.println("Min Stack  : " + minStack);

        // Display current minimum
        if (!minStack.isEmpty()) {

            System.out.println("Current Min: " + minStack.peek());

        } else {

            System.out.println("Current Min: Stack Empty");
        }

        System.out.println("--------------------------------");
    }

    // Compare both approaches
    public static void compareApproaches() {

        System.out.println("\n========== MEMORY COMPARISON ==========");

        System.out.println("\nApproach 1: Store Min with Each Element");
        System.out.println("- Each stack node stores:");
        System.out.println("  (value, currentMin)");
        System.out.println("- Faster access");
        System.out.println("- Higher memory usage");

        System.out.println("\nApproach 2: Separate Min Stack");
        System.out.println("- Uses extra stack only for minimums");
        System.out.println("- More space optimized");
        System.out.println("- Preferred approach");

        System.out.println("\nTime Complexity:");
        System.out.println("push()   -> O(1)");
        System.out.println("pop()    -> O(1)");
        System.out.println("peek()   -> O(1)");
        System.out.println("getMin() -> O(1)");
    }
}
