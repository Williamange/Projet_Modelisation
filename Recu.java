import java.time.LocalDate;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Recu {
    private LocalDate dateImpression;
    private String contenu;

    public Recu(String contenu) {
        this.dateImpression = LocalDate.now();
        this.contenu = contenu;
    }

    public Recu() {

    }

    // Retourne le texte à afficher
    public String afficher() {
        return "Date impression : " + dateImpression + "\n" + contenu;
    }

    // Enregistre le reçu dans un fichier
    public void imprimerDansFichier(String nomFichier) {
        try (PrintWriter out = new PrintWriter(new FileWriter(nomFichier))) {
            out.println("Date impression : " + dateImpression);
            out.println(contenu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
