package fr.polytech.ihm.controller.magasins;

import fr.polytech.ihm.model.magasin.Magasin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.omg.CORBA.Object;

/**
 * Created by Pierre on 04/03/2017.
 */
public class MagasinController {

    public static ObservableList<Magasin> getMagasinsData() {
        return magasinsData;
    }

    private  static  ObservableList<Magasin> magasinsData;
    @FXML
    protected TableView<Magasin> magasinTable;
    @FXML
    private TableColumn<Magasin, String> magasinColumn;
    @FXML
    private TableColumn<Magasin, String> villeColumn;

    @FXML
    private Label magasinLabel;
    @FXML
    private Label adresseLabel;
    @FXML
    private Label villeLabel;
    @FXML
    private Label codePostalLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label emailLabel;


    @FXML
    public void initialize(){
        this.magasinsData= FXCollections.observableArrayList();
        this.magasinsData.add(new Magasin("EuroDiscount","2 rue Léon","Paris",75000,15485,"0@"));
        this.magasinsData.add(new Magasin("Nice Books","3 rue ","Nice",06000,5858,"1@"));
        this.magasinsData.add(new Magasin("World Book","10 rue Lagrange","Lyon",69000,4549,"fezgfe@"));
        this.magasinsData.add(new Magasin("Forum","11 rue Adolf" ,"Marseille",13000,546,"pierre@"));
        System.out.println("taille liste magasin data :"+ magasinsData.size());
        this.magasinTable.setItems(magasinsData);

        this.magasinColumn.setCellValueFactory(cellData -> cellData.getValue().magasinProperty());
        this.villeColumn.setCellValueFactory(cellData -> cellData.getValue().villeProperty());

        // Clear person details.
        showMagasinDetail(magasinsData.get(0));

        // Listen for selection changes and show the person details when changed.
        magasinTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMagasinDetail(newValue));

    }

    public void showMagasinDetail(Magasin magasin) {
        telephoneLabel.setText(Integer.toString(magasin.getTelephone()));
        emailLabel.setText(magasin.getEmail());
        magasinLabel.setText(magasin.getMagasin());
        adresseLabel.setText(magasin.getAdresse());
        codePostalLabel.setText(Integer.toString(magasin.getCodePostal()));
        villeLabel.setText(magasin.getVille());
        magasinLabel.setText(magasin.getMagasin());
    }


}
