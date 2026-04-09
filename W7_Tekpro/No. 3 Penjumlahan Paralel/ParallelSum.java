class SumTask extends Thread {
    private int start;       // batas awal angka yang akan dijumlahkan oleh thread
    private int end;         // batas akhir angka yang akan dijumlahkan oleh thread
    private long partialSum; // hasil penjumlahan parsial (milik thread ini saja, tidak dibagi)

    // Constructor untuk inisialisasi range dan nama thread
    public SumTask(int start, int end, String name) {
        super(name); // memberikan nama thread (memudahkan identifikasi saat output)
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        // Menampilkan tugas yang dikerjakan oleh thread
        System.out.println(getName() + " menghitung dari " + start + " sampai " + end);

        // Proses penjumlahan dalam range (dilakukan oleh masing-masing thread)
        for (int i = start; i <= end; i++) {
            partialSum += i; // aman karena tidak ada thread lain yang mengakses variabel ini
        }

        // Menampilkan hasil parsial dari thread
        System.out.println(getName() + " hasil parsial: " + partialSum);
    }

    // Getter untuk mengambil hasil parsial setelah thread selesai
    public long getPartialSum() {
        return partialSum;
    }
}

public class ParallelSum {
    public static void main(String[] args) throws InterruptedException {

        int jumlahThread = 4; // jumlah thread yang digunakan
        int angkaAkhir = 1000; // batas akhir penjumlahan

        SumTask[] tasks = new SumTask[jumlahThread]; // array untuk menyimpan semua thread

        int range = angkaAkhir / jumlahThread; // ukuran range tiap thread
        int start = 1; // angka awal

        // 🔹 Membagi tugas ke setiap thread (divide and conquer)
        for (int i = 0; i < jumlahThread; i++) {
            // Menentukan batas akhir tiap thread
            // Thread terakhir mengambil sisa agar tidak ada angka yang terlewat
            int end = (i == jumlahThread - 1) ? angkaAkhir : start + range - 1;

            // Membuat thread dengan range tertentu dan nama unik
            tasks[i] = new SumTask(start, end, "Thread-" + (i + 1));

            // Menjalankan thread secara paralel
            tasks[i].start();

            // Update start untuk thread berikutnya
            start = end + 1;
        }

        long total = 0; // variabel untuk menyimpan hasil akhir

        // 🔹 Menunggu semua thread selesai (synchronization point)
        for (int i = 0; i < jumlahThread; i++) {
            tasks[i].join(); // memastikan thread ke-i sudah selesai

            // Menggabungkan hasil parsial (aman karena dilakukan setelah join)
            total += tasks[i].getPartialSum();
        }

        // Menampilkan hasil akhir penjumlahan
        System.out.println("--- HASIL AKHIR: " + total + " ---");
    }
}