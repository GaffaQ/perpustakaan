import java.util.Scanner;

import Entity.Buku;
import Entity.Mahasiswa;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan NIM   : ");
        String nim = sc.nextLine();

        System.out.print("Masukkan Nama  : ");
        String nama = sc.nextLine();

        Mahasiswa mhs = new Mahasiswa(nim, nama);

        System.out.print("Berapa buku yang ingin dipinjam? ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= jumlah; i++) {
            System.out.println("\nBuku ke-" + i);
            System.out.print("Masukkan ISBN : ");
            String isbn = sc.nextLine();

            System.out.print("Masukkan Judul: ");
            String judul = sc.nextLine();

            Buku bk = new Buku(isbn, judul);
            mhs.pinjam(bk);
        }

        System.out.println("\n====================================================");
        System.out.println("Nim   : " + mhs.getNim());
        System.out.println("Nama  : " + mhs.getNama());
        System.out.println("----------------------------------------------------");
        System.out.printf("| %-3s | %-15s | %-30s |\n", "No", "ISBN", "Judul");
        System.out.println("----------------------------------------------------");

        int no = 1;
        for (Buku b : mhs.getDaftarPinjaman()) {
            System.out.printf("| %-3d | %-15s | %-30s |\n",
                    no++, b.getIsbn(), b.getJudul());
        }

        System.out.println("----------------------------------------------------");
    }
}
