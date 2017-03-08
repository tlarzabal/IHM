package fr.polytech.ihm.model.magasin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Pierre on 04/03/2017.
 */
public class Magasin {



    private StringProperty magasin;
    private  StringProperty adresse;
    private  StringProperty ville;
    private  IntegerProperty codePostal;
    private  IntegerProperty telephone;
    private  StringProperty email;


    public Magasin(String magasin, String adresse, String ville, int codePostal, int telephone, String email){
        this.magasin = new SimpleStringProperty(magasin);
        this.adresse= new SimpleStringProperty(adresse);
        this.ville= new SimpleStringProperty(ville);
        this.codePostal= new SimpleIntegerProperty(codePostal);
        this.telephone = new SimpleIntegerProperty(telephone);
        this.email= new SimpleStringProperty(email);
    }


    public String getMagasin() {
        return magasin.get();
    }

    public StringProperty magasinProperty() {
        return magasin;
    }

    public void setMagasin(String magasin) {
        this.magasin.set(magasin);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
    }

    public String getVille() {
        return ville.get();
    }

    public StringProperty villeProperty() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville.set(ville);
    }

    public int getCodePostal() {
        return codePostal.get();
    }

    public IntegerProperty codePostalProperty() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal.set(codePostal);
    }

    public int getTelephone() {
        return telephone.get();
    }

    public IntegerProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone.set(telephone);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
