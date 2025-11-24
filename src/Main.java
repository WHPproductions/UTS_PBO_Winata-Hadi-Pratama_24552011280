import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Kelas utama untuk menjalankan aplikasi manajemen paket wisata.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Isi list pelenggan-pelanggan yang ada di dalam sistem
        List<Pelanggan> pelangganList = new ArrayList<>();

        // Menu awal ketika aplikasi dijalankan
        System.out.println("==================================================");
        System.out.println("Selamat datang di aplikasi manajemen paket wisata!");
        printMenu();
        System.out.print("Pilihan: ");
        int pilihan;
        pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        // Pelanggan dummy untuk demo
        Pelanggan pelanggan1 = new Pelanggan(1, "Andi", "Jl. Merdeka No.1", "08123456789", new ArrayList<>());
        Pelanggan pelanggan2 = new Pelanggan(2, "Budi", "Jl. Sudirman No.2", "08987654321", new ArrayList<>());
        Pelanggan pelanggan3 = new Pelanggan(3, "Caca", "Jl. Jend. Sudirman No.3", "08765432109", new ArrayList<>());
        pelangganList.add(pelanggan1);
        pelangganList.add(pelanggan2);
        pelangganList.add(pelanggan3);

        // Loop menu utama, seluruh sistem berjalan di dalam loop ini.
        // Sistem bekerja sesuai dengan pilihan user
        do {
            switch (pilihan) {
                case 1: // Melihat list pelanggan-pelanggan yang ada di sistem
                    for (Pelanggan p : pelangganList) {
                        System.out.println(p);
                    }
                    break;
                case 2: // Mengelola paket wisata untuk pelanggan tertentu
                    System.out.print("Masukkan ID Pelanggan yang ingin login: ");
                    int idPelanggan = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline
                    Pelanggan pelanggan = pelangganList.stream()
                            .filter(p -> p.getIdPelanggan() == idPelanggan)
                            .findFirst()
                            .orElse(null);
                    if (pelanggan != null) {
                        MenuPaketWisata menu = new MenuPaketWisata(pelanggan);
                        menu.start();
                    } else {
                        System.out.println("Pelanggan dengan ID tersebut tidak ditemukan.");
                    }
                    break;
                case 0: // Keluar dari aplikasi
                    System.out.println("Terima kasih telah menggunakan aplikasi ini. Sampai jumpa!");
                    break;
                default: // Pilihan user tidak valid
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            // Tampilkan menu kembali
            printMenu();
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

        } while (pilihan != 0);
        scanner.close();
    }

    // Method untuk menampilkan menu utama
    private static void printMenu() {
        System.out.println("==================================================");
        System.out.println("Pilih menu yang tersedia:");
        System.out.println("1. Lihat List Pelanggan");
        System.out.println("2. Kelola Paket Wisata");
        System.out.println("0. Keluar");
        System.out.println("--------------------------------------------------");
    }
}