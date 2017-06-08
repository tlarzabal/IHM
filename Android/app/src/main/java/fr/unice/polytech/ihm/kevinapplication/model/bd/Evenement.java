package fr.unice.polytech.ihm.kevinapplication.model.bd;

/**
 * Created by thiba on 10/05/2017.
 */

public class Evenement {
    private int id;
    private String nom;
    private String type;
    private String date;
    private String horaire;
    private int id_magasin;



    public Evenement(int id, String nom, String type, String date, String horaire, int id_magasin) {

        this.id = id;
        this.nom = nom;
        this.type = type;
        this.date = date;
        this.horaire = horaire;
        this.id_magasin = id_magasin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }
}
