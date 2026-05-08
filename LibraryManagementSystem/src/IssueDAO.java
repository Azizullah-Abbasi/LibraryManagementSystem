import java.sql.*;

public class IssueDAO {

    public void issueBook(String name, String email, int bookId) {

    try {
        Connection con = DBManager.getConnection();

        String userSql = "INSERT INTO users(name,email,role) VALUES (?,?,?)";
        PreparedStatement ps1 = con.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS);

        ps1.setString(1, name);
        ps1.setString(2, email);
        ps1.setString(3, "student");
        ps1.executeUpdate();

        ResultSet rs = ps1.getGeneratedKeys();
        int userId = 0;

        if (rs.next()) {
            userId = rs.getInt(1);
        }

        String check = "SELECT isIssued FROM books WHERE id=?";
        PreparedStatement ps2 = con.prepareStatement(check);
        ps2.setInt(1, bookId);

        ResultSet r2 = ps2.executeQuery();

        if (!r2.next()) {
            System.out.println("Book not found!");
            return;
        }

        if (r2.getBoolean("isIssued")) {
            System.out.println("Book already issued!");
            return;
        }

        String update = "UPDATE books SET isIssued=true WHERE id=?";
        PreparedStatement ps3 = con.prepareStatement(update);
        ps3.setInt(1, bookId);
        ps3.executeUpdate();

        String issue = "INSERT INTO issues(user_id, book_id) VALUES (?,?)";
        PreparedStatement ps4 = con.prepareStatement(issue);

        ps4.setInt(1, userId);
        ps4.setInt(2, bookId);
        ps4.executeUpdate();

        System.out.println("Book Issued Successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void returnBook(String name, int bookId) {
        try {
            Connection con = DBManager.getConnection();

            String userSql = "SELECT id FROM users WHERE name=?";
            PreparedStatement ps1 = con.prepareStatement(userSql);
            ps1.setString(1, name);

            ResultSet rs1 = ps1.executeQuery();

            if (!rs1.next()) {
                System.out.println("User not found!");
                return;
            }

            int userId = rs1.getInt("id");
            String check = "SELECT * FROM issues WHERE user_id=? AND book_id=? AND return_date IS NULL";
            PreparedStatement ps2 = con.prepareStatement(check);
            ps2.setInt(1, userId);
            ps2.setInt(2, bookId);

            ResultSet rs2 = ps2.executeQuery();

            if (!rs2.next()) {
                System.out.println("No active issue found!");
                return;
            }

            String updateIssue = "UPDATE issues SET return_date=NOW() WHERE user_id=? AND book_id=? AND return_date IS NULL";
            PreparedStatement ps3 = con.prepareStatement(updateIssue);
            ps3.setInt(1, userId);
            ps3.setInt(2, bookId);

            ps3.executeUpdate();

            String updateBook = "UPDATE books SET isIssued=false WHERE id=?";
            PreparedStatement ps4 = con.prepareStatement(updateBook);
            ps4.setInt(1, bookId);

            ps4.executeUpdate();

            System.out.println("Book Returned Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}