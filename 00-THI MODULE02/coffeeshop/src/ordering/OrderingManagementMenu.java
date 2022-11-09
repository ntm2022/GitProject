package ordering;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import static general.Setting.DATE_FORMAT;
public class OrderingManagementMenu{
    int choice, id, sku;
    String name = null;
    Date date = null;
    double price, quantity, tax;
    boolean isAvailable;
    Date createdAt, updatedAt;

    OrderingManagement orderingManagement = OrderingManagement.getOrderingManagement(); //triển khai Singleton nên k được NEW
    Scanner scanner = new Scanner(System.in);
    DateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    public void displayMenu(){
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println("+   Chương trình quản lý THỰC ĐƠN   +");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
    }

    public void menu(){
        do {
            displayMenu();
            System.out.println("1.THÊM 2.XÓA 3.UPDATE 4.Search By ID " +
                    "\n5.Search By Name 6.Search By Created Date 7.Sap xep TANG DAN" +
                    "\n8.Sap xep GIAM DAN 9.Not Available 10.VIEW ALL 0.EXIT");
            choice = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (choice) {
                case 1:
                    add(false);
                    break;
                case 2:
                    System.out.println("Nhập ID để XÓA:");
                    id = Integer.parseInt(scanner.nextLine());
                    if(orderingManagement.remove(id)) {
                        System.out.println("Removed id = " + id);
                    }else{
                        System.out.println("K tim thay id = " + id);
                    }
                    break;
                case 3:
                    add(true);
                    break;
                case 4:
                    System.out.println("Nhập ID để SEARCH:");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println(orderingManagement.searchByID(id));
                    break;
                case 5:
                    System.out.println("Nhập tên thức uống để SEARCH:");
                    name = scanner.nextLine();
                    System.out.println(orderingManagement.searchByName(name));
                    break;
                case 6:
                    try {
                        System.out.println("Nhập createdAt để SEARCH:");
                        date = simpleDateFormat.parse(scanner.nextLine());//date phải thuộc gói java.util
                        System.out.println(orderingManagement.searchByDate(date));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println(orderingManagement.sortByPrice(true));
                    break;
                case 8:
                    System.out.println(orderingManagement.sortByPrice(false));
                    break;
                case 9:
                    System.out.println(orderingManagement.sortByAvailable(true));
                    break;
                case 10:
                    System.out.println(orderingManagement);
                    break;
            }
        }while (choice!=0);
    }
    public void add(boolean isUpdate){
        ////(int orderID, String name, double price, double tax, boolean isAvailable, Date createdAt, Date updatedAt)
        System.out.println("Nhập orderID để THÊM/CẬP NHẬT");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên thức uống:");
        name = scanner.nextLine();
        System.out.println("Nhập GIÁ:");
        price = Double.parseDouble(scanner.nextLine());
        tax = 0.1 * price;
        System.out.println("Nhập số lượng:");
        quantity = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập SKU liên quan:");
        sku = Integer.parseInt(scanner.nextLine());
        System.out.println("Mon nay san co k? true=1");
        isAvailable = scanner.nextLine().equals("1"); //cái này phải viết hàm riêng để CHECK
        if(!isUpdate) {
            createdAt = new Date();
            updatedAt = new Date();
            orderingManagement.add(new Ordering(id, name, price, quantity, tax, sku, isAvailable, createdAt, updatedAt));
        }else{
            updatedAt = new Date();
            orderingManagement.update(id,new Ordering(id, name, price, quantity, tax, sku, isAvailable, createdAt, updatedAt));
        }


    }
}
