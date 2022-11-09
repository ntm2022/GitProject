package receipt;

import ordering.OrderingManagement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static general.Setting.DATE_FORMAT;
public class ReceiptManagementMenu{
    int choice, id, staffID;
    String name;
    Date createdAt, updatedAt;
    Map<Integer, Integer> orders = new HashMap<Integer,Integer>();

    ReceiptManagement receiptManagement = ReceiptManagement.getReceiptManagement();

    //tạo OrderingManagement để gọi THỨC UỐNG + tính TOTAL
    OrderingManagement orderingManagement = OrderingManagement.getOrderingManagement();
    Scanner scanner = new Scanner(System.in);
    DateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    public void displayMenu(){
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("+  Chương trình quản lý HÓA ĐƠN  +");
        System.out.println("++++++++++++++++++++++++++++++++++");
    }
    public void menu(){
        do {
            displayMenu();
            System.out.println("1.THÊM 2.XÓA 3.Search By ID 4.Search By StaffID " +
                    "\n 5.Search By Created Date 6.UPDATE 7.VIEW ALL 8.Top Orderings 0.EXIT");
            choice = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (choice) {
                case 1:
                    add(false);
                    break;
                case 2:
                    System.out.println("Nhập ReceiptNO để XÓA");
                    id = Integer.parseInt(scanner.nextLine());
                    if(receiptManagement.remove(id)){
                        System.out.println("Removed id: " + id);
                    }else{
                        System.out.println("K tim thay id = " + id);
                    }
                    break;
                case 3:
                    System.out.println("Nhập ReceiptNO để TÌM KIẾM");
                    id = Integer.parseInt(scanner.nextLine());
                    if(receiptManagement.searchByID(id)==null){
                        System.out.println("Không tìm thấy" + " id: " + id);
                    }else{
                        System.out.println(receiptManagement.searchByID(id));
                    }
                    break;
                case 4:
                    System.out.println("Nhập StaffID để TÌM KIẾM");
                    id = Integer.parseInt(scanner.nextLine());
                    if(receiptManagement.searchByStaffID(id)==null){
                        System.out.println("Không tìm thấy" + " id: " + id);
                    }else{
                        System.out.println(receiptManagement.searchByStaffID(id));
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Nhập CreatedDate để TÌM KIẾM dd-MM-yyyy H:m:s");
                        createdAt = simpleDateFormat.parse(scanner.nextLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(receiptManagement.searchByDate(createdAt)==null){
                        System.out.println("Không tìm thấy" + " hóa đơn ngày : " + createdAt);
                    }else{
                        System.out.println(receiptManagement.searchByDate(createdAt));
                    }
                    break;
                case 6:
                    add(true);
                    break;
                case 7:
                    System.out.println(receiptManagement);
                    break;
            }
        }while(choice!=0);
    }
    public void update(){
        //giống add()
    }

    //(int receiptNO, int staffID, Date createdAt, Date updatedAt, Map<Integer, Integer> orders, double total, double cash, double change)
    public void add(boolean isUpdate){
        double total = 0;
        double cash = 0;
        double change = 0;

        System.out.println("Nhập ReceiptNO muốn CẬP NHẬT/THÊM MỚI");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập StaffID:");
        staffID = Integer.parseInt(scanner.nextLine());

        //tính thành tiền total (đã trừ VAT)
        total = getTotal();

        //nhập cash = tiền khách đưa
        System.out.println("Nhập TIỀN MẶT khách đưa:");
        cash = Integer.parseInt(scanner.nextLine());
        change = cash - total;

        if(change>=0) {//nếu khách ĐƯA TIỀN MẶT K ĐỦ sẽ k tạo mới RECEIPT
            if(!isUpdate) {
                createdAt = new Date();
                updatedAt = new Date();
                System.out.println("Added id: "
                        + receiptManagement.add(new Receipt(id, staffID, createdAt, updatedAt, total, cash, change, orders)));
            }else{
                updatedAt = new Date();
                System.out.println("Updated id: "
                        + receiptManagement.update(id,new Receipt(id, staffID, createdAt, updatedAt, total, cash, change, orders)));
            }

        }else{
            System.out.println("Khách đưa THIẾU TIỀN!");
        }
    }
    public double getTotal(){
        int choice, orderID, quantity;
        double result = 0;
        double price = 0;
        double tax = 0;

        do{//gọi thức uống + tính TOTAL = price * quantity
            System.out.println("Nhập OrderID:");
            orderID = Integer.parseInt(scanner.nextLine());
            price = orderingManagement.searchByID(orderID).getPrice();
            tax = orderingManagement.searchByID(orderID).getTax();

            System.out.println("Nhập số lượng:");
            quantity = Integer.parseInt(scanner.nextLine());
            orders.put(orderID,quantity);

            if(price!=0 && quantity!=0)
                result += (price + tax) * quantity;

            System.out.println("0.EXIT / Nhập số bất kỳ để tiếp tục");
            choice = Integer.parseInt(scanner.nextLine());
        }while(choice!=0);
        return result;
    }
}
