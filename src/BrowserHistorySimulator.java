import java.util.Stack;

public class BrowserHistorySimulator {
    public static void main(String[] args) {
        Stack<String> webpageUrl= new Stack<>();

        webpageUrl.push("goole.com");
        System.out.println("\nVisited goole.com");
        System.out.println("Current page: " + webpageUrl.peek());
        System.out.println("History: " + webpageUrl);

        webpageUrl.push("youtube.com");
        System.out.println("\nVisited youtube.com");
        System.out.println("Current page: " +webpageUrl.peek());
        System.out.println("History: " + webpageUrl);

        webpageUrl.push("github.com");
        System.out.println("\nVisited github.com");
        System.out.println("Current page: " +webpageUrl.peek());
        System.out.println("History: " + webpageUrl);

        webpageUrl.push("stackoverflow.com");
        System.out.println("\nVisited stackoverflow.com");
        System.out.println("Current page: " + webpageUrl.peek());
        System.out.println("History: " + webpageUrl);

        webpageUrl.push("wikipedia.org");
        System.out.println("\nVisited wikipedia.org");
        System.out.println("Current page: " + webpageUrl.peek());
        System.out.println("History: " + webpageUrl);

        System.out.println("\nPress Back.. ");
        webpageUrl.pop();
        System.out.println("Current Page: " + webpageUrl.peek());

    }
}
