package crud;

import connect.Koneksi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class delete {
    public static void deleteData(){
        Scanner input = new Scanner(System.in);
        Connection connection = Koneksi.getConnection();
        try {
            String sqlAddress = "SELECT * FROM data";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlAddress);

            System.out.println("Masukkan ID yang mau dihapus");
            int idData = input.nextInt();

            String sql = String.format("DELETE FROM data WHERE iD = %d",idData);
            stmt.execute(sql);
            System.out.println("Data "+idData+" telah terhapus");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
