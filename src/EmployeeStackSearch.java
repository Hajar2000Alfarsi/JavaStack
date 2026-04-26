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

        System.out.println("\nPostion of 'Employee C updated a record': " +
                employeeAction.search("Employee C updated a record"));

        System.out.println("Position of 'Employee F deleted a file': " +
                employeeAction.search("Employee F deleted a file"));

        System.out.println("\nContains 'Employee D logged out': " +
                employeeAction.contains("Employee D logged out"));


        System.out.println("Contains 'Employee X logged out'" +
                employeeAction.contains("Employee X logged out"));

        System.out.println("\nEmployee Action(top to bottom): ");
        for (int i = employeeAction.size() -1; i >= 0; i--) {
            System.out.println(employeeAction.get(i));
        }

        System.out.println("\nEmployee Action(bottom to top): ");
        for (String action: employeeAction) {
            System.out.println(action);
        }
    }
}
