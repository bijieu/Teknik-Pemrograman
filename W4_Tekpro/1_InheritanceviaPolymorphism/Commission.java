public class Commission extends Hourly
{
    private double totalSales;
    private double commissionRate;

    // Constructor
    public Commission(String name, String address, String phone,
                      String ssn, double rate, double commissionRate)
    {
        super(name, address, phone, ssn, rate);
        this.commissionRate = commissionRate;
        this.totalSales = 0;
    }

    // Menambahkan total sales
    public void addSales(double totalSales)
    {
        this.totalSales += totalSales;
    }

    // Override pay()
    public double pay()
    {
        double basePay = super.pay();  // dari Hourly (sudah reset hoursWorked)
        double commissionPay = totalSales * commissionRate;

        totalSales = 0; // reset sales setelah dibayar

        return basePay + commissionPay;
    }

    // Override toString()
    public String toString()
    {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}