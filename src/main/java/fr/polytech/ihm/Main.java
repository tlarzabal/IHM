package fr.polytech.ihm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by dziri on 26/02/17.
 */
public class Main extends Application {

        public static void main(String[] args) { launch(args); }

        @Override
        public void start(Stage primaryStage) throws IOException
        {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/accueil.fxml"));
            primaryStage.setTitle("IHM");
            primaryStage.setScene(new Scene(root,1500,1500));
            primaryStage.show();
        }

}
