package programs;

/**
 * class ini merupakan implementasi dari refactoring
 * class data membuat setter dan getter dari setiap inputan variabel
 * @return nama, alamat, pakainJenis, ukuran, jumlah, totalHarga untuk membalikkan nilai inputan
 * method setNama, setAlamat, setPakaianJenis, setUkuran, setJumlah, setTotalHarga untuk menulis/memasukkan inputan
 * method getNama, getAlamat, getPakaianJenis, getUkuran, getJumlah, getTotalHarga untuk membaca inputan
 */
public class data {
    private String nama;
    private String alamat;
    private int pakaianJenis;
    private String ukuran;
    private int jumlah;
    private int totalHarga;


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getPakaianJenis() {
        return pakaianJenis;
    }

    public void setPakaianJenis(int pakaianJenis) {
        this.pakaianJenis = pakaianJenis;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
}


