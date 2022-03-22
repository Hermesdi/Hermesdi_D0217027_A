package POS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project {

    public static void main(String[] args) {

        int kode_barang = -1;
        ArrayList<Konstruktor> tabelKonstruktorDariFile = readTabelBarangToFile("SaveData.txt");
        ArrayList<Konstruktor> tabelKonstruktor = new ArrayList<>();
        if (tabelKonstruktorDariFile != null) {
            tabelKonstruktor = tabelKonstruktorDariFile;
        }

        Scanner sc = new Scanner(System.in);
        String total = "transaksi.txt";
        boolean result = true;

        while (result) {

            System.out.println("======================================");
            System.out.println("   SILAHKAN PILIH MENU YANG TERSEDIA  ");
            System.out.println("======================================");
            System.out.println("A = Add                              |");
            System.out.println("S = Save                             |");
            System.out.println("V = View                             |");
            System.out.println("R = Remove                           |");
            System.out.println("P = Penjualan                        |");
            System.out.println("E = Exit                             |");
            System.out.println("======================================");
            System.out.print("MASUKKAN MENU PILIHAN ANDA: ");
            String pilih = sc.nextLine();

            if (pilih.equalsIgnoreCase("A")) {
                boolean A = true;
                while (A) {
                    System.out.println("======================================");
                    System.out.println("   INI ADALAH MENU ADD  ");
                    System.out.println("======================================");
                    System.out.println("AB = ADD BARANG                       |");
                    System.out.println("AS = ADD STOCK                        |");
                    System.out.println("D = DONE                              |");
                    System.out.println("======================================");
                    System.out.print("MASUKKAN MENU ADD YANG ANDA PILIH: ");
                    String tambah = sc.nextLine();
                    if (tambah.equalsIgnoreCase("AB")) {
                        System.out.println("ANDA MEMILIH ADD BARANG");
                        System.out.println("======================================");

                        kode_barang++;
                        System.out.println("KODE BARANG DIMASUKKAN SECARA OTOMATIS");

                        System.out.print("MASUKKAN NAMA BARANG: ");
                        String nama_barang = sc.nextLine();

                        System.out.print("MASUKKAN JENIS BARANG: ");
                        String jenis_barang = sc.nextLine();

                        System.out.print("MASUKKAN HARGA BARANG: ");
                        String strharga_barang = sc.nextLine();
                        double harga_barang = Double.parseDouble(strharga_barang);

                        System.out.print("MASUKKAN JUMLAH STOCK: ");
                        String strastock = sc.nextLine();
                        int stock = Integer.parseInt(strastock);

                        Konstruktor barang = new Konstruktor(kode_barang, nama_barang, jenis_barang, harga_barang, stock);
                        tabelKonstruktor.add(barang);

                    } else if (tambah.equalsIgnoreCase("AS")) {
                        int index = -1;

                        boolean ditemukan = false;

                        System.out.println("ANDA MEMILIH MENU ADD STOCK");
                        System.out.println("======================================");

                        System.out.print("TAMBAHKAN STOCK DENGAN KODE BARANG: ");
                        int add = sc.nextInt();
                        System.out.println("======================================");
                        System.out.print("MASUKKAN JUMLAH STOCK: ");
                        int update = sc.nextInt();
                        for (int j = 0; j < tabelKonstruktor.size(); j++) {
                            if (tabelKonstruktor.get(j).kode_barang == kode_barang) {
                                index = j;
                                ditemukan = true;
                            }
                        }
                        if (ditemukan == true) {
                            Konstruktor updateStock = tabelKonstruktor.get(add);
                            updateStock.stock = tabelKonstruktor.get(add).stock + update;

                        } else {
                            System.out.println("KODE BARANG TIDAK DITEMUKAN");
                        }

                    } else if (tambah.equals("D")) {
                        System.out.println("PROSES ANDA DIAKHIRI");
                        A = false;
                    } else {
                        System.out.println("MASUKKAN MENU ADD YANG BENAR");
                    }

                }

            } else if (pilih.equalsIgnoreCase("S")) {
                System.out.println("INI ADALAH MENU SAVE");
                System.out.println("======================================");
                System.out.println("APAKAH ANDA YAKIN INGIN MENYIMPAN DATA...? (Y/N)");
                String simpan = sc.nextLine();
                if (simpan.equalsIgnoreCase("Y")) {
                    saveTabelBarangToFile(tabelKonstruktor, "SaveData.txt");
                    System.out.println("PENYIMPANAN BERHASIL");
                } else {
                    System.out.println("PROSES PENYIMPANAN DATA GAGAL");
                }

            } else if (pilih.equalsIgnoreCase("V")) {
                System.out.println("======================================");
                System.out.println("   INI ADALAH MENU VIEW DATA BARANG ");
                System.out.println("======================================");
                System.out.println("KODE BARANG\t" + "NAMA BARANG\t" + "JENIS BARANG\t" + "HARGA BARANG\t" + "STOCK\t" + "TERJUAL\t");
                for (Konstruktor value : tabelKonstruktor) {
                    System.out.println(value);
                }

            } else if (pilih.equalsIgnoreCase("R")) {
                int index = -1;
                boolean R = false;

                System.out.println("======================================");
                System.out.println("   INI ADALAH MENU REMOVE  ");
                System.out.println("======================================");
                System.out.println("KODE BARANG\t" + "NAMA BARANG\t" + "JENIS BARANG\t" + "HARGA BARANG\t" + "STOCK\t" + "TERJUAL\t");
                for (Konstruktor value : tabelKonstruktor) {
                    System.out.println(value);
                }
                System.out.print("MASUKKAN KODE BARANG YANG AKAN DI HAPUS: ");
                int hapus = sc.nextInt();

                for (int j = 0; j < tabelKonstruktor.size(); j++) {
                    if (tabelKonstruktor.get(j).kode_barang == hapus) {
                        index = j;
                        R = true;
                    }
                }
                if (R == true) {
                    System.out.print("APAKAH ANDA YAKIN AKAN MENGHAPUS FILE...?(Y/N): ");
                    String hapusbarang = sc.next();
                    if (hapusbarang.equalsIgnoreCase("Y")) {
                        tabelKonstruktor.remove(hapus);
                        System.out.println("DATA BERHASIL DI HAPUS");

                    } else if (R == false) {
                        System.out.println("KODE BARANG YANG ANDA MASUKKAN TIDAK DITEMUKA");
                    }
                }

            } else if (pilih.equalsIgnoreCase("P")) {

                boolean P = true;
                int index = -1;
                while (P) {
                    System.out.println("======================================");
                    System.out.println("   INI ADALAH MENU PENJUALAN  ");
                    System.out.println("======================================");
                    System.out.println("AP = ADD ADD PENJUALAN               |");
                    System.out.println("D = DONE                             |");
                    System.out.println("======================================");
                    String transaksi = sc.nextLine();
                    if (transaksi.equalsIgnoreCase("AP")) {
                        System.out.println("KODE BARANG\t" + "NAMA BARANG\t" + "JENIS BARANG\t" + "HARGA BARANG\t" + "STOCK\t" + "TERJUAL\t");
                        for (Konstruktor value : tabelKonstruktor) {
                            System.out.println(value);
                        }
                        boolean AD = false;
                        System.out.println("======================================");
                        System.out.println("ANDA MEMILIH MENU ADD BARANG");
                        System.out.println("======================================");
                        System.out.println("PILIH KODE BARANG YANG AKAN DIJUAL    : ");
                        int dijual = sc.nextInt();
                        System.out.println("MAUKKAN JUMLAH BARANG YANG AKAN DIJUAL: ");
                        int laku = sc.nextInt();
                        for (int j = 0; j < tabelKonstruktor.size(); j++) {
                            if (tabelKonstruktor.get(j).kode_barang == dijual) {
                               
                                    index = j;
                                    AD = true;
                               
                                
                            }
                        }
                        if (AD == true) {
                            Konstruktor updateTerjual = tabelKonstruktor.get(dijual);
                            updateTerjual.stock = tabelKonstruktor.get(dijual).stock - laku;
                            updateTerjual.terjual = tabelKonstruktor.get(dijual).terjual + laku;

                            try {
                                FileWriter fileWriter = new FileWriter(total, true);
                                fileWriter.write("\n================================================");
                                fileWriter.write("\nDATA BELANJA");
                                fileWriter.write("\n================================================");
                                fileWriter.write("\nKODE BARANG      :" + dijual);
                                fileWriter.write("\nNAMA BARANG      :" + tabelKonstruktor.get(index).nama_barang);
                                fileWriter.write("\nJENIS BARANG     :" + tabelKonstruktor.get(index).jenis_barang);
                                fileWriter.write("\nHARGA BARANG     :" + tabelKonstruktor.get(index).harga_barang);
                                fileWriter.write("\nJUMLAH BARANG    :" + laku);
                                fileWriter.write("\n================================================");
                                fileWriter.write("\nTOTAL BAYAR       " + tabelKonstruktor.get(index).harga_barang * laku);
                                fileWriter.write("\n================================================");
                                fileWriter.close();

                            } catch (IOException e) {
                                System.out.println("TERJADI KESALAHAN");
                                e.printStackTrace();

                            }

                            try {
                                File fl = new File(total);
                                Scanner fr = new Scanner(fl);
                                while (fr.hasNextLine()) {
                                    String Data = fr.nextLine();
                                    System.out.println(Data);
                                }

                            } catch (IOException e) {
                                System.out.println("TERJADI KESALAHAN");
                                e.printStackTrace();

                            }

                        } else if (AD == false) {
                            System.out.println("KODE BARANG YANG ANDA MASUKKAN TIDAK BENAR");
                        }
                    }else if(transaksi.equalsIgnoreCase("D")){
                        System.out.println("SELESAI");
                        System.out.println("SILAHKAN CETAK TRANSAKSI ANDA DI FILE TRANSAKSI.TXT ");
                        P = false;
                    }
                }
            } else if (pilih.equalsIgnoreCase("E")) {
                System.out.println("INI ADALAH MENU EXIT");
                saveTabelBarangToFile(tabelKonstruktor, "SaveData.txt");
                System.out.println("FILE ANDA TELAH DISIMPAN SECARA OTOMATIS");
                break;
            } else {
                System.out.println("MASUKKAN PILIHAN MENU YANG BENAR");
            }

        }

    }

    public static boolean saveTabelBarangToFile(ArrayList<Konstruktor> tabelKonstruktor, String url) {
        boolean result = false;
        try {
            if (tabelKonstruktor != null && !tabelKonstruktor.isEmpty() && url != null) {
                FileWriter fw = new FileWriter(url);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Konstruktor b : tabelKonstruktor) {
                    bw.append(b.toString());
                    bw.append("\n");
                }
                bw.close();
                fw.close();
                result = true;
            }
            //
        } catch (IOException e) {
            System.out.println("PENYIMPANAN DATA KE FILE GAGAL");
            e.printStackTrace();
            //
        }
        return result;
    }

    public static ArrayList<Konstruktor> readTabelBarangToFile(String url) {
        ArrayList<Konstruktor> data = null;
        int kode_barang = -1;

        try {
            FileReader fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            data = new ArrayList<>();
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] elements = baris.split(";");

                kode_barang++;

                String nama_barang = elements[1];

                String jenis_barang = elements[2];

                String strharga_barang = elements[3];
                double harga_barang = Double.parseDouble(strharga_barang);

                String strastock = elements[4];
                int stock = 20;//Integer.parseInt(strastock);

                String strterjual = elements[5];
                int terjual = 0; //Integer.parseInt(strterjual);

                Konstruktor barang = new Konstruktor(kode_barang, nama_barang, jenis_barang, harga_barang, stock, terjual);
                data.add(barang);

            }
            br.close();
            fr.close();
            //
        } catch (IOException e) {
            System.out.println("PEMBACAAN DATA DARI FILE GAGAL");
            e.printStackTrace();

        }
        return data;
    }

}
