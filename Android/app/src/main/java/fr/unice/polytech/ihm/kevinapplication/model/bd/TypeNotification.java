package fr.unice.polytech.ihm.kevinapplication.model.bd;

/**
 * Created by thiba on 14/05/2017.
 */

public class TypeNotification {
    private String nom;
    private boolean actif;
    public TypeNotification(String string, int i) {
        nom=string;
        actif=(i==1);
    }

    public TypeNotification(String string, boolean i) {
        nom=string;
        actif=i;
    }
    public String getNom() {
        return nom;
    }

    public boolean isActif() {
        return actif;
    }
}
