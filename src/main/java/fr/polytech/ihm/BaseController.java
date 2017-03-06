package fr.polytech.ihm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/*
    @FXML
    private TextField emailField;
    @FXML
    private TextArea textField;
*/



    public void Accueil() throws IOException {
        blueLabel.setText("A");
        whiteLabel.setText("ccueil");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneAccueil.fxml")));
        generalBorderPane.setLeft(generalBorderPane.getRight());
    }

    public void Stage() throws IOException {
        blueLabel.setText("S");
        whiteLabel.setText("tages");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneStage.fxml")));
    }

    public void Magasins() throws IOException {
        blueLabel.setText("M");
        whiteLabel.setText("agasins");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneMagasins.fxml")));
    }
    public void Produits() throws IOException {
        blueLabel.setText("P");
        whiteLabel.setText("roduits");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneCenterProduit.fxml")));
        generalBorderPane.setLeft(FXMLLoader.load(getClass().getResource("/fxml/paneLeftProduit.fxml")));
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
