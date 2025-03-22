public class Member {
    private String name;
    private Book borrowedBook; // Aggregation: Member "has-a" Book

    // Constructor
    public Member(String name) {
        this.name = name;
        this.borrowedBook = null;
    }

    public String getName() {
        return name;
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBook = book;
            book.borrow();
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is already borrowed.");
        }
    }

    // Method to return a book
    public void returnBook() {
        if (borrowedBook != null) {
            System.out.println(name + " returned: " + borrowedBook.getTitle());
            borrowedBook.returnBook();
            borrowedBook = null;
        } else {
            System.out.println(name + " has no book to return.");
        }
    }

    // Display borrowed book details
    public void displayBorrowedBook() {
        if (borrowedBook != null) {
            System.out.println("Member: " + name + ", Borrowed Book: " + borrowedBook.getTitle());
        } else {
            System.out.println("Member: " + name + " has not borrowed any book.");
        }
    }
}
