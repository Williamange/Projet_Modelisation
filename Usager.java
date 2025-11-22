public class Usager {
    private String numeroCompte;
    private String nip;

    // Constructeur
    public Usager(String numeroCompte, String nip) {
        this.numeroCompte = numeroCompte;
        this.nip = nip;
    }

    // Getters
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public String getNip() {
        return nip;
    }

    // Setters
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    // Méthode d'identification (simulateur: à remplacer avec une vraie base)
    public boolean sidentifier() {
        // Exemple de vérification; à adapter selon ton vrai système
        return numeroCompte.equals("12345") && nip.equals("6789");
    }

    // Affichage/debug
    @Override
    public String toString() {
        return "Usager[numeroCompte=" + numeroCompte + ", nip=" + nip + "]";
    }
}
