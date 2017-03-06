package fr.polytech.ihm.controller.produits;

import fr.polytech.ihm.model.produits.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.ArrayList;

/**
 * Created by thiba on 03/03/2017.
 */
public class ProduitsController {
    @FXML
    private ListView<Produit[]> listeProduits;

    private ObservableList<Produit[]> produitsObservableList;
    @FXML
    public void initialize() {
        produitsObservableList = FXCollections.observableArrayList();
        //add some Students

        initProduits(produitsObservableList);

        listeProduits.setItems(produitsObservableList);
        listeProduits.setCellFactory(new Callback<ListView<Produit[]>, ListCell<Produit[]>>() {
            @Override
            public ListCell<Produit[]> call(ListView<Produit[]> listView) {
                return new ListProduits();
            }
        });
    }



    public void initProduits(ObservableList<Produit[]> produitsObservableList){
        Produit[] ligneProduit=new Produit[5];

        ArrayList<String> chansons= new ArrayList<String>();
        chansons.add("Chanson1");
        chansons.add("Chanson2");
        chansons.add("Chanson3");

        ligneProduit[0]=new Livre("John Doe", "images/r.jpg", 1.04, 0, "resumé");
        ligneProduit[1]=new Dvd("John Doe", "images/r.jpg", 1.95, 1, "resumé");
        ligneProduit[2]=new Cd("John Doe", "images/r.jpg", 1.04, 2, chansons);
        ligneProduit[3]=new Livre("John Doe", "images/r.jpg", 1.04, 0, "resumé");
        ligneProduit[4]=new Dvd("John Doe", "images/r.jpg", 1.95, 1, "resumé");
        produitsObservableList.add(ligneProduit);
        Produit[] ligneProduit2= new Produit[5];
        ligneProduit2[0]=ligneProduit[0];
        ligneProduit2[1]=ligneProduit[1];
        ligneProduit2[2]=ligneProduit[2];
        ligneProduit2[3]=ligneProduit[3];
        produitsObservableList.add(ligneProduit2);
    }
}
