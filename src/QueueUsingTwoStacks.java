import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<T> inputStack;
    private Stack<T> outputStack;

    public QueueUsingTwoStacks() {

        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void enqueue(T element) {

        // Push element into input stack
        inputStack.push(element);

        System.out.println("\nENQUEUE: " + element);

        displayStacks();
    }

    public T dequeue() {

    }

    }
