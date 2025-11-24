import java.util.Scanner;
import java.util.Date;

/**
 * Kelas untuk menampilkan dan mengelola menu paket wisata bagi pelanggan.
 * Memungkinkan pelanggan untuk menambah, melihat, mengupdate, menghapus,
 * dan mencari paket wisata yang mereka ambil.
 * 
 * Seluruh sistem CRUD ada di sini.
 */

public class MenuPaketWisata {
    // Atribut pelanggan yang sedang login
    private Pelanggan pelanggan;

    // Konstruktor, menerima objek pelanggan yang sedang login
    public MenuPaketWisata(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    // Method untuk menampilkan menu paket wisata dan menangani interaksi user,
    // sistem utama kelas ini berada di sini.
    public void start() {
        System.out.println("==================================================");
        System.out.println("           Pelanggan yang sedang login            ");
        System.out.println(pelanggan);
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do { // Loop menu paket wisata
            tampilkanMenu();
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            System.out.println("--------------------------------------------------");
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) { // Logika menu sesuai pilihan pelanggan
                case 1: // Menambah paket wisata baru
                    int jenisPaketWisata;
                    System.out.println("Jenis Paket Wisata yang Tersedia:");
                    System.out.println("1. Wisata Alam");
                    System.out.println("2. Wisata Budaya");
                    System.out.print("Pilih jenis paket wisata: ");
                    jenisPaketWisata = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline

                    // Variabel untuk paket wisata yang baru
                    String namaPaket;
                    String lokasi;
                    String deskripsi;
                    double harga;
                    int durasiHari;
                    Date jadwal;

                    // Input-input data paket wisata
                    System.out.print("Masukkan Nama Paket: ");
                    namaPaket = scanner.nextLine();
                    System.out.print("Masukkan Lokasi: ");
                    lokasi = scanner.nextLine();
                    System.out.print("Masukkan Deskripsi: ");
                    deskripsi = scanner.nextLine();
                    System.out.print("Masukkan Harga: ");
                    harga = scanner.nextDouble();
                    System.out.print("Masukkan Durasi Hari: ");
                    durasiHari = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline
                    System.out.println("Masukkan Jadwal (format: yyyy-MM-dd): ");
                    String jadwalInput = scanner.nextLine();
                    try {
                        jadwal = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(jadwalInput);
                    } catch (java.text.ParseException e) {
                        System.out.println("Format tanggal salah.");
                        break;
                    }

                    if (jenisPaketWisata == 1) { // Jika user memilih paket wisata alam
                        System.out.println("Tingkat Konservasi yang Tersedia:");
                        System.out.println("Rendah");
                        System.out.println("Sedang");
                        System.out.println("Tinggi");
                        System.out.println("Masukkan tingkat konservasi yang tersedia : ");
                        String tingkatKonservasiInput = scanner.nextLine();
                        WisataAlam.TingkatKonservasi tingkatKonservasi = WisataAlam.TingkatKonservasi
                                .valueOf(tingkatKonservasiInput.toUpperCase());
                        System.out.println("Jenis Aktivitas yang Tersedia:");
                        System.out.println("Hike");
                        System.out.println("Trekking");
                        System.out.println("Kemah");
                        System.out.println("Pengamatan_Satwa");
                        System.out.println("Pandak_Gunung");
                        System.out.println("Masukkan jenis aktivitas yang tersedia : ");
                        String jenisAktivitasInput = scanner.nextLine();
                        WisataAlam.JenisAktivitasAlam jenisAktivitasAlam = WisataAlam.JenisAktivitasAlam
                                .valueOf(jenisAktivitasInput.toUpperCase());
                        System.out.print("Masukkan Deskripsi Waspada: ");
                        String deskripsiWaspada = scanner.nextLine();

                        WisataAlam paketWisataAlam = new WisataAlam(
                                namaPaket,
                                lokasi,
                                deskripsi,
                                harga,
                                durasiHari,
                                jadwal,
                                tingkatKonservasi,
                                jenisAktivitasAlam,
                                deskripsiWaspada);
                        pelanggan.createPaketWisata(paketWisataAlam); // Menyimpan paket wisata alam ke dalam daftar
                                                                      // paket pelanggan
                    } else if (jenisPaketWisata == 2) { // Jika user memilih paket wisata budaya
                        System.out.println("Jenis Budaya yang Tersedia:");
                        System.out.println("Tari");
                        System.out.println("Festival");
                        System.out.println("Ritual");
                        System.out.println("Kuliner");
                        System.out.println("Kerajinan");
                        System.out.println("Masukkan jenis budaya yang tersedia : ");
                        String jenisAktivitasInput = scanner.nextLine();
                        WisataBudaya.JenisBudaya jenisBudaya = WisataBudaya.JenisBudaya
                                .valueOf(jenisAktivitasInput.toUpperCase());

                        WisataBudaya paketWisataBudaya = new WisataBudaya(
                                namaPaket,
                                lokasi,
                                deskripsi,
                                harga,
                                durasiHari,
                                jadwal,
                                jenisBudaya);
                        pelanggan.createPaketWisata(paketWisataBudaya); // Menyimpan paket wisata budaya ke dalam daftar
                                                                        // paket pelanggan
                    } else {
                        System.out.println("Jenis paket wisata tidak valid.");
                    }
                    break;
                case 2: // Melihat semua daftar paket-paket wisata yang diambil pelanggan
                    for (PaketWisata paket : pelanggan.getPaketDiambil()) {
                        System.out.println(paket);
                    }
                    break;
                case 3: // Mengupdate paket wisata yang sudah diambil pelanggan
                    System.out.println("Masukkan index paket wisata yang ingin diupdate: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline
                    PaketWisata paketWisata = pelanggan.readPaketWisata(index);
                    System.out.println(paketWisata);
                    if (paketWisata != null) {
                        System.out.print("Masukkan Nama Paket baru: ");
                        String namaPaketBaru = scanner.nextLine();
                        paketWisata.setNamaPaket(namaPaketBaru);
                        System.out.print("Masukkan Lokasi baru: ");
                        String lokasiBaru = scanner.nextLine();
                        paketWisata.setLokasi(lokasiBaru);
                        System.out.print("Masukkan Deskripsi baru: ");
                        String deskripsiBaru = scanner.nextLine();
                        paketWisata.setDeskripsi(deskripsiBaru);
                        System.out.print("Masukkan Harga baru: ");
                        double hargaBaru = scanner.nextDouble();
                        paketWisata.setHarga(hargaBaru);
                        System.out.print("Masukkan Durasi Hari baru: ");
                        int durasiHariBaru = scanner.nextInt();
                        paketWisata.setDurasiHari(durasiHariBaru);
                        System.out.println("Masukkan Jadwal baru (format: yyyy-MM-dd): ");
                        scanner.nextLine(); // Membersihkan newline
                        String jadwalInputBaru = scanner.nextLine();
                        try {
                            Date jadwalBaru = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(jadwalInputBaru);
                            paketWisata.setJadwal(jadwalBaru);
                        } catch (java.text.ParseException e) {
                            System.out.println("Format tanggal salah.");
                        }

                        if (paketWisata instanceof WisataAlam) {
                            WisataAlam wisataAlam = (WisataAlam) paketWisata;
                            System.out.println("Tingkat Konservasi yang Tersedia:");
                            System.out.println("Rendah");
                            System.out.println("Sedang");
                            System.out.println("Tinggi");
                            System.out.println("Masukkan Tingkat Konservasi baru: ");
                            String tingkatKonservasiInputBaru = scanner.nextLine();
                            WisataAlam.TingkatKonservasi tingkatKonservasiBaru = WisataAlam.TingkatKonservasi
                                    .valueOf(tingkatKonservasiInputBaru.toUpperCase());
                            wisataAlam.setTingkatKonservasi(tingkatKonservasiBaru);
                            System.out.println("Jenis Aktivitas yang Tersedia:");
                            System.out.println("Hike");
                            System.out.println("Trekking");
                            System.out.println("Kemah");
                            System.out.println("Pengamatan_Satwa");
                            System.out.println("Pandak_Gunung");
                            System.out.println("Masukkan Jenis Aktivitas baru: ");
                            String jenisAktivitasInputBaru = scanner.nextLine();
                            WisataAlam.JenisAktivitasAlam jenisAktivitasAlamBaru = WisataAlam.JenisAktivitasAlam
                                    .valueOf(jenisAktivitasInputBaru.toUpperCase());
                            wisataAlam.setJenisAktivitasAlam(jenisAktivitasAlamBaru);
                            System.out.print("Masukkan Deskripsi Waspada baru: ");
                            String deskripsiWaspadaBaru = scanner.nextLine();
                            wisataAlam.setDeskripsiWaspada(deskripsiWaspadaBaru);
                        } else if (paketWisata instanceof WisataBudaya) {
                            WisataBudaya wisataBudaya = (WisataBudaya) paketWisata;
                            System.out.println("Masukkan Jenis Budaya baru: ");
                            System.out.println("Tari");
                            System.out.println("Festival");
                            System.out.println("Ritual");
                            System.out.println("Kuliner");
                            System.out.println("Kerajinan");
                            String jenisBudayaInputBaru = scanner.nextLine();
                            WisataBudaya.JenisBudaya jenisBudayaBaru = WisataBudaya.JenisBudaya
                                    .valueOf(jenisBudayaInputBaru.toUpperCase());
                            wisataBudaya.setJenisBudaya(jenisBudayaBaru);
                        }

                        System.out.println("Paket wisata berhasil diupdate.");
                    } else {
                        System.out.println("Paket wisata dengan index tersebut tidak ditemukan.");
                    }
                    break;
                case 4:// Menghapus paket wisata yang sudah diambil pelanggan
                    System.out.println("Masukkan index paket wisata yang ingin dihapus: ");
                    int indexHapus = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline
                    pelanggan.deletePaketWisata(indexHapus);
                    System.out.println("Paket wisata berhasil dihapus.");
                    break;
                case 5: // Mencari detail paket wisata berdasarkan index
                    System.out.println("Masukkan index paket wisata yang ingin dicari: ");
                    int indexCari = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline
                    PaketWisata paketCari = pelanggan.readPaketWisata(indexCari);
                    if (paketCari != null) {
                        System.out.println(paketCari);
                    } else {
                        System.out.println("Paket wisata dengan index tersebut tidak ditemukan.");
                    }
                    break;
                case 0: // Kembali ke menu utama
                    System.out.println("Kembali ke Menu Utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
    }

    // Method untuk menampilkan menu paket wisata
    public void tampilkanMenu() {
        System.out.println("Menu Paket Wisata:");
        System.out.println("1. Tambah Paket Wisata");
        System.out.println("2. Lihat Paket-paket Wisata");
        System.out.println("3. Update Paket Wisata");
        System.out.println("4. Hapus Paket Wisata");
        System.out.println("5. Cari Detail Paket Wisata");
        System.out.println("0. Kembali ke Menu Utama");
        System.out.println("--------------------------------------------------");
    }
}
