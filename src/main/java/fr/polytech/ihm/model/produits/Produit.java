package fr.polytech.ihm.model.produits;

/**
 * Created by thiba on 03/03/2017.
 */
public abstract class Produit {

    private String nom;
    private String lienImage;
    private double prix;
    private int etat=0;//Etat du Produit : Normal =0 , Nouveau=1, Promo=2

    public Produit(String n, String l, double p, int e){
        nom=n;
        lienImage=l;
        prix=p;
        etat=e;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getChansons() {return "";}

    public String getResume(){return "";}
}
