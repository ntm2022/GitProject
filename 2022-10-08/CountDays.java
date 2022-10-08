import java.util.Scanner;

public class CountDays {
    public static void main(String[] args) {
        /*tháng 2 có thể có 28 hoặc 29 ngày,
        các tháng 1, 3, 5, 7, 8, 10, 12 có 31 ngày,
        các tháng còn lại có 30 ngày.*/
        int month;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap thang: ");
        month = scanner.nextInt();

        switch (month) {
            case 2 -> System.out.print("Thang 2 co 28 hoac 29 ngay" );
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.print("Thang " + month + " co 31 ngay");
            default -> System.out.print("Thang " + month + " co 30 ngay");
        }


    }
}
