import java.util.Stack;


public class PostfixEvaluator {
    public static void main(String[] args) {
        String[] postfix= {"3 4 +", "10 2 /", "5 1 2 + 4 * + 3 -", "6 2 * 3 /", "8 3 %"};

        PostfixEvaluator testPostfix= new PostfixEvaluator();

        for (String  exp:postfix) {
            System.out.println("\nExpression: " + exp);
            int result = testPostfix.evaluatePostfix(exp);
            System.out.println("Result: " + result);
        }
    }

    public int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        //split expression by " " to take only numbers
        String[] tokens= expression.split(" ");

        for (String token:tokens) {
            //Check if the token is number or not
            if (isNumber(token)) {
                //convert token from String to Integer
                int num = Integer.parseInt(token);
                stack.push(num);
                System.out.println("Push number: " + num + " --> " + stack);
            } else {//if the token is operator
                if (stack.size() < 2) {
                    System.out.println("Invalid expression");
                }
                int a = stack.pop();
                int b = stack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0){
                            System.out.println("Division by zero");
                        }
                        result = a / b;
                        break;
                    case "%":
                        result = a % b;
                        break;
                    default:
                        System.out.println("Invalid operator" + token);

                }
                stack.push(result);
                System.out.println("Apply " + token + " -> " +stack);
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
