import java.util.Scanner;
public class PrimeLessThan100 {
    public static void main(String[] args) {
        int numbers;//numbers này sẽ in ra bao nhiêu số nguyên tố
        int count = 0;
        int N = 2;//dãy số nguyên tố tính từ 2

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập upper limit cần in ra: ");
        numbers = scanner.nextInt();

        while (N < numbers){
            //kiểm tra nếu là số nguyên tố thì in ra
            if (isPrime(N)) {
                System.out.println(N);
            }
            N++;
        }
    }

    private static boolean isPrime(int count){ //thêm static ở đây để dùng thẳng hàm này mà k cần tạo đối tượng
        for(int i=2;i<count;i++){
            if(count % i==0) return false;
        }
        return true;
    }
}
