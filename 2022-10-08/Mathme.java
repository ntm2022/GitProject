import java.util.Scanner;
public class Mathme {
    public static void main(String[] args){
        float width,height,s;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập chiều rộng: ");
        width = scanner.nextFloat();

        System.out.println("Nhập chiều cao: ");
        height = scanner.nextFloat();

        s = areaRectangle(width, height);
        System.out.print("Diện tích hình chữ nhât" + s);
    }
    public static float areaRectangle(float width, float height){
        return width * height;
    }
}
