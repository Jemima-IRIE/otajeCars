package main.java.ci.miage.otajeCars.controllers.vehicules;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.java.ci.miage.otajeCars.dao.common.StatutVehiculeDAO;
import main.java.ci.miage.otajeCars.dao.common.TypeVehiculeDAO;
import main.java.ci.miage.otajeCars.dao.common.VehiculeDAO;
import main.java.ci.miage.otajeCars.models.StatutVehicule;
import main.java.ci.miage.otajeCars.models.TypeVehicule;
import main.java.ci.miage.otajeCars.models.Vehicule;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class VehiculeFormulaireController {

    @FXML
    private TextField txtImmatriculation;

    @FXML
    private TextField txtMarque;

    @FXML
    private TextField txtModele;

    @FXML
    private Spinner<Integer> spinnerAnnee;

    @FXML
    private ComboBox<TypeVehicule> comboType;

    @FXML
    private ComboBox<StatutVehicule> comboStatut;

    @FXML
    private DatePicker dateMiseEnService;

    @FXML
    private TextField txtKilometrageInitial;

    @FXML
    private Button btnCarteGrise;

    @FXML
    private Button btnAssurance;

    @FXML
    private Label lblCarteGrise;

    @FXML
    private Label lblAssurance;

    @FXML
    private Button btnSauvegarder;

    @FXML
    private Button btnAnnuler;

    private VehiculeDAO vehiculeDAO = new VehiculeDAO();
    private TypeVehiculeDAO typeVehiculeDAO = new TypeVehiculeDAO();
    private StatutVehiculeDAO statutVehiculeDAO = new StatutVehiculeDAO();

    private Vehicule vehicule;
    private VehiculeController vehiculeController;

    private String urlCarteGrise;
    private String urlAssurance;

    @FXML
    private void initialize() {
        // Configuration du spinner pour l'année
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1990, LocalDate.now().getYear(), LocalDate.now().getYear());
        spinnerAnnee.setValueFactory(valueFactory);

        // Chargement des types de véhicules
        try {
            List<TypeVehicule> types = typeVehiculeDAO.findAll();
            comboType.setItems(FXCollections.observableArrayList(types));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Chargement des statuts de véhicules
        try {
            List<StatutVehicule> statuts = statutVehiculeDAO.findAll();
            comboStatut.setItems(FXCollections.observableArrayList(statuts));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;

        if (vehicule != null) {
            // Mode modification
            txtImmatriculation.setText(vehicule.getImmatriculation());
            txtMarque.setText(vehicule.getMarque());
            txtModele.setText(vehicule.getModele());
            spinnerAnnee.getValueFactory().setValue(vehicule.getAnnee());
            comboType.setValue(vehicule.getType());
            comboStatut.setValue(vehicule.getStatut());
            dateMiseEnService.setValue(vehicule.getDateMiseEnService());
            txtKilometrageInitial.setText(String.valueOf(vehicule.getKilometrageInitial()));

            urlCarteGrise = vehicule.getUrlCarteGrise();
            urlAssurance = vehicule.getUrlAssurance();

            lblCarteGrise.setText(urlCarteGrise != null ? "Fichier sélectionné" : "Aucun fichier");
            lblAssurance.setText(urlAssurance != null ? "Fichier sélectionné" : "Aucun fichier");
        }
    }

    public void setVehiculeController(VehiculeController vehiculeController) {
        this.vehiculeController = vehiculeController;
    }

    @FXML
    private void handleSelectCarteGrise() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner la carte grise");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Documents", "*.pdf", "*.jpg", "*.jpeg", "*.png")
        );

        File file = fileChooser.showOpenDialog(btnCarteGrise.getScene().getWindow());
        if (file != null) {
            urlCarteGrise = file.getAbsolutePath();
            lblCarteGrise.setText("Fichier sélectionné");
        }
    }

    @FXML
    private void handleSelectAssurance() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner l'assurance");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Documents", "*.pdf", "*.jpg", "*.jpeg", "*.png")
        );

        File file = fileChooser.showOpenDialog(btnAssurance.getScene().getWindow());
        if (file != null) {
            urlAssurance = file.getAbsolutePath();
            lblAssurance.setText("Fichier sélectionné");
        }
    }

    @FXML
    private void handleSauvegarder() {
        if (!validerFormulaire()) {
            return;
        }

        try {
            if (vehicule == null) {
                // Mode ajout
                vehicule = new Vehicule();
            }

            // Mise à jour des données du véhicule
            vehicule.setImmatriculation(txtImmatriculation.getText());
            vehicule.setMarque(txtMarque.getText());
            vehicule.setModele(txtModele.getText());
            vehicule.setAnnee(spinnerAnnee.getValue());
            vehicule.setType(comboType.getValue());
            vehicule.setStatut(comboStatut.getValue());
            vehicule.setDateMiseEnService(dateMiseEnService.getValue());
            vehicule.setKilometrageInitial(Integer.parseInt(txtKilometrageInitial.getText()));
            vehicule.setUrlCarteGrise(urlCarteGrise);
            vehicule.setUrlAssurance(urlAssurance);

            if (vehicule.getIdVehicule() == 0) {
                // Ajout
                vehiculeDAO.save(vehicule);
            } else {
                // Modification
                vehiculeDAO.update(vehicule);
            }

            // Fermeture de la fenêtre
            ((Stage) btnSauvegarder.getScene().getWindow()).close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur lors de l'enregistrement");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAnnuler() {
        ((Stage) btnAnnuler.getScene().getWindow()).close();
    }

    private boolean validerFormulaire() {
        StringBuilder erreurs = new StringBuilder();

        if (txtImmatriculation.getText().trim().isEmpty()) {
            erreurs.append("L'immatriculation est obligatoire.\n");
        }

        if (txtMarque.getText().trim().isEmpty()) {
            erreurs.append("La marque est obligatoire.\n");
        }

        if (txtModele.getText().trim().isEmpty()) {
            erreurs.append("Le modèle est obligatoire.\n");
        }

        if (comboStatut.getValue() == null) {
            erreurs.append("Le statut est obligatoire.\n");
        }

        try {
            if (!txtKilometrageInitial.getText().trim().isEmpty()) {
                Integer.parseInt(txtKilometrageInitial.getText());
            }
        } catch (NumberFormatException e) {
            erreurs.append("Le kilométrage initial doit être un nombre.\n");
        }

        if (erreurs.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreurs de validation");
            alert.setHeaderText("Veuillez corriger les erreurs suivantes :");
            alert.setContentText(erreurs.toString());
            alert.showAndWait();
            return false;
        }

        return true;
    }
}