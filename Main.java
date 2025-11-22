import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
// Teste ici ta connexion à la base de donnée
        Connection conn = TestConnexion.getConnexion();
        if (conn != null) {
            System.out.println("Connexion réussie !");
            // Ici tu peux faire d'autres traitements (requêtes, etc.)
        } else {
            System.out.println("La connexion a échoué.");
        }
        }
    }
