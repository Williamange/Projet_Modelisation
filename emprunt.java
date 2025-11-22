import java.time.LocalDate;

public class Emprunter {
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    // Constructeur : par défaut, emprunt aujourd'hui et retour dans 3 semaines
    public Emprunter() {
        this.dateEmprunt = LocalDate.now();
        this.dateRetour = dateEmprunt.plusWeeks(3);
    }

    // Getters
    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }
    public String genererRecu(String numeroCompte, String rfidExemplaire) {
        return "------ Reçu d'emprunt ------\n"
                + "Usager : " + numeroCompte + "\n"
                + "Exemplaire RFID : " + rfidExemplaire + "\n"
                + "Date emprunt : " + dateEmprunt + "\n"
                + "Date retour prévue : " + dateRetour + "\n"
                + "---------------------------";
    }}
