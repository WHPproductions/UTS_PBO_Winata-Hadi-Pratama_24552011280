import java.util.Date;

public abstract class PaketWisata {
    private String namaPaket;
    private String lokasi;
    private String deskripsi;
    private double harga;
    private int durasiHari;
    private Date jadwal;

    public PaketWisata(String namaPaket, String lokasi,String deskripsi, double harga, int durasiHari, Date jadwal) {
        this.namaPaket = namaPaket;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.durasiHari = durasiHari;
        this.jadwal = jadwal;
    }

    // Getters
    public String getNamaPaket() {
        return namaPaket;
    }
    public String getLokasi() {
        return lokasi;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public double getHarga() {
        return harga;
    }
    public int getDurasiHari() {
        return durasiHari;
    }
    public Date getJadwal() {
        return jadwal;
    }

    // Setters
    public void setNamaPaket(String namaPaket) {
        this.namaPaket = namaPaket;
    }
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public void setDurasiHari(int durasiHari) {
        this.durasiHari = durasiHari;
    }
    public void setJadwal(Date jadwal) {
        this.jadwal = jadwal;
    }
}
