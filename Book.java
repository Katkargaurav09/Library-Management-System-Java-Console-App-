public class Book
{
    private String title;
    private String author;
    private String isbn;
    private double price;
    private boolean isBorrowed; // Track book availability

    // Constructor
    public Book(String title, String author, String isbn, double price) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.price = price;
    this.isBorrowed = false; // Initially available
    }

    // Getter methods
    public String getDetails()
    {
    return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Price: $" + price;
    }

    public String getTitle()
    {
    return title;
    }

    // Borrow and return methods
    public boolean isAvailable()
    {
    return !isBorrowed;
    }

    public void borrow() {
        if (isAvailable())
        {
            isBorrowed = true;
        } else {
            System.out.println("Book already borrowed: " + title);
        }
        }
        public void returnBook()
        {
        isBorrowed = false;
        }
}