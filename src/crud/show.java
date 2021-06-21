package crud;

import connect.Koneksi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class show {
    public static void showData(){
        Connection connection = Koneksi.getConnection();
        try {
            String sql ="SELECT * FROM data";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|                       DATA PEMBELIAN                          |");
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ID\tnama\talamat\tpakaian jenis\tukuran\tjumlah\ttotal harga\ttanggal\t");
            System.out.println("-----------------------------------------------------------");
            while (rs.next()){
                int id = rs.getInt("ID");
                String nama = rs.getString("nama");
                String alamat = rs.getString("alamat");
                int pakaianJenis = rs.getInt("pakaianJenis");
                String ukuran = rs.getString("ukuran");
                int jumlah = rs.getInt("jumlah");
                int totalHarga = rs.getInt("totalHarga");
                Date tanggal = rs.getDate("tanggal");
                DateFormat tgl = new SimpleDateFormat("E yyyy.MM.dd 'pada' HH:mm:ss a ");

                System.out.printf("%d\t%s\t%s\t%d\t%s\t%d\t%d\t%s\n", id,nama,alamat,pakaianJenis,ukuran,jumlah,totalHarga,tgl.format(tanggal));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
