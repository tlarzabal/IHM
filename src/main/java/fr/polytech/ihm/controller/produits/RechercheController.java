package fr.polytech.ihm.controller.produits;
import fr.polytech.ihm.controller.base.BaseController;
import fr.polytech.ihm.model.Singleton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * Created by thiba on 08/03/2017.
 */
public class RechercheController {

    @FXML
    private CheckBox checkboxPromos;
    @FXML
    private CheckBox checkboxNouveautes;
    @FXML
    private CheckBox checkboxAutres;

    public void recherche() throws IOException {
        System.out.println("ok");
        Singleton singleton=Singleton.getInstance();
        singleton.clearProduitSelectionnes();
        if(checkboxPromos.isSelected())
            singleton.addProduitsSelectionnes(2);
        if(checkboxNouveautes.isSelected())
            singleton.addProduitsSelectionnes(1);
        if(checkboxAutres.isSelected())
            singleton.addProduitsSelectionnes(0);
        singleton.setProduitsSelectionne();
    }
}
