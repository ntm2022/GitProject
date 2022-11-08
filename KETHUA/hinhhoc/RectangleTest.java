package hinhhoc;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);
    }
}
/*
OUTPUT:

A Rectangle with width=1.0 and length=1.0, which is a subclass of A Shape with color of green and filled
A Rectangle with width=2.3 and length=5.8, which is a subclass of A Shape with color of green and filled
A Rectangle with width=2.5 and length=3.8, which is a subclass of A Shape with color of orange and filled

Process finished with exit code 0
 */