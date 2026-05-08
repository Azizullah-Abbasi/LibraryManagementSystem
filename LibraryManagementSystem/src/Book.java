public class Book {

    private int id;
    private String title;
    private String author;
    private int quantity;
    private boolean issued;

    public Book() {}

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.issued = false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public int getQuantity() { return quantity; }
    public boolean isIssued() { return issued; }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }
}