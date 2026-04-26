import java.util.Stack;

public class EmployeeStackDemo {
    public static void mani(String[] args){
        Stack<String> employeeAction= new Stack<>();

        employeeAction.push("Employee A Logged in");
        employeeAction.push("Employee B uploaded a file");
        employeeAction.push("Employee C updated a record");
        employeeAction.push("Employee D logged out");
        employeeAction.push("Employee E changed password");

        System.out.println("Employee Actios: " + employeeAction);
    }
}
