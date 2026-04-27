import java.util.Stack;
public class ParenthesesValidator {
    public static void main(String[] args) {
        String[] testCase= {"(a+b)","(a+b]","((a+b)*c)","([{}])","(((",""}
    }
    public boolean isBalanced(String expression) {
        Stack<Character> parentheses = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                parentheses.push(ch);
                System.out.println("push: " + ch + " -> " + parentheses);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (parentheses.isEmpty()) {
                    return false;
                }

                char top= parentheses.peek();
                if (ch == ')' && top == '(' ||
                        ch == ']' && top == '[' || ch == '}' && top == '{'){
                    parentheses.pop();
                    System.out.println("Pop: " + ch + " -> " + parentheses);
                } else {
                    System.out.println("Error: mismatch " + top + " and " + ch);
                    return false;
                }
            }
        }
    }
}
