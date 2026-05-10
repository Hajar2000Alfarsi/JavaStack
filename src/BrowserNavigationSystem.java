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
    }

    public void goForward(){

    }

    public void showCurrentPage(){

    }

    public void showHistory(){

    }

    public void displayState() {

        showCurrentPage();
        showHistory();
    }

}
