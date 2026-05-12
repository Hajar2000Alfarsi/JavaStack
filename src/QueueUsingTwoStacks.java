import java.util.LinkedList;
import java.util.Queue;
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
        if (isEmpty()) {

            System.out.println("\nQueue is empty. Cannot dequeue.");

            return null;
        }
        transferElements();

        T removedElement = outputStack.pop();

        System.out.println("\nDEQUEUE: " + removedElement);

        displayStacks();

        return removedElement;
    }

    public T peek() {
        if (isEmpty()) {

            System.out.println("\nQueue is empty. Nothing to peek.");

            return null;
        }

        transferElements();

        T frontElement = outputStack.peek();

        System.out.println("\nPEEK: " + frontElement);

        displayStacks();

        return frontElement;
    }


    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public int size() {

        return inputStack.size() + outputStack.size();
    }


    private void transferElements() {

        if (outputStack.isEmpty()) {

            System.out.println("\nTransferring elements...");

            while (!inputStack.isEmpty()) {

                outputStack.push(inputStack.pop());
            }
        }
    }


    public void displayStacks() {

        System.out.println("--------------------------------");

        System.out.println("Input Stack  : " + inputStack);

        System.out.println("Output Stack : " + outputStack);

        displayLogicalQueue();

        System.out.println("Queue Size   : " + size());

        System.out.println("--------------------------------");
    }

    private void displayLogicalQueue() {

        System.out.print("Logical Queue: [");

        for (int i = outputStack.size() - 1; i >= 0; i--) {

            System.out.print(outputStack.get(i));

            if (i != 0 || !inputStack.isEmpty()) {

                System.out.print(", ");
            }
        }

        for (int i = 0; i < inputStack.size(); i++) {

            System.out.print(inputStack.get(i));

            if (i != inputStack.size() - 1) {

                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void compareWithBuiltInQueue() {

        System.out.println("\n========== PERFORMANCE COMPARISON ==========");

        System.out.println("\nQueue Using Two Stacks:");
        System.out.println("- Enqueue: O(1)");
        System.out.println("- Dequeue: Amortized O(1)");
        System.out.println("- Peek: Amortized O(1)");
        System.out.println("- Uses two stacks internally");

        System.out.println("\nJava Built-in Queue:");
        System.out.println("- Enqueue: O(1)");
        System.out.println("- Dequeue: O(1)");
        System.out.println("- Peek: O(1)");
        System.out.println("- More efficient for production systems");

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("\nBuilt-in Queue Example:");
        System.out.println(queue);

        queue.poll();

        System.out.println("After poll(): " + queue);
    }


    }
