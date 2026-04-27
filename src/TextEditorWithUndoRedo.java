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


    }
    public static void main(String[] args){


    }
}
