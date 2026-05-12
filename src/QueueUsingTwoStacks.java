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



    }
