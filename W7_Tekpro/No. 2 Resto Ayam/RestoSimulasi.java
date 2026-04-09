class Resto {
    private int chickenStock = 100;

    // synchronized: hanya SATU thread yang boleh mengeksekusi method ini dalam satu waktu
    // Thread lain yang mencoba masuk akan diblokir dan mengantri sampai thread yang sedang di dalam selesai
    public synchronized  void serveCustomer(String cashierName) {
        if (chickenStock > 0) {
            try { Thread.sleep(10); } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Pulihkan status interrupt
            }
            
            chickenStock--; 
            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }
    // Saat method ini selesai, kunci (intrinsic lock) dilepas secara otomatis
    // oleh JVM, dan thread berikutnya yang mengantri diperbolehkan masuk

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto();

        // Runnable task tidak berubah, setiap kasir tetap melayani 40 pelanggan
        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        kasir1.start();
        kasir2.start();
        kasir3.start();

        kasir1.join();
        kasir2.join();
        kasir3.join();

        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}
