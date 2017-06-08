package fr.polytech.ihm.controller.produits;

import fr.polytech.ihm.model.Singleton;
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
        Singleton singleton= Singleton.getInstance();

        /*
        if(!singleton.getProduitsSelectionnes().isEmpty())
            singleton.setProduits(singleton.getAllProduits());
        */
        produitsObservableList = singleton.getProduits();
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
        Singleton singleton=Singleton.getInstance();
        produitsObservableList=singleton.getProduits();
    }
}
