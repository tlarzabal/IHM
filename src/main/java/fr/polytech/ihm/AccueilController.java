package fr.polytech.ihm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pierre on 02/03/2017.
 */
public class AccueilController {



    @FXML
    private ImageView imageAccueil;

    private List<String> listeOfImage;
    private int cpt = 0;

    @FXML
    public void initialize(){
        listeOfImage = new ArrayList<>();
        listeOfImage.add("/images/accueil.jpg");
        listeOfImage.add("/images/accueil2.jpg");
        listeOfImage.add("/images/accueil3.jpg");
    }

    @FXML
    public void nextImage(){
        cpt++;
        if(cpt == listeOfImage.size())
            cpt = 0;
        imageAccueil.setImage(new Image(listeOfImage.get(cpt)));
    }
    @FXML
    public void beforeImage(){
        cpt--;
        if(cpt<0)
            cpt=listeOfImage.size()-1;

    }
}
