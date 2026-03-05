public class Salesperson implements Comparable {
    private String firstName, lastName;
    private int totalSales;

    // Constructor: Sets up the sales person object with
    // the given data.
    public Salesperson (String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    // Returns the sales person as a string.
    public String toString() {
        return lastName + ", " + firstName + ": \t" + totalSales;
    }

    // Returns true if the sales people have
    // the same name.
    public boolean equals (Object other) {
        return (lastName.equals(((Salesperson)other).getLastName()) &&
        firstName.equals(((Salesperson)other).getFirstName()));
    }

    // Order is based on total sales with the name
    // (last, then first) breaking a tie.
    public int compareTo(Object other) {
        Salesperson otherPerson = (Salesperson) other;

        // Bandingkan total sales dulu
        if (this.totalSales != otherPerson.totalSales)
            return this.totalSales - otherPerson.totalSales;

        // Kalau sales sama → bandingkan nama (reverse alphabetical)
        int lastCompare = otherPerson.lastName.compareTo(this.lastName);
        if (lastCompare != 0)
            return lastCompare;

        return otherPerson.firstName.compareTo(this.firstName);
    }

    // First name accessor.
    public String getFirstName() {
        return firstName;
    }
    // Last name accessor.
    public String getLastName() {
        return lastName;
    }

    // Total sales accessor.
    public int getSales() {
        return totalSales;
    }

}
