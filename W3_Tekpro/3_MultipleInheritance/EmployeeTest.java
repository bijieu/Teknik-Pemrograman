public class EmployeeTest {

    public static void main(String[] args) {

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Test compare langsung
        System.out.println("Compare staff[0] and staff[1]: " +
                staff[0].compare(staff[1]));

        // Raise salary
        for (int i = 0; i < staff.length; i++) {
            staff[i].raiseSalary(5);
        }

        // Print sebelum sort
        System.out.println("\nBefore sorting:");
        for (int i = 0; i < staff.length; i++) {
            staff[i].print();
        }

        // Sorting menggunakan shell_sort
        Sortable.shell_sort(staff);

        // Print setelah sort
        System.out.println("\nAfter sorting (by salary):");
        for (int i = 0; i < staff.length; i++) {
            staff[i].print();
        }
    }
}