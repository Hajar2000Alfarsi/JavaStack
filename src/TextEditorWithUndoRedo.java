import java.util.Stack;
public class TextEditorWithUndoRedo {
    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();
    String text = "";

    public void type(String inputText) {
        undoStack.push(text);

        //If undo exceeds 10 delete first one
        if (undoStack.size() > 10){
            undoStack.remove(0);
        }
        //add the input text to existing text
        text += inputText;

        //clear redo stack
        redoStack.clear();

        //display the new text
        System.out.println("new Text: " + inputText);
    }

    public void undo() {
        //Check if stack empty
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to indo");
        }
        //Add that text to redo stack
        redoStack.push(text);

        //Delete last action
        text = undoStack.pop();

    }

    public static void main(String[] args){


    }
}
