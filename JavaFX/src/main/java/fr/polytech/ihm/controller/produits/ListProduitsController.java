package fr.polytech.ihm.controller.produits;

import fr.polytech.ihm.model.Singleton;
import fr.polytech.ihm.model.produits.LigneProduits;
import fr.polytech.ihm.model.produits.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Created by thiba on 14/03/2017.
 */
public class ListProduitsController {
    @FXML
    private ListView<Produit> ligneProduits;

    private ObservableList<Produit> produitsObservableList= FXCollections.observableArrayList();

    public void init(Produit produit){
        produitsObservableList.add(produit);

        ligneProduits.setItems(produitsObservableList);
        ligneProduits.setCellFactory(new Callback<ListView<Produit>, ListCell<Produit>>() {
            @Override
            public ListCell<Produit> call(ListView<Produit> listView) {
                return new LigneProduits();
            }
        });
    }
}
