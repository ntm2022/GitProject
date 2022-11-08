package hinhhoc;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
    }
}
/*
OUTPUT:

A Circle with radius=1.0, which is a subclass of A Shape with color of green and filled
A Circle with radius=3.5, which is a subclass of A Shape with color of green and filled
A Circle with radius=3.5, which is a subclass of A Shape with color of indigo and not filled

Process finished with exit code 0
 */