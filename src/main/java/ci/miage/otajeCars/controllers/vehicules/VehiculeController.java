package main.java.ci.miage.otajeCars.controllers.vehicules;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.ci.miage.otajeCars.dao.common.VehiculeDAO;
import main.java.ci.miage.otajeCars.models.Vehicule;

import java.io.IOException;
import java.util.List;

public class VehiculeController {

    @FXML
    private TableView<Vehicule> tableVehicules;

    @FXML
    private TableColumn<Vehicule, String> colImmatriculation;

    @FXML
    private TableColumn<Vehicule, String> colMarque;

    @FXML
    private TableColumn<Vehicule, String> colModele;

    @FXML
    private TableColumn<Vehicule, Integer> colAnnee;

    @FXML
    private TableColumn<Vehicule, String> colStatut;

    @FXML
    private TableColumn<Vehicule, String> colType;

    @FXML
    private TextField txtRecherche;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnDetails;

    private VehiculeDAO vehiculeDAO = new VehiculeDAO();
    private ObservableList<Vehicule> vehicules = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Configuration des colonnes
        colImmatriculation.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        colMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        colModele.setCellValueFactory(new PropertyValueFactory<>("modele"));
        colAnnee.setCellValueFactory(new PropertyValueFactory<>("annee"));
        colStatut.setCellValueFactory(cellData -> cellData.getValue().getStatut().libelleStatutProperty());
        colType.setCellValueFactory(cellData -> cellData.getValue().getType().libelleTypeProperty());

        // Chargement des données
        chargerVehicules();

        // Boutons désactivés jusqu'à sélection d'un véhicule
        btnModifier.setDisable(true);
        btnSupprimer.setDisable(true);
        btnDetails.setDisable(true);

        // Écoute de la sélection d'un véhicule
        tableVehicules.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    boolean vehiculeSelectionne = newValue != null;
                    btnModifier.setDisable(!vehiculeSelectionne);
                    btnSupprimer.setDisable(!vehiculeSelectionne);
                    btnDetails.setDisable(!vehiculeSelectionne);
                }
        );

        // Recherche
        txtRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrerVehicules(newValue);
        });
    }

    private void chargerVehicules() {
        try {
            List<Vehicule> listeVehicules = vehiculeDAO.findAll();
            vehicules.setAll(listeVehicules);
            tableVehicules.setItems(vehicules);
        } catch (Exception e) {
            afficherAlerte(Alert.AlertType.ERROR, "Erreur",
                    "Erreur lors du chargement des véhicules", e.getMessage());
            e.printStackTrace();
        }
    }

    private void filtrerVehicules(String filtre) {
        if (filtre == null || filtre.isEmpty()) {
            tableVehicules.setItems(vehicules);
        } else {
            ObservableList<Vehicule> vehiculesFiltres = FXCollections.observableArrayList();
            String filtreLower = filtre.toLowerCase();

            for (Vehicule vehicule : vehicules) {
                if (vehicule.getImmatriculation().toLowerCase().contains(filtreLower) ||
                        vehicule.getMarque().toLowerCase().contains(filtreLower) ||
                        vehicule.getModele().toLowerCase().contains(filtreLower)) {
                    vehiculesFiltres.add(vehicule);
                }
            }

            tableVehicules.setItems(vehiculesFiltres);
        }
    }

    @FXML
    private void handleAjouter() {
        ouvrirFormulaireVehicule(null);
    }

    @FXML
    private void handleModifier() {
        Vehicule vehiculeSelectionne = tableVehicules.getSelectionModel().getSelectedItem();
        if (vehiculeSelectionne != null) {
            ouvrirFormulaireVehicule(vehiculeSelectionne);
        }
    }

    @FXML
    private void handleSupprimer() {
        Vehicule vehiculeSelectionne = tableVehicules.getSelectionModel().getSelectedItem();
        if (vehiculeSelectionne != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce véhicule ?");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        vehiculeDAO.delete(vehiculeSelectionne.getIdVehicule());
                        chargerVehicules();
                    } catch (Exception e) {
                        afficherAlerte(Alert.AlertType.ERROR, "Erreur de suppression",
                                "Impossible de supprimer ce véhicule", e.getMessage());
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @FXML
    private void handleDetails() {
        Vehicule vehiculeSelectionne = tableVehicules.getSelectionModel().getSelectedItem();
        if (vehiculeSelectionne != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/ressources/views/vehicules/details.fxml"));
                Parent root = loader.load();

                VehiculeDetailsController controller = loader.getController();
                controller.setVehicule(vehiculeSelectionne);

                Stage stage = new Stage();
                stage.setTitle("Détails du véhicule");
                stage.setScene(new Scene(root));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void ouvrirFormulaireVehicule(Vehicule vehicule) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/ressources/views/vehicules/formulaire.fxml"));
            Parent root = loader.load();

            VehiculeFormulaireController controller = loader.getController();
            controller.setVehicule(vehicule);
            controller.setVehiculeController(this);

            Stage stage = new Stage();
            stage.setTitle(vehicule == null ? "Ajouter un véhicule" : "Modifier un véhicule");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            // Rechargement des véhicules après la fermeture du formulaire
            chargerVehicules();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void afficherAlerte(Alert.AlertType type, String titre, String entete, String contenu) {
        Alert alert = new Alert(type);
        alert.setTitle(titre);
        alert.setHeaderText(entete);
        alert.setContentText(contenu);
        alert.showAndWait();
    }
}