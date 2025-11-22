import java.sql.*;

public class TestConnexion {
    public static Connection getConnexion() {
        String url = "jdbc:mysql://localhost:3306/projet_modelisation"; // adapte nom de la base
        String user = "root";
        String password = ""; // adapte selon XAMPP

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            return null;
        }
    }
}
