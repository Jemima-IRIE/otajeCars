package main.java.ci.miage.otajeCars;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Charger le fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/ressources/views/main.fxml"));
            StackPane root = loader.load();

            // Créer la scène
            Scene scene = new Scene(root, 300, 200);

            // Définir la scène et afficher la fenêtre
            primaryStage.setTitle("Test JavaFX");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
