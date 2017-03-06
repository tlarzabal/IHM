package fr.polytech.ihm.model.produits;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiba on 03/03/2017.
 */
public class Cd extends Produit {

    List<String> chansons=new ArrayList<String>();

    public Cd(String n, String l, double p, int e, ArrayList<String> c){
        super(n,l,p,e);
        chansons=c;
    }

    @Override
    public String getChansons(){
        String textChansons="";
        for(String c : chansons)
            textChansons+=c;
            return textChansons;
    }


}
