public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square(5.0);

        System.out.println("Before resize: " + square.getSide());
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());

        square.resize(2.0);
        System.out.println("After resize: " + square.getSide());

    }
}
