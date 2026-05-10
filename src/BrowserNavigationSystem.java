import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class BrowserNavigationSystem {
    //Create stacks: one for back, one for forward
    static Stack<String> backStack= new Stack<>();
    static Stack<String> forwardStack = new Stack<>();

    // List to store all visited pages in the session
    List<String> sessionPages = new ArrayList<>();

    //variable to store the current page
    String currentPage= "Home Page";

    //Max
    int Max_History = 10;
    public static void main(String[] args){
        BrowserNavigationSystem browser = new BrowserNavigationSystem();

        System.out.println("===== Browser Navigation System =====");
        browser.displayState();

    }

    public void visitPage(String url) {
        if (currentPage != null) {
            if (backStack.size() >= Max_History) {
                backStack.remove(0);
            }
        }

        currentPage = url;

        sessionPages.add(url);

        forwardStack.clear();

        System.out.println("\nVisited " + url);
        displayState();
    }


    public void goBack(){
        if (backStack.isEmpty()) {
            System.out.println("\nCannot go back. No previous  pages");
            return;
        }

        forwardStack.push(currentPage);

        currentPage = backStack.pop();

        System.out.println("\nWent Back");
        displayState();
    }

    public void goForward(){
        if (forwardStack.isEmpty()) {
            System.out.println("\nCannot go forward. No next pages.");
            return;
        }

        backStack.push(currentPage);

        currentPage = forwardStack.pop();

        System.out.println("\nWent Forward");
        displayState();
    }

    public void showCurrentPage(){
        System.out.println("Back Stack: " + backStack);
        System.out.println("Forward Stack: " + forwardStack);

        if (!backStack.isEmpty()) {
            System.out.println("Previous Page: " + backStack.peek());
        }

        if (!forwardStack.isEmpty()) {
            System.out.println("Next Page: " + forwardStack.peek());
        }
    }

    public void showHistory(){
        System.out.println("\n===== Session Pages =====");

        for (String page : sessionPages) {
            System.out.println(page);
        }

    }

    public void displayState() {

        showCurrentPage();
        showHistory();
    }

}
