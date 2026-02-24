package id.ac.polban.employee;

import java.util.Scanner;
import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== INPUT DATA EMPLOYEE =====");

        System.out.print("ID: ");
        int id = input.nextInt();
        input.nextLine(); // penting! buang newline

        System.out.print("Nama: ");
        String name = input.nextLine();

        System.out.print("Department: ");
        String deptName = input.nextLine();

        System.out.print("Employment Type: ");
        String typeName = input.nextLine();

        System.out.print("Salary: ");
        double salary = input.nextDouble();

        // Buat object berdasarkan input user
        Department dept = new Department(deptName);
        EmploymentType type = new EmploymentType(typeName);
        Employee emp = new Employee(id, name, dept, type, salary);

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp);

        // Ambil lagi dari service
        Employee data = service.getEmployee(id);

        System.out.println("\n===== DATA EMPLOYEE =====");
        System.out.println("ID         : " + data.getId());
        System.out.println("Nama       : " + data.getName());
        System.out.println("Department : " + data.getDepartment().getName());
        System.out.println("Type       : " + data.getType().getType());
        System.out.println("Salary     : " + data.getSalary());

        System.out.println("\nTotal Employee: " + Employee.getTotalEmployee());

        input.close();
    }
}
