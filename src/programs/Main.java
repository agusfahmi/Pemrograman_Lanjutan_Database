package programs;


/**
 * @author Agus Fahmi, Anggoro Trio, Elisa Ramadanti
 * kelas 2G
 */

import crud.insert;
import connect.Koneksi;
import java.util.Scanner;
public class Main {
    /**
     * @param args the command line arguments
     * user akan di sediakan pilihan awal dimana harus menginputkan pilihan
     */
    public static void main(String[] args) {
        Koneksi.getConnection();
        menu();
    }
    /**
     * method menu untuk menampilkan tampilan awal menu
     */
    static int i = 0 ;
    public static void menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("+============= Program Pemasanan Pakaian ===========+");
        System.out.println("+                 TOKO AMANAH SEJAHTERA             +");
        System.out.println("+====================================================+");
        System.out.println("1.Pesan Sekarang");
        System.out.println("2.Data Pembelian");
        System.out.println("3.Keluar");
        System.out.println("masukkan pilihan anda :");
        int pilih = in.nextInt();
        switch (pilih){
            case 1:
                insert.insertData();
                menu();
                break;
            case 2:
                if (i == 1){
                    crudMenu.showMenu();
                }else {
                    Scanner input = new Scanner(System.in);
                    System.out.println("-------------------------------------");
                    System.out.println("        DATABASE PEMBELIAN           ");
                    System.out.println("-------------------------------------");
                    System.out.println("Username :");
                    String user = input.nextLine();
                    System.out.println("Password :");
                    String pass = input.nextLine();
                 if (i == 1){
                     crudMenu.showMenu();
                 }else {
                     if (user.equals("admin") && pass.equals("admin123")){
                         System.out.println("Login berhasil");
                         i=1;
                         crudMenu.showMenu();
                     }else {
                         System.out.println("Maaf , username atau password anda salah");
                     }
                 }
                    }
                menu();
                break;
            case 3:
                System.exit(0);
            default:
                menu();
        }
    }

    public void logout(int a) {
        this.i = a;
    }
}