package fr.polytech.ihm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dziri on 28/02/17.
 */
public class Controller {
    @FXML
    private ImageView bienvenue;
    private List<String> listeOfImage;
    private int cpt = 0;
    @FXML
    private ImageView toBeOrToHave;
    @FXML
    public void initialize(){
        listeOfImage = new ArrayList<>();
        listeOfImage.add("/images/promotion.png");
        listeOfImage.add("/images/bienvenue.jpg");
    }
    public void remplaceImage(){
        cpt++;
        if(cpt == listeOfImage.size())
            cpt = 0;
        bienvenue.setImage(new Image(listeOfImage.get(cpt)));
    }
    public void produit() throws IOException {
        Stage stage=(Stage) toBeOrToHave.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/produits.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void accueil() throws IOException {
        Stage stage=(Stage) toBeOrToHave.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/accueil.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void toBeOrToHave(){
        System.out.println("");
    }
}
