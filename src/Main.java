import entity.*;
import entity.LoanService;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Library library = new Library("Central Library");
    static LoanService loanService = new LoanService();

    static Author defaultAuthor = new Author(1L, "George Orwell");
    static Category defaultCategory = new Category(1L, "Dystopia");
    static Student defaultMember = new Student(
            2L,
            1L,
            "Atilla",
            "Izmir",
            "555",
            "S001",
            "Software"
    );

    static Long bookIdCounter = 1L;
    static Long authorIdCounter = 10L;
    static Long categoryIdCounter = 10L;

    public static void main(String[] args) {
        seedData();

        boolean running = true;

        while (running) {
            showMenu();

            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBookMenu();
                    break;
                case 2:
                    searchBookByIdMenu();
                    break;
                case 3:
                    searchBookByTitleMenu();
                    break;
                case 4:
                    searchBookByAuthorMenu();
                    break;
                case 5:
                    updateBookMenu();
                    break;
                case 6:
                    deleteBookMenu();
                    break;
                case 7:
                    listBooksByCategoryMenu();
                    break;
                case 8:
                    listBooksByAuthorMenu();
                    break;
                case 9:
                    borrowBookMenu();
                    break;
                case 10:
                    returnBookMenu();
                    break;
                case 11:
                    showAllBooks();
                    break;
                case 12:
                    showBills();
                    break;
                case 0:
                    running = false;
                    System.out.println("System closed.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1 - Add new book");
        System.out.println("2 - Search book by ID");
        System.out.println("3 - Search book by title");
        System.out.println("4 - Search book by author");
        System.out.println("5 - Update book");
        System.out.println("6 - Delete book");
        System.out.println("7 - List books by category");
        System.out.println("8 - List books by author");
        System.out.println("9 - Borrow book");
        System.out.println("10 - Return book");
        System.out.println("11 - Show all books");
        System.out.println("12 - Show bill history");
        System.out.println("0 - Exit");
    }

    public static void seedData() {
        Book book = new Book(
                bookIdCounter++,
                "1984",
                defaultAuthor,
                defaultCategory,
                100,
                1
        );

        library.addBook(book);
        library.addMember(defaultMember);
    }

    public static void addBookMenu() {
        System.out.print("Book title: ");
        String title = scanner.nextLine();

        System.out.print("Author name: ");
        String authorName = scanner.nextLine();

        System.out.print("Category name: ");
        String categoryName = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Edition: ");
        int edition = scanner.nextInt();
        scanner.nextLine();

        Author author = new Author(authorIdCounter++, authorName);
        Category category = new Category(categoryIdCounter++, categoryName);

        Book book = new Book(bookIdCounter++, title, author, category, price, edition);

        library.addBook(book);

        System.out.println("Book added successfully.");
    }

    public static void searchBookByIdMenu() {
        System.out.print("Book ID: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Book book = library.getBookRepository().findById(id);

        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void searchBookByTitleMenu() {
        System.out.print("Book title: ");
        String title = scanner.nextLine();

        List<Book> books = library.getBookRepository().findByTitle(title);

        printBooks(books);
    }

    public static void searchBookByAuthorMenu() {
        System.out.print("Author name: ");
        String authorName = scanner.nextLine();

        List<Book> books = library.getBookRepository().findAll();

        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                System.out.println(book);
            }
        }
    }

    public static void updateBookMenu() {
        System.out.print("Book ID to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Book book = library.getBookRepository().findById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("New title: ");
        String title = scanner.nextLine();

        System.out.print("New price: ");
        double price = scanner.nextDouble();

        System.out.print("New edition: ");
        int edition = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New category name: ");
        String categoryName = scanner.nextLine();

        Category category = new Category(categoryIdCounter++, categoryName);

        book.updateInfo(title, price, edition, category);

        System.out.println("Book updated successfully.");
    }

    public static void deleteBookMenu() {
        System.out.print("Book ID to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Book book = library.getBookRepository().findById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        library.removeBook(id);

        System.out.println("Book deleted successfully.");
    }

    public static void listBooksByCategoryMenu() {
        System.out.print("Category name: ");
        String categoryName = scanner.nextLine();

        boolean found = false;

        for (Book book : library.getBookRepository().findAll()) {
            if (book.getCategory().getCategoryName().equalsIgnoreCase(categoryName)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found in this category.");
        }
    }

    public static void listBooksByAuthorMenu() {
        System.out.print("Author name: ");
        String authorName = scanner.nextLine();

        boolean found = false;

        for (Book book : library.getBookRepository().findAll()) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found for this author.");
        }
    }

    public static void borrowBookMenu() {
        System.out.print("Book ID to borrow: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Book book = library.getBookRepository().findById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        loanService.borrowBook(defaultMember, book);
    }

    public static void returnBookMenu() {
        System.out.print("Book ID to return: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Book book = library.getBookRepository().findById(id);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        loanService.returnBook(defaultMember, book);
    }

    public static void showAllBooks() {
        printBooks(library.getBookRepository().findAll());
    }

    public static void showBills() {
        for (Bill bill : loanService.getBillHistory()) {
            System.out.println(bill);
        }
    }

    public static void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }
}