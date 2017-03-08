package fr.polytech.ihm.model.stage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Pierre on 03/03/2017.
 */
public class Stage {

    private  IntegerProperty iDStage;
    private  StringProperty magasin;
    private  StringProperty date;
    private  StringProperty duree;
    private  IntegerProperty codePostal;
    private  StringProperty ville;

    public Stage(int idStage,String date,String duree,String magasin,String ville,int codePostal ){
        this.iDStage= new SimpleIntegerProperty(idStage);
        this.date= new SimpleStringProperty(date);
        this.duree=new SimpleStringProperty(duree);
        this.magasin = new SimpleStringProperty(magasin);
        this.ville= new SimpleStringProperty(ville);
        this.codePostal= new SimpleIntegerProperty(codePostal);
    }

    public int getiDStage() {
        return iDStage.get();
    }

    public IntegerProperty iDStageProperty() {
        return iDStage;
    }

    public void setiDStage(int iDStage) {
        this.iDStage.set(iDStage);
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

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getDuree() {
        return duree.get();
    }

    public StringProperty dureeProperty() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree.set(duree);
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

    public String getVille() {
        return ville.get();
    }

    public StringProperty villeProperty() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville.set(ville);
    }
}
