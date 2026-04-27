import java.util.Stack;

import static jdk.nashorn.internal.runtime.JSType.isNumber;

public class PostfixEvaluator {
    public static void main(String[] args) {
        String[] postfix= {"3 4 +", "10 2 /", "5 1 2 + 4 * + 3 -", "6 2 * 3 /", "8 3 %"};
    }

    public int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        //split expression by " " to take only numbers
        String[] tokens= expression.split(" ");

    }
}
