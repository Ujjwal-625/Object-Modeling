import java.util.ArrayList;

class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }
}

public class Library {
    private String name;
    private ArrayList<Book> books; // Aggregation: A library has many books

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display the books in the library
    public void displayBooks() {
        System.out.println("Books in " + name + " Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen");
        Book book3 = new Book("1984", "George Orwell");
        Book book4 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Create Library objects
        Library library1 = new Library("Downtown Library");
        Library library2 = new Library("Community Library");

        // Add books to libraries
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);
        library2.addBook(book4);
        library2.addBook(book1); // book1 can be in both libraries

        // Display library contents
        System.out.println(library1);
        System.out.println(library2);

        //Demonstrate that books exist independently
        ArrayList<Book> allBooks = new ArrayList<>();
        allBooks.add(book1);
        allBooks.add(book2);
        allBooks.add(book3);
        allBooks.add(book4);

        System.out.println("\nAll Books List:");
        for(Book book: allBooks){
            System.out.println(book);
        }
    }
}


