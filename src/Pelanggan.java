import java.util.List;

public class Pelanggan {
    private int idPelanggan;
    private String nama;
    private String alamat;
    private String noTelp;
    List<PaketWisata> paketDiambil;

    public Pelanggan(
            int idPelanggan,
            String nama,
            String alamat,
            String noTelp,
            List<PaketWisata> paketDiambil) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.paketDiambil = paketDiambil;
    }

    // Getters
    public int getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public List<PaketWisata> getPaketDiambil() {
        return paketDiambil;
    }

    // Setters
    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setPaketDiambil(List<PaketWisata> paketDiambil) {
        this.paketDiambil = paketDiambil;
    }

    // PaketWisata list CRUD operations
    public void createPaketWisata(PaketWisata paket) {
        paketDiambil.add(paket);
    }

    public PaketWisata readPaketWisata(int index) {
        return paketDiambil.get(index);
    }

    public void updatePaketWisata(int index, PaketWisata paket) {
        paketDiambil.set(index, paket);
    }

    public void deletePaketWisata(int index) {
        paketDiambil.remove(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append(String.format(" ID Pelanggan  : %d\n", idPelanggan));
        sb.append("----------------------------------------\n");
        sb.append(String.format(" Nama          : %s\n", nama));
        sb.append(String.format(" Alamat        : %s\n", alamat));
        sb.append(String.format(" Nomor Telepon : %s\n", noTelp));
        return sb.toString();
    }
}
