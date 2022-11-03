public class Test {
    public static void main(String[] args) {
        System.out.println("BEGIN TESTING SINGLETON PATTERN");

        BookBorrower bookBorrower1 = new BookBorrower();
        BookBorrower bookBorrower2 = new BookBorrower();

        bookBorrower1.borrowBook();
        System.out.println("BookBorrower1 asked to borrow the book");
        System.out.println("BookBorrower1 Author and Title: ");
        System.out.println(bookBorrower1.getAuthorAndTitle());


        bookBorrower2.borrowBook();
        System.out.println("BookBorrower2 asked to borrow the book");
        System.out.println("BookBorrower2 Author and Title: ");
        System.out.println(bookBorrower2.getAuthorAndTitle());

        bookBorrower1.returnBook();
        System.out.println("BookBorrower1 returned the book");

        bookBorrower2.borrowBook();
        System.out.println("BookBorrower2 Author and Title: ");
        System.out.println(bookBorrower1.getAuthorAndTitle());

        System.out.println("END TESTING SINGLETON PATTERN");
    }
}
/*
OUTPUT:

BEGIN TESTING SINGLETON PATTERN
BookBorrower1 asked to borrow the book
BookBorrower1 Author and Title:
Design Patterns by Gamma, Helm, Johnson, and Vlissides
BookBorrower2 asked to borrow the book
BookBorrower2 Author and Title:
I don't have the book
BookBorrower1 returned the book
BookBorrower2 Author and Title:
Design Patterns by Gamma, Helm, Johnson, and Vlissides
END TESTING SINGLETON PATTERN

Process finished with exit code 0

 */