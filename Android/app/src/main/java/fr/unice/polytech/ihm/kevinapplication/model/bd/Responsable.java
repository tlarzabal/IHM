package fr.unice.polytech.ihm.kevinapplication.model.bd;

/**
 * Created by thiba on 10/05/2017.
 */

public class Responsable {
    private String nom;
    private String prenom;
    private String mail;
    private int tel;

    public Responsable(String nom, String prenom, String mail, int tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
