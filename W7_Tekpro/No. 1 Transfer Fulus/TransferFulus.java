class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Perintah untuk selalu ngunci id terkecil dulu
                System.out.println("Thread 1 mengunci acc1 dan sedang memproses transfer ke acc2");
                try { Thread.sleep(100); } catch (Exception  e) {} // Simulasi dengan memberikan jeda. Exeption digunakan karena method Thread.sleep() dapat menghasilkan (throw) InterruptedException, solusinya menggunakan try-catch 

                synchronized (acc2) { // Perintah untuk ngunci id yang lebih besar
                    System.out.println("Thread 1 mengunci acc2 dan transfer dari acc1 ke acc2");
                    acc2.balance += acc1.balance;
                    acc1.balance = 0; // memindahkan saldo 
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // ini kode asalnya acc2, diubah jadi acc1 agar mulai dari id terkecil
                System.out.println("Thread 2 mengunci acc1 dan sedang memproses transfer ke acc2");
                try { Thread.sleep(100); } catch (InterruptedException  e) {}

                synchronized (acc2) { // diganti jadi acc2 biar terurut dan tidak saling nunggu
                    System.out.println("Thread 2 mengunci acc2 dan transfer dari acc1 ke acc2");
                    acc1.balance += acc2.balance;
                    acc2.balance = 0; // memindahkan saldo 
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
		System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}
