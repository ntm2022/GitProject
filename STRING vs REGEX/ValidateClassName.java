import java.util.Scanner;

public class ValidateClassName {
    public static void main(String[] args) {
        String regex = "^[CAP][\\d]{4}[GHIKLM]$"; //Them dau \ truoc dau \

        System.out.println("Nhap ten lop:");
        String className = new Scanner(System.in).nextLine();
        if(className.matches(regex))
            System.out.println("Matching!!");
    }
}
