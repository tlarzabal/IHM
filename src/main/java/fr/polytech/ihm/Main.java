package fr.polytech.ihm;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/base.fxml"));
            BorderPane pane=(BorderPane) root;
            pane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneAccueil.fxml")));
            primaryStage.setTitle("IHM");
            primaryStage.setScene(new Scene(root,1500,1500));
            primaryStage.show();
        }

}
