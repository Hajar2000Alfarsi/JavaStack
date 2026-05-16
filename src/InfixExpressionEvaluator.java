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

    }
}
