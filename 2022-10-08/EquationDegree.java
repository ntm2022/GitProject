import java.util.Scanner;
public class EquationDegree {
    public static void main(String[] args) {
        double a, b, c, x;
        //ax + b = c

        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        a = scanner.nextDouble();

        System.out.print("b = ");
        b = scanner.nextDouble();

        System.out.print("c = ");
        c = scanner.nextDouble();

        if(a!=0){
            x = (c-b)/a;
            System.out.printf("x = %f",x);2
        }else if(b==c){
            System.out.print("x bằng vô cực!");
        }else{
            System.out.print("Phương trình vô nghiệm!");
        }
    }
}
