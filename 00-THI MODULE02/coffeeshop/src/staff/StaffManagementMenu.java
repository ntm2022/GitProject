package staff;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static general.Setting.DATE_FORMAT;

public class StaffManagementMenu {
    int choice, id;
    String cccd = null;
    String name = null;
    Date doB, startJobDate;
    Date createdAt, updatedAt;
    Scanner scanner = new Scanner(System.in);
    DateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    StaffManagement staffManagement = StaffManagement.getStaffManagement();

    public void displayMenu() {
        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("+Chương trình quản lý NHÂN VIÊN+");
        System.out.println("++++++++++++++++++++++++++++++++");
    }

    public void menu() {
        do {
            displayMenu();
            System.out.println("1.THÊM 2.XÓA 3.UPDATE 4.Search By ID " +
                    "\n 5.Search By Name 6.Search By CCCD 7.VIEW ALL 0.EXIT");
            choice = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (choice) {
                case 1:
                    add(false);
                    break;
                case 2:
                    System.out.println("Nhập ID để XÓA:");
                    id = Integer.parseInt(scanner.nextLine());
                    if (staffManagement.remove(id)) {
                        System.out.println("Removed id = " + id);
                    } else {
                        System.out.println("K tim thay id = " + id);
                    }
                    break;
                case 3:
                    add(true);
                    break;
                case 4:
                    System.out.println("Nhập ID để SEARCH:");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println(staffManagement.searchByID(id));
                    break;
                case 5:
                    System.out.println("Nhập TÊN NHÂN VIÊN để SEARCH:");
                    name = scanner.nextLine();
                    System.out.println(staffManagement.searchByName(name));
                    break;
                case 6:
                    System.out.println("Nhập CCCD để SEARCH:");
                    cccd = scanner.nextLine();
                    System.out.println(staffManagement.searchByCCCD(cccd));
                    break;
                case 7:
                    System.out.println(staffManagement);
                    break;
            }
        } while (choice != 0);
    }

    public void add(boolean isUpdate) {
        //(int staffID, String name, String cccd, Date doB, Date startJobDate, Date createdAt, Date updatedAt)
        System.out.println("Nhập staffID để THÊM/CẬP NHẬT");
        id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên nhân viên:");
        name = scanner.nextLine();
        System.out.println("Nhập CCCD:");
        cccd = scanner.nextLine();

        try {
            System.out.println("Nhập ngày tháng năm sinh dd-MM-yyyy H:m:s");
            doB = simpleDateFormat.parse(scanner.nextLine());//date phải thuộc gói java.util
            System.out.println("Nhập NGÀY VÀO LÀM dd-MM-yyyy H:m:s");
            startJobDate = simpleDateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!isUpdate) {
            createdAt = new Date();
            updatedAt = new Date();
            System.out.println("Added id: " + staffManagement.add(new Staff(id, name, cccd, doB, startJobDate, createdAt, updatedAt)));
        } else {
            updatedAt = new Date();
            System.out.println("Updated id: " + staffManagement.update(id, new Staff(id, name, cccd, doB, startJobDate, createdAt, updatedAt)));
        }

    }
}