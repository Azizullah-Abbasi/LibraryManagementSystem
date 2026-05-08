import java.sql.*;

public class DBManager {

    private static Connection con;

    private static String url = "jdbc:mysql://localhost:3306/library_db";
    private static String user = "root";
    private static String pass = "Arshad123";

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
                System.out.println("Connected to DB");
            }
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
        return con;
    }
}