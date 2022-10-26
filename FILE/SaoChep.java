import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaoChep {
    public static void main(String[] args) throws Exception {
        List<Integer> data = new ArrayList<>();

        System.out.println("Nhập tên file muốn COPY:");
//        String fileSrc = new Scanner(System.in).nextLine();
        String fileSrc = "numbers.txt";

        System.out.println("Nhập tên file DESTINATION:");
//        String fileDes = new Scanner(System.in).nextLine();
        String fileDes = "result.txt";

        //đọc file source
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileSrc));
            String line = null;
            while((line = reader.readLine()) != null){
                data.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //ghi file destination
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileDes,true));
            System.out.println(data);
            for(int i: data){
                writer.write(String.valueOf(i));
                writer.newLine();//bỏ dòng trắng cuối file bằng cách chạy vòng lặp for i++ rồi xét i<data.size()
            }
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
