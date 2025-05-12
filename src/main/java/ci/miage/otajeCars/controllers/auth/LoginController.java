package main.java.ci.miage.otajeCars.controllers.auth;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.ci.miage.otajeCars.dao.common.UtilisateurDAO;
import main.java.ci.miage.otajeCars.models.Utilisateur;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtMatricule;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    @FXML
    private void initialize() {
        // Initialisation du contrôleur
    }

    @FXML
    private void handleLogin() {
        String matricule = txtMatricule.getText().trim();
        String password = txtPassword.getText().trim();

        if (matricule.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Erreur de connexion",
                    "Veuillez saisir votre matricule et votre mot de passe.");
            return;
        }

        try {
            Utilisateur utilisateur = utilisateurDAO.authentifier(matricule, password);
            if (utilisateur != null) {
                // Stockage de l'utilisateur connecté pour la session
                SessionManager.getInstance().setUtilisateurConnecte(utilisateur);

                // Redirection vers la page d'accueil
                loadDashboard();
            } else {
                showAlert(Alert.AlertType.ERROR, "Erreur de connexion",
                        "Matricule ou mot de passe incorrect.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Erreur de connexion",
                    "Une erreur est survenue lors de la connexion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void loadDashboard() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/main/ressources/views/dashboard.fxml"));
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("OTAJE Cars - Tableau de bord");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
