import java.util.Date;
import java.text.SimpleDateFormat;

public class WisataAlam extends PaketWisata {
    // Tingkat konservasi alam. Ini menentukan seberapa ketat aturan konservasi di
    // area wisata alam tersebut.
    public enum TingkatKonservasi {
        RENDAH,
        SEDANG,
        TINGGI
    }

    // Jenis aktivitas alam yang dilakukan secara umum selama wisata
    public enum JenisAktivitasAlam {
        HIKE,
        TREKKING,
        KEMAH,
        PENGAMATAN_SATWA,
        PANDAK_GUNUNG
    }

    // contoh field spesifik untuk paket wisata alam
    private TingkatKonservasi tingkatKonservasi;
    private JenisAktivitasAlam jenisAktivitasAlam;
    private String deskripsiWaspada = null; // deskripsi tentang potensi bahaya alam bila ada

    public WisataAlam(
            String namaPaket,
            String lokasi,
            String deskripsi,
            double harga,
            int durasiHari,
            Date jadwal,
            TingkatKonservasi tingkatKonservasi,
            JenisAktivitasAlam jenisAktivitasAlam,
            String deskripsiWaspada) {
        super(namaPaket, lokasi, deskripsi, harga, durasiHari, jadwal);
        this.tingkatKonservasi = tingkatKonservasi;
        this.jenisAktivitasAlam = jenisAktivitasAlam;
        this.deskripsiWaspada = deskripsiWaspada;
    }

    public WisataAlam(
            String namaPaket,
            String lokasi,
            String deskripsi,
            double harga,
            int durasiHari,
            Date jadwal,
            TingkatKonservasi tingkatKonservasi,
            JenisAktivitasAlam jenisAktivitasAlam) {
        super(namaPaket, lokasi, deskripsi, harga, durasiHari, jadwal);
        this.tingkatKonservasi = tingkatKonservasi;
        this.jenisAktivitasAlam = jenisAktivitasAlam;
    }

    // Getters
    public TingkatKonservasi getTingkatKonservasi() {
        return tingkatKonservasi;
    }

    public JenisAktivitasAlam getJenisAktivitasAlam() {
        return jenisAktivitasAlam;
    }

    public String getDeskripsiWaspada() {
        return deskripsiWaspada;
    }

    // Setters
    public void setTingkatKonservasi(TingkatKonservasi tingkatKonservasi) {
        this.tingkatKonservasi = tingkatKonservasi;
    }

    public void setJenisAktivitasAlam(JenisAktivitasAlam jenisAktivitasAlam) {
        this.jenisAktivitasAlam = jenisAktivitasAlam;
    }

    public void setDeskripsiWaspada(String deskripsiWaspada) {
        this.deskripsiWaspada = deskripsiWaspada;
    }

    public void updatePaketWisataAlam(
            String namaPaket,
            String lokasi,
            String deskripsi,
            double harga,
            int durasiHari,
            Date jadwal,
            TingkatKonservasi tingkatKonservasi,
            JenisAktivitasAlam jenisAktivitasAlam,
            String deskripsiWaspada) {
        super.setNamaPaket(namaPaket);
        super.setLokasi(lokasi);
        super.setDeskripsi(deskripsi);
        super.setHarga(harga);
        super.setDurasiHari(durasiHari);
        super.setJadwal(jadwal);
        this.tingkatKonservasi = tingkatKonservasi;
        this.jenisAktivitasAlam = jenisAktivitasAlam;
        this.deskripsiWaspada = deskripsiWaspada;
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
        sb.append(String.format(" Konservasi   : %s\n", tingkatKonservasi != null ? tingkatKonservasi : "-"));
        sb.append(String.format(" Aktivitas    : %s\n", jenisAktivitasAlam != null ? jenisAktivitasAlam : "-"));
        sb.append(String.format(" Waspada      : %s\n", deskripsiWaspada != null ? deskripsiWaspada : "-"));
        sb.append("========================================");
        return sb.toString();
    }
}
