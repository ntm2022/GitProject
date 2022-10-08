import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        int year;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap nam: ");
        year = scanner.nextInt();
        String result = isLeapYear(year) ? " la nam nhuan" : " k la nam nhuan";
        System.out.print(year + result);

    }

    public static boolean isLeapYear(int year) {
        boolean condition1, condition2, condition3;
        /*        Những năm chia hết cho 4 mà không chia hết cho 100 là năm nhuận

        Những năm chia hết cho 100 mà không chia hết cho 400 thì KHÔNG PHẢI là năm nhuận

        Những năm chia hết đồng thời cho 100 và 400 là năm nhuận*/
        condition1 = (year % 4) == 0 && (year % 100) != 0;
        condition2 = (year % 100) == 0 && (year % 400) != 0;
        condition3 = (year % 100) == 0 && (year % 400) == 0;
        if (condition1) {
            return true;
        }
        if (condition2) {
            return false;
        }
        if (condition3) {
            return true;
        }
        return false;
    }
}

