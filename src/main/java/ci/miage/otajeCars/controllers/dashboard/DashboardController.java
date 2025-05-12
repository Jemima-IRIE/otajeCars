package main.java.ci.miage.otajeCars.controllers.dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import main.java.ci.miage.otajeCars.models.Utilisateur;

import java.io.IOException;

public class DashboardController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private Label lblUserName;

    @FXML
    private VBox menuPane;

    @FXML
    private Button btnVehicules;

    @FXML
    private Button btnAffectations;

    @FXML
    private Button btnMissions;

    @FXML
    private Button btnEntretiens;

    @FXML
    private Button btnReparations;

    @FXML
    private Button btnUtilisateurs;

    @FXML
    private Button btnLogout;

    @FXML
    private void initialize() {
        // Charger les informations de l'utilisateur connecté
        Utilisateur utilisateur = SessionManager.getInstance().getUtilisateurConnecte();
        if (utilisateur != null) {
            lblUserName.setText(utilisateur.getNom() + " " + utilisateur.getPrenoms());
        }

        // Chargement par défaut de la vue des véhicules
        try {
            loadView("/main/ressources/views/vehicules/liste.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Selon le rôle de l'utilisateur, on peut masquer certains menus
        if (!"ADMIN".equals(utilisateur.getRole().getNomRole())) {
            btnUtilisateurs.setVisible(false);
        }
    }

    @FXML
    private void handleVehicules() throws IOException {
        loadView("/main/ressources/views/vehicules/liste.fxml");
    }

    @FXML
    private void handleAffectations() throws IOException {
        loadView("/main/ressources/views/affectations/liste.fxml");
    }

    @FXML
    private void handleMissions() throws IOException {
        loadView("/main/ressources/views/missions/liste.fxml");
    }

    @FXML
    private void handleEntretiens() throws IOException {
        loadView("/main/ressources/views/entretiens/liste.fxml");
    }

    @FXML
    private void handleReparations() throws IOException {
        loadView("/main/ressources/views/reparations/liste.fxml");
    }

    @FXML
    private void handleUtilisateurs() throws IOException {
        loadView("/main/ressources/views/utilisateurs/liste.fxml");
    }

    @FXML
    private void handleLogout() throws IOException {
        // Déconnexion
        SessionManager.getInstance().setUtilisateurConnecte(null);

        // Redirection vers la page de connexion
        Parent root = FXMLLoader.load(getClass().getResource("/main/ressources/views/login.fxml"));
        mainPane.getScene().setRoot(root);
    }

    private void loadView(String viewPath) throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource(viewPath));
        mainPane.setCenter(view);
    }
}