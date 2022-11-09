import ordering.OrderingManagementMenu;
import receipt.ReceiptManagementMenu;
import staff.StaffManagementMenu;
import storage.StorageManagementMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+1.RECEIPTS 2.STORAGE 3.ORDERINGS 4.STAFFS 5.SETTINGS 0.EXIT+");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            choice = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (choice){
                case 1-> new ReceiptManagementMenu().menu();
                case 2-> new StorageManagementMenu().menu();
                case 3-> new OrderingManagementMenu().menu();
                case 4-> new StaffManagementMenu().menu();
                case 5-> System.out.println("version 2.0");
            }
        }while (choice != 0);
    }
}