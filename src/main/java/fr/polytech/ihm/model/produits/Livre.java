package fr.polytech.ihm.model.produits;

/**
 * Created by thiba on 03/03/2017.
 */
public class Livre extends Produit {
    private String resume;
    public Livre(String n, String l, double p, int e, String r){
        super(n,l,p,e);
        resume=r;
    }
    @Override
    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
