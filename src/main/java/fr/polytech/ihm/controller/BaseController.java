package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.produits.Produit;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * Created by dziri on 28/02/17.
 */
public class BaseController extends EmailController {


    @FXML
    private BorderPane generalBorderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label blueLabel;
    @FXML
    private Label whiteLabel;
    @FXML
    private ImageView toBeOrToHave;

    private ObservableList<Produit> produitsObservableList;

    private Node Left;


/*
    @FXML
    private TextField emailField;
    @FXML
    private TextArea textField;
*/

    @FXML
    public void initialize(){
        Left=generalBorderPane.getLeft();
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
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneMagasins.fxml")));
        generalBorderPane.setLeft(Left);
    }
    public void Produits() throws IOException {
        blueLabel.setText("P");
        whiteLabel.setText("roduits");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/produits/paneProduits.fxml")));
        generalBorderPane.setLeft(FXMLLoader.load(getClass().getResource("/fxml/produits/paneLeftProduit.fxml")));
    }


    public void buttonAccueil() throws IOException{
        this.Accueil();
    }
/*
    public void sendEmail(){
        String email ="Email : "+emailField.getText() +"\n" + "Contenu : "+ textField.getText();
        System.out.println(email);
    }
    */
}
