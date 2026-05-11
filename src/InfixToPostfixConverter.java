import java.util.Stack;

public class InfixToPostfixConverter {

    public static boolean isOperator(char ch){
        return ch == '+' || ch == '-' ||
                ch == '*' || ch == '/' ||
                ch == '%' || ch == '^';
    }

    public static int getPrecedence(char operator){
        switch (operator) {

            case '^':
                return 3;

            case '*':
            case '/':
            case '%':
                return 2;

            case '+':
            case '-':
                return 1;

            default:
                return -1;
        }
    }

    public static String infixToPostfix(String infix){
        Stack<Character> stack = new Stack<>();

        StringBuilder postfix = new StringBuilder();


    }

    public static void main(String[] args) {

    }
}
