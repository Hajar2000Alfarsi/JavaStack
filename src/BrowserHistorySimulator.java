import java.util.Stack;

public class BrowserHistorySimulator {
    public static void main(String[] args) {
        Stack<String> webpageUrl= new Stack<>();

        webpageUrl.push("goole,com");
        System.out.println("Current page: " + webpageUrl.peek());
        System.out.println("History: " + webpageUrl);

    }
}
