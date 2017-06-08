package fr.polytech.ihm.model.magasin;

/**
 * Created by thiba on 15/03/2017.
 */
public class Statistiques {

    private Magasin magasin;
    private int ca;
    private int maintenance;

    public Statistiques(Magasin m,int c,int n){
        magasin=m;
        ca=c;
        maintenance=n;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public String getMagasinNom() {
        return magasin.getMagasin();
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }
}
