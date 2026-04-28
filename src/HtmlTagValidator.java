import java.util.Stack;
public class HtmlTagValidator {
    public static void main(String[] args) {
        String[] tests= {"<div><p>Hello</p></div>", "<div><p></div></p>",
                       "<b><i>text</i></b>", "<div><br/></div>",
                "<html><body></body></html>", "<div><p>Test</p>",
                "<div><span></div></span>", "<h1>Title</h1><p>Paragraph</p>"};
    }

    public boolean validateHtmlTags(String html) {
        Stack<String> htmlStack = new Stack<>();

    }

}
