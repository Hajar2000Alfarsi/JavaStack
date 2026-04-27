import java.util.Stack;
public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        int[] testNumbers= {0, 1, 5, 10, 25, 100};
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


    }
}
