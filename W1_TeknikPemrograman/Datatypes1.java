import java.util.ArrayList;
import java.util.Scanner;

public class Datatypes1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        ArrayList<String> numbers = new ArrayList<>(); // Membuat OBJECT ArrayList untuk menyimpan angka, pake Long (wrapper class) ArrayList cuma bisa menyimpan object

        for (int i = 0; i < T; i++) {
            numbers.add(input.next()); // nextLong() menghasilkan long, tapi ArrayList<Long> butuh object jadinya AUTOBOXING (long → Long)
        }

        for (String s : numbers) { // Long.parseLong() ngubah String menjadi long (primitive)

            try {
                long n = Long.parseLong(s);

                System.out.println(n + " can be fitted in:");

                if (n >= -128 && n <= 127) // pas dibandingkan dengan angka primitive, terjadi UNBOXING (Long → long)
                    System.out.println("* byte");

                if (n >= -32768 && n <= 32767)
                    System.out.println("* short");

                if (n >= -2147483648L && n <= 2147483647L)
                    System.out.println("* int");

                System.out.println("* long");

            } catch (NumberFormatException e) {
                System.out.println(s + " can't be fitted anywhere.");
            }
        }

        input.close();
    }
}
