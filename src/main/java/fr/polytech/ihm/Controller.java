package fr.polytech.ihm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
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
public class Controller {
    @FXML
    private BorderPane generalBorderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label blueLabel;
    @FXML
    private Label whiteLabel;
    @FXML
    private ImageView bienvenue;
    @FXML
    private ImageView toBeOrToHave;

    private List<String> listeOfImage;
    private int cpt = 0;

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


    public void Accueil() throws IOException {
        blueLabel.setText("A");
        whiteLabel.setText("ccueil");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneAccueil.fxml")));
    }

    public void Stage() throws IOException {
        blueLabel.setText("S");
        whiteLabel.setText("tage");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneStage.fxml")));
    }

    public void Promotion() throws IOException {
        blueLabel.setText("P");
        whiteLabel.setText("romotions");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/panePromos.fxml")));
    }
    public void Produits() throws IOException {
        blueLabel.setText("P");
        whiteLabel.setText("roduits");
        generalBorderPane.setCenter(FXMLLoader.load(getClass().getResource("/fxml/paneProduits.fxml")));
    }

    public void toBeOrToHave(){
        System.out.println("");
    }
}
