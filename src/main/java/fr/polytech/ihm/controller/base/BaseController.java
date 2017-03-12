package fr.polytech.ihm.controller.base;

import fr.polytech.ihm.controller.EmailController;
import fr.polytech.ihm.model.produits.Produit;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by dziri on 28/02/17.
 */
public class BaseController extends EmailController {

    private static boolean isAdmin=false;
    @FXML
    private BorderPane borderIdentification;


    @FXML
    private Button buttonAdmin;




    @FXML
    private BorderPane generalBorderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label blueLabel;
    @FXML
    private Label whiteLabel;


    private Node Left;

    public void buttonAdmin() throws IOException{
        if(isAdmin){
            isAdmin=false;
            buttonAdmin.setText("Connection");
        }else{
            isAdmin=true;
            buttonAdmin.setText("Deconnection");
        }

    }

    @FXML
    public void initialize() throws IOException{
        Left = generalBorderPane.getLeft();
        if(isAdmin)
            borderIdentification.setCenter(FXMLLoader.load(getClass().getResource("/fxml/welcomeAdmin.fxml")));
    }

    public void Accueil() throws IOException {
        blueLabel.setText("A");
        whiteLabel.setText("ccueil");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneAccueil.fxml")));
        generalBorderPane.setLeft(Left);
    }

    public void Stage() throws IOException {
        blueLabel.setText("S");
        whiteLabel.setText("tages");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneStage.fxml")));
        generalBorderPane.setLeft(Left);
    }

    public void Magasins() throws IOException {
        blueLabel.setText("M");
        whiteLabel.setText("agasins");
        if(isAdmin)
            generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneMagasinsAdmin.fxml")));
        else
            generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneMagasins.fxml")));
        generalBorderPane.setLeft(Left);
    }

    public void Produits() throws IOException {
        blueLabel.setText("P");
        whiteLabel.setText("roduits");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/produits/paneProduits.fxml")));
        generalBorderPane.setLeft(FXMLLoader.load(getClass().getResource("/fxml/produits/paneLeftProduit.fxml")));
    }


    public void buttonAccueil() throws IOException {
        this.Accueil();
    }


}
