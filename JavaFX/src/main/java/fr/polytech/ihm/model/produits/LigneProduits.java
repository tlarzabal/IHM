package fr.polytech.ihm.model.produits;

import fr.polytech.ihm.controller.produits.UnProduitController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;

import java.io.IOException;

/**
 * Created by thiba on 14/03/2017.
 */
public class LigneProduits extends ListCell<Produit> {


    @Override
    protected void updateItem(Produit produit, boolean empty) {
        super.updateItem(produit, empty);

        if (produit != null) {
            // Load fxml file for this internship
            try {
                String fxmlFile = "/fxml/produits/paneUnProduit.fxml";
                FXMLLoader loader = new FXMLLoader();
                Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                ((UnProduitController) loader.getController()).init(produit);
                // Display content of the fxml file
                this.setGraphic(listElement);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}