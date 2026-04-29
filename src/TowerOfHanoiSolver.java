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

    public boolean isValidMove(char fromPeg, char toPeg){
        Stack<Integer> source = getPeg(fromPeg);
        Stack<Integer> destination = getPeg(toPeg);

        if (source.empty()) return false;
        if (destination.empty()) return true;
        return source.peek() < source.peek();
    }

    public void moveDisk(char fromPeg, char toPeg){
        if (isValidMove(fromPeg, toPeg)) {
            Stack<Integer> source = getPeg(fromPeg);
            Stack<Integer> destination = getPeg(toPeg);
            //move disk from source to destination
            int disk = source.pop();
            destination.push(disk);
            moves++;
            System.out.println("Move disk " + disk + " from " + fromPeg + " to " + toPeg);
            displayPegs();
        } else {
            System.out.println("Invalid move attemped from " + fromPeg + " to " + toPeg);
        }
    }

    public void solveHanoi(int n, char from, char to, char aux){
        //if only one disk in stack
        if (n == 1){
            moveDisk(from,to);
        }
        //Move n-1 to aux
        solveHanoi(n - 1, from, aux, to);
        //Move largest disk
        moveDisk(from, to);
        //Move n-1 to destination
        solveHanoi(n - 1, aux, to, from);
    }

    public void displayPegs(){

    }
}
