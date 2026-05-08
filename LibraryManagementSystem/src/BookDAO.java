import java.sql.*;
import java.util.*;

public class BookDAO {

    public void addBook(Book b) {
        try {
            Connection con = DBManager.getConnection();

            String sql = "INSERT INTO books(title, author, quantity, isIssued) VALUES (?,?,?,false)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setInt(3, b.getQuantity());

            ps.executeUpdate();
            System.out.println("Book Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {
        try {
            Connection con = DBManager.getConnection();

            String sql = "SELECT * FROM books";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author") + " | " +
                    rs.getInt("quantity") + " | " +
                    rs.getBoolean("isIssued")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchBook(String title) {

        try {
            Connection con = DBManager.getConnection();

            String sql = "SELECT * FROM books WHERE title LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + title + "%");

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author")
                );
            }

            if (!found) {
                System.out.println("No book found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}