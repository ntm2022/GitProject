package hinhhoc;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);
    }
}
/*
OUTPUT:

A Square with side=1.0, which is a subclass of A Rectangle with width=1.0 and length=1.0, which is a subclass of A Shape with color of green and filled
A Square with side=2.3, which is a subclass of A Rectangle with width=2.3 and length=2.3, which is a subclass of A Shape with color of green and filled
A Square with side=5.8, which is a subclass of A Rectangle with width=5.8 and length=5.8, which is a subclass of A Shape with color of yellow and filled

Process finished with exit code 0
 */