import java.util.Stack;

public class EmployeeStackSearch {
    public static void main(String[] args) {
        Stack<String> employeeAction= new Stack<>();

        employeeAction.push("Employee A Logged in");
        employeeAction.push("Employee B uploaded a file");
        employeeAction.push("Employee C updated a record");
        employeeAction.push("Employee D logged out");
        employeeAction.push("Employee E changed password");
        employeeAction.push("Employee F deleted a file");

        System.out.println("Stack (Top to Buttom): ");
        for (int i=employeeAction.size()-1; i >= 0; i--){
            System.out.println("Position: " + (employeeAction.size() - i) +
                       ": " + employeeAction.get(i));
        }
    }
}
