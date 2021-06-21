package programs;

import java.util.Scanner;
import crud.insert;
import crud.update;
import crud.show;
import crud.delete;

public class crudMenu {
    public static void showMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n===========CRUD==========");
        System.out.println("1. Insert Data");
        System.out.println("2. Show Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("0. Keluar / logout");
        System.out.println();
        System.out.print("PILIHAN > ");
        try {
            int pilihan = input.nextInt();
            switch (pilihan){
                case 0:
                Main m = new Main();
                m.logout(0);
                Main.menu();
                case 1:
                    insert.insertData();
                case 2:
                    show.showData();
                    break;
                case 3:
                    update.updateData();
                    break;
                case 4:
                    delete.deleteData();
                    break;
                default:
                    System.out.println("Pilihan salah!");
                    showMenu();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
