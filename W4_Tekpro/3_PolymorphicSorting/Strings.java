import java.util.Scanner;

public class Strings {
    public static void main(String[] args)
    {
        String[] strList;
        int size;
        Scanner scan = new Scanner(System.in);

        System.out.print("\nHow many strings? ");
        size = scan.nextInt();
        scan.nextLine();

        strList = new String[size];

        System.out.println("Enter the strings...");
        for (int i = 0; i < size; i++)
            strList[i] = scan.nextLine();

        Sorting.selectionSort(strList);

        System.out.println("\nSorted strings...");
        for (String s : strList)
            System.out.println(s);
    }
}
