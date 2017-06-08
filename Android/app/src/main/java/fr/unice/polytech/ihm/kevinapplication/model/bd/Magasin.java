package fr.unice.polytech.ihm.kevinapplication.model.bd;

/**
 * Created by thiba on 10/05/2017.
 */

public class Magasin {

    private int id;
    private String nom;
    private String image;
    private String description;
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Magasin(int id, String nom, String image, String description,double x,double y) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.description = description;
        this.x=x;
        this.y=y;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
