import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library(10); // Max 10 books
        Member[] members = new Member[10];
        int memberCount = 0;

        System.out.println("=== Welcome to the Library Management System ===");

        char choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book to Library");
            System.out.println("2. Display All Books");
            System.out.println("3. Add Member");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1:
                    // Add Book
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // consume newline

                    Book newBook = new Book(title, author, isbn, price);
                    library.addBook(newBook);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    // Add Member
                    if (memberCount < members.length) {
                        System.out.print("Enter Member Name: ");
                        String memberName = sc.nextLine();
                        members[memberCount++] = new Member(memberName);
                        System.out.println("Member added successfully.");
                    } else {
                        System.out.println("Max members reached.");
                    }
                    break;

                case 4:
                    // Borrow Book
                    if (memberCount == 0) {
                        System.out.println("No members registered yet.");
                        break;
                    }
                    System.out.print("Enter Member Name: ");
                    String borrowerName = sc.nextLine();
                    Member borrower = findMemberByName(members, memberCount, borrowerName);
                    if (borrower != null) {
                        System.out.print("Enter Book Title to Borrow: ");
                        String bookTitle = sc.nextLine();
                        Book bookToBorrow = library.findBookByTitle(bookTitle);
                        if (bookToBorrow != null) {
                            borrower.borrowBook(bookToBorrow);
                        } else {
                            System.out.println("Book not found.");
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 5:
                    // Return Book
                    System.out.print("Enter Member Name: ");
                    String returnerName = sc.nextLine();
                    Member returner = findMemberByName(members, memberCount, returnerName);
                    if (returner != null) {
                        returner.returnBook();
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 6:
                    library.displayAvailableBooks();
                    break;

                case 7:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.print("\nDo you want to continue? (Y/N): ");
            choice = sc.next().charAt(0);
            sc.nextLine();
        } while (choice == 'Y' || choice == 'y');

        sc.close();
    }

    // Helper method to find member
    private static Member findMemberByName(Member[] members, int count, String name) {
        for (int i = 0; i < count; i++) {
            if (members[i].getName().equalsIgnoreCase(name)) {
                return members[i];
            }
        }
        return null;
    }
}
