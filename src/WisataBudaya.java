import java.util.Date;
import java.text.SimpleDateFormat;

public class WisataBudaya extends PaketWisata {
    // Jenis budaya yang menjadi fokus utama dalam paket wisata budaya
    public enum JenisBudaya {
        TARI,
        FESTIVAL,
        RITUAL,
        KULINER,
        KERAJINAN
    }

    // Attributes
    private JenisBudaya jenisBudaya;

    public WisataBudaya(
            String namaPaket,
            String lokasi,
            String deskripsi,
            double harga,
            int durasiHari,
            Date jadwal,
            JenisBudaya jenisBudaya) {
        super(namaPaket, lokasi, deskripsi, harga, durasiHari, jadwal);
        this.jenisBudaya = jenisBudaya;
    }

    // Getters
    public String getJenisBudaya() {
        return jenisBudaya.toString();
    }

    // Setters
    public void setJenisBudaya(JenisBudaya jenisBudaya) {
        this.jenisBudaya = jenisBudaya;
    }

    // Method untuk mengupdate semua atribut
    public void updatePaketWisataBudaya(
            String namaPaket,
            String lokasi,
            String deskripsi,
            double harga,
            int durasiHari,
            Date jadwal,
            JenisBudaya jenisBudaya) {
        super.setNamaPaket(namaPaket);
        super.setLokasi(lokasi);
        super.setDeskripsi(deskripsi);
        super.setHarga(harga);
        super.setDurasiHari(durasiHari);
        super.setJadwal(jadwal);
        this.jenisBudaya = jenisBudaya;
    }

    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        String jadwalStr = getJadwal() != null ? fmt.format(getJadwal()) : "N/A";

        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append(String.format(" PAKET WISATA : %s\n", getNamaPaket()));
        sb.append("----------------------------------------\n");
        sb.append(String.format(" Lokasi       : %s\n", getLokasi()));
        sb.append(String.format(" Deskripsi    : %s\n", getDeskripsi()));
        sb.append(String.format(" Harga        : Rp %.0f\n", getHarga()));
        sb.append(String.format(" Durasi       : %d hari\n", getDurasiHari()));
        sb.append(String.format(" Jadwal       : %s\n", jadwalStr));
        sb.append("----------------------------------------\n");
        sb.append(String.format(" Jenis Budaya : %s\n", jenisBudaya != null ? jenisBudaya : "-"));
        sb.append("========================================");
        return sb.toString();
    }
}
