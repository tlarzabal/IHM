package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Pierre on 25/02/2017.
 */
public class BaseController {

    public BaseController(){

    }
     private  BorderPane rootLayout;

    private Main main;;


    @FXML
    private Label blueLabel;

    @FXML
    private Label whiteLabel;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu accueil;

    @FXML
    private Menu magasins;

    @FXML
    private Menu produits;

    @FXML
    private Menu stages;

    @FXML
    private Button button;

    @FXML
    private  void onButoon() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("paneStage.fxml"));
            Pane paneStage = (Pane) loader.load();
            getRootLayout().setCenter(paneStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void actionAccueil() {



    }
    @FXML
    private void actionMagasins() {
        System.out.println(" ta mere");
    }
    @FXML
    private void actionProduits() {

    }
    @FXML
    private void actionStages() {
        try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("paneStage.fxml"));
        Pane paneStage = (Pane) loader.load();
        getRootLayout().setCenter(paneStage);
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
    public void setMain(Main main) {
        this.main = main;
    }

    public void setCenter(Pane center){
        this.rootLayout.setCenter(center);
    }
    public void setRootLayout(BorderPane rootLayout){ this.rootLayout=rootLayout;}
    public BorderPane getRootLayout(){ return main.getRootLayout();}
}
