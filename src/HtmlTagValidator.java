import java.util.Stack;
public class HtmlTagValidator {
    public static void main(String[] args) {
        String[] tests= {"<div><p>Hello</p></div>", "<div><p></div></p>",
                       "<b><i>text</i></b>", "<div><br/></div>",
                "<html><body></body></html>", "<div><p>Test</p>",
                "<div><span></div></span>", "<h1>Title</h1><p>Paragraph</p>"};
    }

    public boolean validateHtmlTags(String html) {
        //Create stack to store HTML tags
        Stack<String> htmlStack = new Stack<>();

        //Create array to store each tag without < or >
        String[] tokens = html.split("<|>");

        //checking each tokens using for each loop
        for (String token: tokens) {
            //make sure there is no extra spaces in beginning or end of token
            token = token.trim();

            //Check the token if empty or not
            if (token.isEmpty()){
                continue;;
            }
        }
    }

}
