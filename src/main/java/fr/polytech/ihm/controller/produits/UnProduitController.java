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

    @FXML
    Label nom2;
    @FXML
    Label prix2;
    @FXML
    Label resume2;
    @FXML
    ImageView image2;
    @FXML
    Rectangle rectangle2;
    @FXML
    Label special2;

    @FXML
    Label nom3;
    @FXML
    Label prix3;
    @FXML
    Label resume3;
    @FXML
    ImageView image3;
    @FXML
    Rectangle rectangle3;
    @FXML
    Label special3;

    @FXML
    Label nom4;
    @FXML
    Label prix4;
    @FXML
    Label resume4;
    @FXML
    ImageView image4;
    @FXML
    Rectangle rectangle4;
    @FXML
    Label special4;

    @FXML
    Label nom5;
    @FXML
    Label prix5;
    @FXML
    Label resume5;
    @FXML
    ImageView image5;
    @FXML
    Rectangle rectangle5;
    @FXML
    Label special5;


    public void init(Produit[] produits){
        Label[] noms=new Label[5];noms[0]=nom1;noms[1]=nom2;noms[2]=nom3;noms[3]=nom4;noms[4]=nom5;
        Label[] prix=new Label[5];prix[0]=prix1;prix[1]=prix2;prix[2]=prix3;prix[3]=prix4;prix[4]=prix5;
        Label[] resumes=new Label[5];resumes[0]=resume1;resumes[1]=resume2;resumes[2]=resume3;resumes[3]=resume4;resumes[4]=resume5;
        Rectangle[] rectangles=new Rectangle[5];rectangles[0]=rectangle1;rectangles[1]=rectangle2;rectangles[2]=rectangle3;rectangles[3]=rectangle4;rectangles[4]=rectangle5;
        Label[] specials=new Label[5];specials[0]=special1;specials[1]=special2;specials[2]=special3;specials[3]=special4;specials[4]=special5;
        ImageView[] images=new ImageView[5];images[0]=image1;images[1]=image2;images[2]=image3;images[3]=image4;images[4]=image5;

        //nom1.setText(produit[0].getNom());
        //prix1.setText(String.valueOf(produit[0].getPrix()));
        //image1.setImage(new Image(produit[0].getLienImage()));
        //resume.setText();


        for(int i=0;i<produits.length && produits[i]!=null;i++){
            noms[i].setText(produits[i].getNom());
            prix[i].setText(String.valueOf(produits[i].getPrix()));
            images[i].setImage(new Image(produits[i].getLienImage()));

            if(produits[i].getClass().getName().equals("fr.polytech.ihm.model.produits.Cd"))
                resumes[i].setText(produits[i].getChansons());
            else
                resumes[i].setText(produits[i].getResume());

            switch (produits[i].getEtat()){ //PLUSIEURS ETAT 0:NORMAL 1:NOUVEAU 2:PROMOTION
                case 0:
                    rectangles[i].setFill(Color.TRANSPARENT);
                    rectangles[i].setStroke(Color.TRANSPARENT);
                    specials[i].setText(" ");
                    break;
                case 1:
                    rectangles[i].setFill(Color.rgb(255,31,31));
                    rectangles[i].setStroke(Color.TRANSPARENT);
                    specials[i].setText("Nouveauté");
                    break;
                case 2:
                    rectangles[i].setFill(Color.rgb(31,31,255));
                    rectangles[i].setStroke(Color.TRANSPARENT);
                    specials[i].setText("Promotion");
                    break;
            }
        }
    }
}
