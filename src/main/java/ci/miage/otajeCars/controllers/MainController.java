package main.java.ci.miage.otajeCars.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

    public class MainController {

        @FXML
        private Label messageLabel;

        // Méthode appelée lors du clic sur le bouton
        @FXML
        public void handleButtonClick() {
            messageLabel.setText("Vous avez cliqué sur le bouton!");
        }
    }
