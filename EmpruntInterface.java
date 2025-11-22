import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


public class EmpruntInterface extends JFrame {
    private JTextField numeroCompteField;
    private JPasswordField nipField;
    private JTextField RFIDExemplaireField;
    private JTextArea resultatArea;
    private JButton validerButton;
    private JButton imprimerButton;
    private JCheckBox recuCheckBox;
    private String recuStr = ""; // Contenu du reçu à imprimer

    public EmpruntInterface() {
        setTitle("Gestion Emprunt d'Exemplaire");
        setSize(440, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Numéro de compte :"));
        numeroCompteField = new JTextField();
        inputPanel.add(numeroCompteField);

        inputPanel.add(new JLabel("NIP :"));
        nipField = new JPasswordField();
        inputPanel.add(nipField);

        inputPanel.add(new JLabel("RFID de l'exemplaire :"));
        RFIDExemplaireField = new JTextField();
        inputPanel.add(RFIDExemplaireField);

        recuCheckBox = new JCheckBox("Voulez-vous un reçu ?");
        inputPanel.add(recuCheckBox);

        validerButton = new JButton("Valider Emprunt");
        inputPanel.add(validerButton);

        resultatArea = new JTextArea();
        resultatArea.setEditable(false);
        resultatArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        imprimerButton = new JButton("Imprimer le reçu");
        imprimerButton.setEnabled(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultatArea), BorderLayout.CENTER);
        add(imprimerButton, BorderLayout.SOUTH);

        validerButton.addActionListener(e -> gererEmprunt());
        imprimerButton.addActionListener(e -> imprimerRecu());

    }
    private void gererEmprunt() {
        String compte = numeroCompteField.getText();
        String nip = new String(nipField.getPassword());
        String rfid = RFIDExemplaireField.getText();

        resultatArea.setText("");  // Réinitialiser
        imprimerButton.setEnabled(false);
        recuStr = ""; // Réinitialiser

        if (compte.isEmpty() || nip.isEmpty() || rfid.isEmpty()) {
            resultatArea.setText("Veuillez remplir tous les champs.\n");
            return;
        }
        resultatArea.setText("Emprunt validé !\nUsager : " + compte + "\nExemplaire RFID : " + rfid);

        if (recuCheckBox.isSelected()) {
            LocalDate dateEmprunt = LocalDate.now();
            LocalDate dateRetour = dateEmprunt.plusWeeks(3);
            recuStr = "------ Reçu d'emprunt ------\n"
                    + "Usager : " + compte + "\n"
                    + "Exemplaire RFID : " + rfid + "\n"
                    + "Date emprunt : " + dateEmprunt + "\n"
                    + "Date retour prévue : " + dateRetour + "\n"
                    + "---------------------------";
            imprimerButton.setEnabled(true);
        }


    }
    private void imprimerRecu() {
        if (recuStr.isEmpty()) return;

        resultatArea.append("\n" + recuStr);

        // Génère un fichier texte reçu.txt dans le projet
        try (PrintWriter out = new PrintWriter(new FileWriter("recu.txt"))) {
            out.print(recuStr);
            JOptionPane.showMessageDialog(this, "Reçu enregistré dans 'recu.txt'");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'impression du reçu : " + ex.getMessage());
        }

        imprimerButton.setEnabled(false);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmpruntInterface().setVisible(true));
    }
}