import java.util.Date;

public class Issue {

    private int id;
    private int userId;
    private int bookId;
    private Date issueDate;
    private Date returnDate;

    public Issue(int userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
        this.issueDate = new Date();
    }

    public int getUserId() { return userId; }
    public int getBookId() { return bookId; }
}