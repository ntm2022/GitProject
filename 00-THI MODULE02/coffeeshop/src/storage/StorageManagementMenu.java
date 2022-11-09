package storage;

import java.util.Date;
import java.util.Scanner;

public class StorageManagementMenu{
    int choice, id;
    double quantity, importPrice;
    String name, unit, supplierInfo;
    Date createdAt, updatedAt;
    Scanner scanner = new Scanner(System.in);
    StorageManagement storageManagement = StorageManagement.getStorageManagement();
    public void displayMenu(){
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println("+    Chương trình quản lý TỒN KHO    +");
        System.out.println("++++++++++++++++++++++++++++++++++++++");
    };
    public void menu(){
        do {
            displayMenu();
            System.out.println("1.THÊM 2.XÓA 3.UPDATE 4.Search By ID " +
                    "\n 5.Search By Name 6.Warnings OutOfStock 7.View ALL 0.EXIT");
            choice = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (choice) {
                case 1:
                    add(false);
                    break;
                case 2:
                    System.out.println("Nhập ID để XÓA:");
                    id = Integer.parseInt(scanner.nextLine());
                    if(storageManagement.remove(id)) {
                        System.out.println("Removed id = " + id);
                    }else {
                        System.out.println("K tim thay id = " + id);
                    }
                    break;
                case 3:
                    add(true);
                    break;
                case 4:
                    System.out.println("Nhập SKU để SEARCH:");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println(storageManagement.searchByID(id));
                    break;
                case 5:
                    System.out.println("Nhập TÊN ITEM để SEARCH:");
                    name = scanner.nextLine();
                    System.out.println(storageManagement.searchByName(name));
                    break;
                case 6:
                    System.out.println(storageManagement.searchWarnings());
                    break;
                case 7:
                    System.out.println(storageManagement);
                    break;
            }
        }while(choice!=0);
    }
    public void add(boolean isUpdate){
        //(int sku, String name, double quantity, String unit, double importPrice, String supplierInfo, Date createdAt, Date updatedAt)
        System.out.println("Nhập SKU để THÊM/CẬP NHẬT:");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên Item:");
        name = scanner.nextLine();
        System.out.println("Nhập số lượng:");
        quantity = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập đơn vị:");
        unit = scanner.nextLine();
        System.out.println("Giá NHẬP:");
        importPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Thông tin nhà cung cấp:");
        supplierInfo = scanner.nextLine();
        if(!isUpdate) {
            createdAt = new Date();
            updatedAt = new Date();
            System.out.println("Added id: " + storageManagement.add(new Storage(id, name, quantity, unit, importPrice, supplierInfo, createdAt, updatedAt)));
        }else{
            updatedAt = new Date();
            System.out.println("Updated id: " + storageManagement.update(id, new Storage(id, name, quantity, unit, importPrice, supplierInfo, createdAt, updatedAt)));
        }
    }
}