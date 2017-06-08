package fr.unice.polytech.ihm.kevinapplication.model.bd;

/**
 * Created by thiba on 10/05/2017.
 */

public class Camion {

    private int id;
    private String date;
    private String horaire;
    private int id_magasin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(int id_magasin) {
        this.id_magasin = id_magasin;
    }

    public Camion(int id, String date, String horaire, int id_magasin) {

        this.id = id;
        this.date = date;
        this.horaire = horaire;
        this.id_magasin = id_magasin;
    }
}
