public class LibraryCatalogTester 
{
    public static void main(String[] args) 
    {
        LibraryCatalog catalog = new LibraryCatalog();
        catalog.addBook(new Book("Freshman Adventures", 67));
        catalog.addBook(new Book("Freshman Adventures", 67));
        catalog.addBook(new Book("Weird Garbear", 49));          
        catalog.display();
        System.out.println();
        System.out.print(catalog.hasBook(new Book("Freshman Adventures" , 67)));
    }
}
