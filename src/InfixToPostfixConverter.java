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

        System.out.println("\n=================================");
        System.out.println("Infix Expression: " + infix);
        System.out.println("=================================");

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);

            // Ignore spaces
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch) || ch == '.') {

                // Handle multi-digit numbers
                while (i < infix.length() &&
                        (Character.isDigit(infix.charAt(i))
                                || infix.charAt(i) == '.')) {

                    postfix.append(infix.charAt(i));
                    i++;
                }

                postfix.append(" ");

                i--;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (isOperator(ch)) {
                while (!stack.isEmpty()
                        && getPrecedence(stack.peek()) >= getPrecedence(ch)) {

                    postfix.append(stack.pop()).append(" ");
                }

                stack.push(ch);
            }
            System.out.println("Token: " + ch);
            System.out.println("Stack: " + stack);
            System.out.println("Postfix: " + postfix);
            System.out.println("---------------------");
            }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString();
    }

    public static double applyOperation(double a, double b, char operator) {
        switch (operator) {

            case '+':
                return a + b;

            case '-':
                return a - b;

            case '*':
                return a * b;

            case '/':

                if (b == 0) {
                    throw new ArithmeticException("Division by zero!");
                }

                return a / b;

            case '%':
                return a % b;

            case '^':
                return Math.pow(a, b);

            default:
                return 0;
        }
    }

    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            if (Character.isDigit(token.charAt(0))
                    || token.charAt(0) == '.') {

                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();

                double result =
                        applyOperation(a, b, token.charAt(0));

                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] expressions = {

                "3 + 4 * 2",

                "(1 + 2) * 3",

                "10 + 5 * 6",

                "100 / ( 5 + 5 )",

                "7 + 8 - 2",

                "2 ^ 3 + 4",

                "20 % 3 + 1",

                "12.5 + 7.5 * 2"
        };
        for (String expression : expressions) {

            try {

                String postfix =
                        infixToPostfix(expression);

                System.out.println("\nFinal Postfix: "
                        + postfix);

                double result =
                        evaluatePostfix(postfix);

                System.out.println("Result: " + result);

            } catch (Exception e) {

                System.out.println("Error: "
                        + e.getMessage());
            }

            System.out.println("\n========================================");
        }
    }
}
