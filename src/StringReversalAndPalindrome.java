import java.util.Stack;
public class StringReversalAndPalindrome {
    public static void main(String[] args){
        String[] testCases= {"hello", "madam", "racecar", "java", "a", ""};

    }
    public String reverseString(String input){
        //chek if input null
        if (input == null){
            return "";
        }

        Stack<Character> text= new Stack<>();

        //push each character
        for (int i = 0; i < input.length(); i++){
            char ch= input.charAt(i);
            text.push(ch);
        }

        //String to store the reverse of stack
        String reverse= "";

        //pop from stack and store that char in reverse to git the reverse
        while (!text.isEmpty()){

        }

    }
}
