import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookDAO bookDAO = new BookDAO();
        IssueDAO issueDAO = new IssueDAO();

        while (true) {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Title: ");
                    String t = sc.nextLine();

                    System.out.print("Author: ");
                    String a = sc.nextLine();

                    System.out.print("Quantity: ");
                    int q = sc.nextInt();

                    bookDAO.addBook(new Book(t, a, q));
                    break;

                case 2:
                    bookDAO.viewBooks();
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter title: ");
                    String s = sc.nextLine();
                    bookDAO.searchBook(s);
                    break;

                case 4:

                    sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();

                    issueDAO.issueBook(name, email, bookId);
                    break;

                case 5:
                    sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String returnName = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    issueDAO.returnBook(returnName, returnBookId);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}