import java.util.Stack;

public class InfixExpressionEvaluator {
    static Stack<Double> operandStack = new Stack<>();

    // Stack for operators
    static Stack<Character> operatorStack = new Stack<>();

    public static void main(String[] args) {
// Array of test expressions
        String[] expressions = {
                "5 + 3",
                "10 + 2 * 6",
                "100 * 2 + 12",
                "100 * ( 2 + 12 )",
                "100 * ( 2 + 12 ) / 14",
                "5 + 2 * 3 - 1",
                "10 / 2 + 7",
                "2 ^ 3",
                "20 % 3",
                "3.5 + 2.1",
                "-5 + 3",
                "( 8 + 2 ) * ( 3 - 1 )"
        };

        // Evaluate all expressions
        for (String expression : expressions) {

            System.out.println("\n===================================");
            System.out.println("Expression: " + expression);

            try {
                double result = evaluate(expression);
                System.out.println("Final Result = " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("===================================\n");
        }
    }


    // Main evaluation method
    public static double evaluate(String expression) {
        // Clear stacks before every evaluation
        operandStack.clear();
        operatorStack.clear();

        // Remove spaces from expression
        expression = expression.replaceAll("\\s+", "");

        int i = 0;

        while (i < expression.length()) {

            char ch = expression.charAt(i);

            // Handle numbers and decimal values
            if (isNumber(ch) ||
                    (ch == '-' && (i == 0 || expression.charAt(i - 1) == '(' || isOperator(expression.charAt(i - 1))))) {

                StringBuilder number = new StringBuilder();

                // Handle unary minus
                if (ch == '-') {
                    number.append('-');
                    i++;
                }

                // Build complete number
                while (i < expression.length() &&
                        (isNumber(expression.charAt(i)))) {

                    number.append(expression.charAt(i));
                    i++;
                }

                // Push number into operand stack
                operandStack.push(Double.parseDouble(number.toString()));

                printStacks(number.toString());

                continue;
            }

            // Handle opening parenthesis
            else if (ch == '(') {

                operatorStack.push(ch);

                printStacks(String.valueOf(ch));
            }

            // Handle closing parenthesis
            else if (ch == ')') {
                // Solve until '(' appears
                while (!operatorStack.isEmpty()
                        && operatorStack.peek() != '(') {

                    performCalculation();
                }

                // Remove '(' from stack
                if (!operatorStack.isEmpty()
                        && operatorStack.peek() == '(') {

                    operatorStack.pop();
                }

                printStacks(String.valueOf(ch));
            }

            // Handle operators
            else if (isOperator(ch)) {
                // Apply operators with higher precedence first
                while (!operatorStack.isEmpty()
                        && getPrecedence(operatorStack.peek()) >= getPrecedence(ch)) {

                    performCalculation();
                }

                // Push current operator
                operatorStack.push(ch);

                printStacks(String.valueOf(ch));
            } else {
                throw new IllegalArgumentException("Invalid character: " + ch);
            }

            i++;

        }

        // Perform remaining calculations
        while (!operatorStack.isEmpty()) {

            performCalculation();
        }

        // Final result
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid Expression");
        }

        return operandStack.pop();
    }


    // Perform one calculation
    public static void performCalculation() {
        // Pop operator
        char operator = operatorStack.pop();

        // Pop operands
        double b = operandStack.pop();
        double a = operandStack.pop();

        // Apply operation
        double result = applyOperation(a, b, operator);

        // Push result back
        operandStack.push(result);

        System.out.println("Applied: " + a + " " + operator + " " + b + " = " + result);

        printStacks("Calculation");
    }


    // Perform arithmetic operations
    public static double applyOperation(double a, double b, char operator) {
        switch (operator) {

            case '+':
                return a + b;

            case '-':
                return a - b;

            case '*':
                return a * b;

            case '/':


                // Handle division by zero
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }

                return a / b;

            case '%':

                // Handle modulo by zero
                if (b == 0) {
                    throw new ArithmeticException("Modulo by zero");
                }

                return a % b;

            case '^':
                return Math.pow(a, b);

            default:
                throw new IllegalArgumentException("Invalid Operator");
        }
    }

    // Return operator precedence
    public static int getPrecedence(char operator) {

        switch (operator) {

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
            case '%':
                return 2;

            case '^':
                return 3;

            default:
                return 0;
        }
    }


    // Check if character is operator
    public static boolean isOperator(char ch) {

        return ch == '+' ||
                ch == '-' ||
                ch == '*' ||
                ch == '/' ||
                ch == '^' ||
                ch == '%';
    }


    // Check if character is number or decimal point
    public static boolean isNumber(char ch) {

        return Character.isDigit(ch) || ch == '.';
    }

    // Print stack contents after every step
    public static void printStacks(String token) {

        System.out.println("\nProcessed Token: " + token);

        System.out.println("Operand Stack: " + operandStack);

        System.out.println("Operator Stack: " + operatorStack);
    }
}
