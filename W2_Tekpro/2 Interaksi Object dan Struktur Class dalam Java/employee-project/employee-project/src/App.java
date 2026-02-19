import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class App {

    public static void main(String[] args) {

        Department dept = new Department("IT");
        EmploymentType type = new EmploymentType("Full-Time");

        Employee emp = new Employee(1, "Ebi", dept, type, 5000000);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp);

        System.out.println("Total Employee: " + Employee.getTotalEmployee());
    }
}
