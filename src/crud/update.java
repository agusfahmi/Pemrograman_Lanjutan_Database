package crud;

import connect.Koneksi;
import programs.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class update {
    public static void updateData(){
        Scanner input = new Scanner(System.in);
        Connection connection = Koneksi.getConnection();
        try {
            String sqlAddress = "SELECT * FROM data";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlAddress);

            Scanner in = new Scanner(System.in);
            System.out.println("Masukkan ID yang mau di edit");
            int idData = input.nextInt();
            data rekap = new data();
            System.out.println("Nama anda :");
            String namaAnda = in.nextLine();
            rekap.setNama(namaAnda);
            System.out.println("Alamat anda :");
            String alamat = in.nextLine();
            rekap.setAlamat(alamat);
            System.out.println("list Barang :");
            System.out.println("1.Baju\n2.Celana\n3.Jas");
            System.out.println("Input jenis (Angka) :");
            String namaJenis = in.nextLine();
            rekap.setPakaianJenis(Integer.parseInt(namaJenis));
            System.out.println("Input ukuran :");
            String ukuran = in.nextLine();
            rekap.setUkuran(ukuran);
            System.out.println("Input Jumlah :");
            int jumlah = in.nextInt();
            rekap.setJumlah(jumlah);
            int baju = 50000 , celana = 40000 , jas = 70000;
            if (namaJenis.equals("1")){
                int a = baju*jumlah;
                rekap.setTotalHarga(a);
            }else if (namaJenis.equals("2")){
                int b = celana*jumlah;
                rekap.setTotalHarga(b);
            }else if (namaJenis.equals("3")){
                int c = jas*jumlah;
                rekap.setTotalHarga(c);
            }
            String sql = "UPDATE data SET nama = '%s',alamat = '%s',pakaianJenis = '%d',ukuran ='%s',jumlah = '%d',totalHarga ='%d' WHERE ID =%d";
            sql = String.format(sql,rekap.getNama(), rekap.getAlamat(),rekap.getPakaianJenis(),rekap.getUkuran(),rekap.getJumlah(),rekap.getTotalHarga(),idData);

            stmt.execute(sql);
            System.out.println("Update data berhasil");

        } catch (SQLException e) {
            System.out.println("Terdapat kesalahan pada "+e);
        }catch (InputMismatchException e){
            System.out.println("Terdapat kesalahan format input");
        }
    }
}
