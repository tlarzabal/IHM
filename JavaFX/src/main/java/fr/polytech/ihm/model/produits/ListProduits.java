package fr.polytech.ihm.model.produits;

import fr.polytech.ihm.controller.produits.ListProduitsController;
import fr.polytech.ihm.controller.produits.UnProduitController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;

import java.io.IOException;

/**
 * Created by thiba on 03/03/2017.
 */
public class ListProduits extends ListCell<Produit[]> {


    @Override
    protected void updateItem(Produit[] produits, boolean empty) {
        super.updateItem(produits, empty);

        if (produits != null) {
            // Load fxml file for this internship
            try {
                String fxmlFile = "/fxml/produits/paneListProduits.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                for(Produit produit : produits)
                    ((ListProduitsController) loader.getController()).init(produit);
                    // Display content of the fxml file
                this.setGraphic(listElement);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
