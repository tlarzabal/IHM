package fr.polytech.ihm.controller.produits;

import fr.polytech.ihm.model.produits.Produit;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by thiba on 04/03/2017.
 */
public class UnProduitController {

    @FXML
    Label nom1;
    @FXML
    Label prix1;
    @FXML
    Label resume1;
    @FXML
    ImageView image1;
    @FXML
    Rectangle rectangle1;
    @FXML
    Label special1;

    public void init(Produit produits){
            nom1.setText(produits.getNom());
            prix1.setText(String.valueOf(produits.getPrix())+"€");
            image1.setImage(new Image(produits.getLienImage()));

            if(produits.getClass().getName().equals("fr.polytech.ihm.model.produits.Cd"))
                resume1.setText(produits.getChansons());
            else
                resume1.setText(produits.getResume());

            switch (produits.getEtat()){ //PLUSIEURS ETAT 0:NORMAL 1:NOUVEAU 2:PROMOTION
                case 0:
                    rectangle1.setFill(Color.TRANSPARENT);
                    rectangle1.setStroke(Color.TRANSPARENT);
                    special1.setText(" ");
                    break;
                case 1:
                    rectangle1.setFill(Color.rgb(255,31,31));
                    rectangle1.setStroke(Color.TRANSPARENT);
                    special1.setText("Nouveauté");
                    break;
                case 2:
                    rectangle1.setFill(Color.rgb(31,31,255));
                    rectangle1.setStroke(Color.TRANSPARENT);
                    special1.setText("Promotion");
                    break;
            }

    }
}
