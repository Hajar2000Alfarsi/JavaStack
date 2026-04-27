import java.util.Stack;
public class ParenthesesValidator {
    public static void main(String[] args) {

    }
    public boolean isBalanced(String expression) {
        Stack<Character> parentheses = new Stack<>();

        for (int i = 0; i < expression.length(); i++){
            char ch= expression.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                parentheses.push(ch);
                System.out.println("push: " + ch + " -> " + parentheses);
            }


        }
    }
}
