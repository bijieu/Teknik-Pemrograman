public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;
    
    public Restaurant() {
    nama_makanan = new String[10];
    harga_makanan = new double[10];
    stok = new int[10];
    } 

    public void setNamaMakanan(int index, String nama){
        this.nama_makanan[index] = nama;
    }

    public String getNamaMakanan(int index){
        return this.nama_makanan[index];
    }

    public void setHargaMakanan(int index, double harga){
        this.harga_makanan[index] = harga;
    }

    public double getHargaMakanan(int index){
        return this.harga_makanan[index];
    }

    public void setStok(int index, int stok){
        if (stok >= 0){
            this.stok[index] = stok;
        } else {
            System.out.println("Stok tidak boleh negatif");
        }
    }

    public int getStok(int index){
        return this.stok[index];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        setNamaMakanan(id, nama);
        setHargaMakanan(id, harga);
        setStok(id, stok);
        nextId();
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
        if (!isOutOfStock(i)) {
            System.out.printf(
                "%-5d %-20s [%2d]  Rp. %,2.0f\n", 
                i,
                getNamaMakanan(i),
                getStok(i),
                getHargaMakanan(i)
            );
        }
    }
    }

    public boolean isOutOfStock(int index) {
        return getStok(index) == 0;
    }

    public static void nextId() {
        id++;
    }

    public void pesanMenu(int index, int jumlah) {
        if (index < 0 || index >= id) {
            System.out.println("Menu tidak ditemukan.");
            return;
        }

        if (jumlah <= 0){
            System.out.println("Makanan sudah habis");
            return;
        }

        if (getStok(index) >= jumlah) {
            setStok(index, getStok(index) - jumlah);
            System.out.println("Pesanan berhasil!");
        } else {
        System.out.println("Pesanan ditolak! Stok tidak mencukupi.");
    }
    }
}


