package chanle;

public class TestThread {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();//ngay luc nay da co tac dong thu tu thread???

        oddThread.start();//chuyen dong nay xuong duoi la TIEU???

        EvenThread evenThread = new EvenThread();//ngay luc nay da co tac dong thu tu thread???

        evenThread.start();

        //khong dung sleep de ngat quang thread nua ma thu dung join(milisecond)
    }
}
/*
OUTPUT:
1
2
3
4
5
6
7
9
8
10

Process finished with exit code 0
 */