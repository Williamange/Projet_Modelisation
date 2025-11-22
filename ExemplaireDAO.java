import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExemplaireDAO {

    // Vérifie si l'exemplaire est disponible
    public static boolean verifierExemplaireExiste(String rfid) {
        String sql = "SELECT COUNT(*) FROM exemplaire WHERE rfid = ? AND disponible = 1";
        try (Connection con = TestConnexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rfid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // vrai si exemplaire disponible
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Marque l'exemplaire comme emprunté (non disponible)
    public static boolean marquerExemplaireEmprunte(String rfid) {
        String sql = "UPDATE exemplaire SET disponible = 0 WHERE rfid = ?";
        try (Connection con = TestConnexion.getConnexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rfid);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0; // vrai si update réussi
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
