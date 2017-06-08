package fr.unice.polytech.ihm.kevinapplication.model;

/**
 * Created by thiba on 17/05/2017.
 */

public enum MenuTitle {

    MAGASIN("Magasins"),CAMION("Camions"),RESPONSABLE("Responsable"),NOTIFICATION("Notifications"),PARAMETRE("Paramètres");

    private String name;

    private MenuTitle(String n){
        name=n;
    }
    @Override
    public String toString(){
        return name;
    }
}
