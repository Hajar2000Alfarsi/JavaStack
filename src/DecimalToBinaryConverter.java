import java.awt.*;
import java.util.Stack;
public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        int[] testNumbers= {0, 1, 5, 10, 25, 100};

        DecimalToBinaryConverter testBinary = new DecimalToBinaryConverter();

        for (int numbers: testNumbers){
            System.out.println("\nDecimal: " + numbers);
            System.out.println("Binary Number(stack): " +testBinary.decimalToBinary(numbers));
            System.out.println("\nBinary Number(Built-in): " );
            testBinary.displayConversionProcess(numbers);

        }
    }

    public String decimalToBinary(int decimal){
        //if decimal=0  return 0
        if (decimal == 0){
            return "0";
        }

        Stack<Integer> num= new Stack<>();
        int temp = decimal;
        //Calculate the reminder
        while (temp > 0){
            int reminder = temp % 2;
            num.push(reminder);
            temp = temp / 2;
            System.out.println("Push remainder: " + reminder + " --> " + num);
        }

        //build the binary number from the stack
        String binary = "";
        while (!num.isEmpty()) {
            binary += num.pop();
        }
        return binary;
    }

    public void displayConversionProcess(int decimal){
        //if decimal=0  return 0
        if (decimal == 0) {
            System.out.println("0 = 0");
        }

        Stack<Integer> stack= new Stack<>();
        int temp = decimal;
        //Calculate the reminder in detail
        while (temp > 0){
            int reminder = temp % 2;
            System.out.println(temp + "÷2 = " + temp/2 + " remainder --> " + reminder);
            stack.push(reminder);
            temp = temp / 2;
        }
        System.out.println("Stack: " + stack);
    }
}
