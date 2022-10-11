import java.util.Scanner;
public class Bmi {
    public static void main(String[] args) {
        double height, weight, result;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chieu cao: ");
        height = scanner.nextFloat();
        System.out.print("Nhap can nang: ");
        weight = scanner.nextFloat();

        result = calculateBmi(height, weight);

        //Một người có cân nặng là 65Kg và chiều cao là 1.75m thì BMI là 65 / 1.752 = 22.22.
        // Chỉ số này nằm trong khoảng 18.5 đến 25.0 cho nên được phân loại là Normal (bình thường).
        if(result>=18.5 && result<=25){
            System.out.print("Normal");
        }else if(result > 25){
            System.out.print("Overweight!!!");
        }else{System.out.print("Underweight!!!");}
    }
    public static double calculateBmi(double height, double weight){
        return weight/Math.pow(height, 2);
    }
}
