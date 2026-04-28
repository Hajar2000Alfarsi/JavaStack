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
        //Push numbers to stack
        for (int i = numDisks; i >= 1 ; i--) {
            A.push(i);
        }
    }

    public void moveDisk(char fromPeg, char toPeg){

    }


    public void solveHanoi(int n, char from, char to, char aux){
    }
}
