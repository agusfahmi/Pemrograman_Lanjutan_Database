package crud;

import connect.Koneksi;
import programs.Main;
import programs.data;
import programs.crudMenu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class insert {
    public static void insertData() {
        Connection connection = Koneksi.getConnection();
        try {
            String sqlAddress ="SELECT * FROM data";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlAddress);

            int baju = 50000 , celana = 40000 , jas = 70000;
            double totalHarga = 0 ,bayar, sisa;
            Scanner inputan = new Scanner(System.in);
            Scanner in = new Scanner(System.in);
            data rekap = new data();
            System.out.println("Nama anda :");
            String namaAnda = inputan.nextLine();
            System.out.println("Alamat anda :");
            String alamat = inputan.nextLine();
            System.out.println("Input banyak barang :");
            int banyakBarang = inputan.nextInt();
            int[] namajenis  = new int[banyakBarang];
            String[] ukuran = new String[banyakBarang];
            int[] jumlah = new int[banyakBarang];
            int[] hargatotal = new int[banyakBarang];
            for (int i=0;i<banyakBarang;i++){
                System.out.println("list Barang :");
                System.out.println("1.Baju\n2.Celana\n3.Jas");
                System.out.println("Input jenis (Angka) :");
                int namaj = inputan.nextInt();
                if (namaj <= 3){
                    namajenis[i] =namaj;
                    System.out.println("Input ukuran :");
                    ukuran[i] = in.nextLine();
                    System.out.println("Input Jumlah :");
                    jumlah[i] = inputan.nextInt();
                    rekap.setNama(namaAnda);
                    rekap.setAlamat(alamat);
                    rekap.setPakaianJenis(namajenis[i]);
                    rekap.setUkuran(ukuran[i]);
                    rekap.setJumlah(jumlah[i]);
                    if (namaj == 1){
                        hargatotal[i] = jumlah[i]*baju;
                        int a = baju*jumlah[i];
                        rekap.setTotalHarga(a);
                    }else if (namaj == 2){
                        hargatotal[i] =celana*jumlah[i];
                        int b = celana*jumlah[i];
                        rekap.setTotalHarga(b);
                    }else if (namaj == 3){
                        hargatotal[i] = jas*jumlah[i];
                        int c = jas*jumlah[i];
                        rekap.setTotalHarga(c);
                    }
                    totalHarga = hargatotal[i]+totalHarga;

                    String sql = "INSERT INTO data (nama,alamat,pakaianJenis,ukuran,jumlah,totalHarga) VALUES ('%s','%s','%s','%s','%d','%d')";
                    sql = String.format(sql,rekap.getNama(), rekap.getAlamat(),rekap.getPakaianJenis(),rekap.getUkuran(),rekap.getJumlah(),rekap.getTotalHarga());

                    stmt.execute(sql);
                }else {
                    System.out.println("Maaf yang anda masukkan tidak ada di daftar pakaian\n");
                    System.out.println("Ulangi input ? (y/n)");
                    String ulang = inputan.nextLine();
                    if (ulang.equals("y")){
                        insertData();
                    }else if (ulang.equals("n")){
                        System.exit(0);
                    }else {
                        System.out.println("Maaf salah input");
                        crudMenu.showMenu();
                    }
                }
            }
            System.out.println("Bayar :");
            bayar = inputan.nextDouble();
            sisa = bayar - totalHarga;

            System.out.println("Cetak struck : (y/n)" );
            String cetak = in.nextLine();
            if (cetak.equals("y")){
                Date waktu = new Date();
                SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'pada' hh:mm:ss a zzz");
                System.out.println("+------------------------------------------+");
                System.out.println("         TOKO AMANAH SEJAHTERA              ");
                System.out.println("+-------------------------------------------+");
                System.out.println(ft.format(waktu));
                System.out.println("----------------------------------------------");
                System.out.println("NO\tPakaian Jenis\tJumlah\tHarga Total");
                for (int i=0;i<banyakBarang;i++){
                    System.out.println((i+1)+"\t\t"+namajenis[i]+"\t"+jumlah[i]+"\t"+hargatotal[i]);
                }
                System.out.println("\n\n\n");
                System.out.println("-------------------------------------------");
                System.out.println("Total  : "+totalHarga);
                System.out.println("Bayar  : "+ bayar);
                System.out.println("Sisa   : "+ sisa);
                System.out.println("------------------------------------------");
                System.out.println("        TERIMAKASIH TELAH BERBELANJA       ");
            }else if (cetak.equals("n")){
                Main.menu();
            }else {
                System.out.println("Salah input");

            }

        } catch (InputMismatchException e){
            System.out.println("Terdapat kesalahan format input");
        } catch (Exception e) {
            System.out.println("Terdapat kesalahan pada "+e);
        }

    }
}
