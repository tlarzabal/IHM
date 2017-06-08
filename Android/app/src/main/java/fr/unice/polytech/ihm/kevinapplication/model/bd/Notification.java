package fr.unice.polytech.ihm.kevinapplication.model.bd;

/**
 * Created by thiba on 16/05/2017.
 */

public class Notification {
    private String nom;
    private String date;
    private int id_magasin;
    private String descriptif;

    public Notification(String nom, String date, int id_magasin, String descriptif) {
        this.nom = nom;
        this.date = date;
        this.id_magasin = id_magasin;
        this.descriptif = descriptif;
    }

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public int getId_magasin() {
        return id_magasin;
    }

    public String getDescriptif() {
        return descriptif;
    }
}
