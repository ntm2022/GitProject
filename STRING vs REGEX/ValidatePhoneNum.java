import java.util.Scanner;

public class ValidatePhoneNum {
    public static void main(String[] args) {
        String regex = "^[(][\\d]{2}[)]-[(]0[\\d]{9}[)]$"; //Them dau \ truoc dau \
//        String regex = "^[(][\\d]{2}[)]$"; //Them dau \ truoc dau \
        System.out.println("Nhap so phone theo dinh dang (xx)-(0xxxxxxxxx):");
        String phoneNum = new Scanner(System.in).nextLine();
        if(phoneNum.matches(regex))
            System.out.println("Matching!!");
    }
}
