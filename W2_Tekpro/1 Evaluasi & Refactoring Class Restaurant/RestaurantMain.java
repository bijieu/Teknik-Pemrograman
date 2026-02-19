public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chiken Steak", 45000, 30);

        menu.tampilMenuMakanan();

        System.out.println("\n=== PEMESANAN ===");
        menu.pesanMenu(0, 5);   
        menu.pesanMenu(1, 50);  

        System.out.println("\n=== MENU SETELAH PEMESANAN ===");
        menu.tampilMenuMakanan();
        }
}
