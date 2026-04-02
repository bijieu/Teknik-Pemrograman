package JavaProblems;

public class Employee {

    private String name;
    private int salary;

    // Constructor
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    // toString biar output sesuai
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}