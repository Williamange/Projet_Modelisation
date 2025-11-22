import java.util.Date;

public class Exemplaire {
    private int RFID;
    private String auteur;
    private String edition;
    private Date dateParution;
    private int nombrePages;

    // Constructeur
    public Exemplaire(int RFID, String auteur, String edition, Date dateParution, int nombrePages) {
        this.RFID = RFID;
        this.auteur = auteur;
        this.edition = edition;
        this.dateParution = dateParution;
        this.nombrePages = nombrePages;
    }

    // Getters
    public int getRFID() {
        return RFID;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getEdition() {
        return edition;
    }

    public Date getDateParution() {
        return dateParution;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    // Setters
    public void setRFID(int RFID) {
        this.RFID = RFID;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    // Affichage texte
    @Override
    public String toString() {
        return "Exemplaire[RFID=" + RFID +
                ", Auteur=" + auteur +
                ", Edition=" + edition +
                ", DateParution=" + dateParution +
                ", NombrePages=" + nombrePages + "]";
    }
}
