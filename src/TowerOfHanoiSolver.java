import javax.swing.*;
import java.util.Stack;
public class TowerOfHanoiSolver {
    //create 3 stacks
    static Stack<Integer> A = new Stack<>();
    static Stack<Integer> B = new Stack<>();
    static Stack<Integer> C = new Stack<>();

    static int moves = 0;
    public static void main(String[] args) {

    }

    public void initializePegs(int numDisks){
        //Clear all stacks to make sure it empty
        A.clear();
        B.clear();
        C.clear();
        //Push numbers to stack
        for (int i = numDisks; i >= 1 ; i--) {
            A.push(i);
        }
    }

    //get peg based on name
    public static Stack<Integer> getPeg(char peg) {
        if (peg == 'A') return A;
        if (peg == 'B') return B;
        return C;
    }


    public void moveDisk(char fromPeg, char toPeg){

    }

    public void isValidMove(char fromPeg, char toPeg){
        Stack<Integer> from = getPeg(fromPeg);
        Stack<Integer> to = getPeg(toPeg);

    }

    public void solveHanoi(int n, char from, char to, char aux){
    }

    public void displayPegs(){

    }
}
