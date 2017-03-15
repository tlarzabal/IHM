package fr.polytech.ihm.model;

/**
 * Created by thiba on 08/03/2017.
 */

import fr.polytech.ihm.model.magasin.Magasin;
import fr.polytech.ihm.model.magasin.Statistiques;
import fr.polytech.ihm.model.produits.Cd;
import fr.polytech.ihm.model.produits.Dvd;
import fr.polytech.ihm.model.produits.Livre;
import fr.polytech.ihm.model.produits.Produit;
import fr.polytech.ihm.model.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

/** Exemple d'implémentation d'un singleton.<p>
 * Cet exemple ne fait rien.
 */

public class Singleton {

    private static ObservableList<Produit[]> produits;
    private static ObservableList<Produit[]> allProduits;
    private static ObservableList<Produit[]> produitsSelectionnes;
    private static ObservableList<Magasin> magasins;
    private static ObservableList<Stage> stages;
    private Statistiques[] statistiques;
    /** L'instance statique */
    private static Singleton instance;
    private Produit[] tabProduits=new Produit[5];
    private int compteur=0;


    /** Récupère l'instance unique de la class Singleton.<p>
     * Remarque : le constructeur est rendu inaccessible
     */
    public static Singleton getInstance() {
        if (null == instance) { // Premier appel
            instance = new Singleton();
        }
        return instance;
    }

    /** Constructeur redéfini comme étant privé pour interdire
     * son appel et forcer à passer par la méthode <link
     */
    private Singleton() {
        produits=FXCollections.observableArrayList();
        allProduits=FXCollections.observableArrayList();
        produitsSelectionnes=FXCollections.observableArrayList();
        magasins= FXCollections.observableArrayList();
        stages= FXCollections.observableArrayList();
        ArrayList<String> chansons= new ArrayList<String>();
        chansons.add("Chanson1");
        chansons.add("Chanson2");
        chansons.add("Chanson3");
        produits.add(new Produit[]{new Livre("John Doe", "images/r.jpg", 1.04, 0, "resumé"),
                        new Dvd("John Doe", "images/r.jpg", 1.95, 1, "resumé"),
                        new Cd("John Doe", "images/r.jpg", 1.04, 2, chansons),
                        new Livre("John Doe", "images/r.jpg", 1.04, 0, "resumé"),
                        new Dvd(" Doe", "images/r.jpg", 1.95, 1, "resumé")});

        produits.add(new Produit[]{new Livre("John Doe", "images/r.jpg", 1.04, 0, "resumé"),
                new Dvd("John Doe", "images/r.jpg", 1.95, 1, "resumé"),
                new Cd("John Doe", "images/r.jpg", 1.04, 2, chansons),
                new Livre("John Doe", "images/r.jpg", 1.04, 0, "resumé"),
                new Dvd(" Doe", "images/r.jpg", 1.95, 1, "resumé")});

        magasins.add(new Magasin("EuroDiscount","Zone Saint Philippe","Sophia Antipolis",06410,15485,"0@"));
        magasins.add(new Magasin("Nice Books","3 rue ","Nice",06000,5858,"1@"));
        magasins.add(new Magasin("World Book","10 rue Lagrange","Lyon",69000,4549,"fezgfe@"));
        magasins.add(new Magasin("Forum","11 rue Adolf" ,"Marseille",13000,546,"pierre@"));

        stages.add(new Stage(156,"12/10/2017","7 jours","EuroDiscount","Paris",75000));
        stages.add(new Stage(105,"22/06/2016","10 jours","Nice Books","Nice",06000));
        stages.add(new Stage(105,"22/04/2016","5 jours","World Book","Lyon",69000));
        stages.add(new Stage(105,"05/09/2016","1 mois","Forum","Marseille",13000));
        allProduits.addAll(produits);

        statistiques=new Statistiques[magasins.size()];
        for(int i=0;i<magasins.size();i++) {
            statistiques[i]=new Statistiques(magasins.get(i),i*1000+100000,(i+1)*10000);
        }
    }

    public ObservableList<Produit[]> getProduitsSelectionnes(){return produitsSelectionnes;}

    public void clearProduitSelectionnes(){
        produitsSelectionnes.clear();
    }

    public ObservableList addProduitsSelectionnes(int type){
        for(Produit[] tabProduit : allProduits){
            tabProduits=new Produit[5];
            for(Produit produit : tabProduit){
                if(produit!=null && produit.getEtat()==type){
                    if(compteur==5) {
                        produitsSelectionnes.add(tabProduits);
                        compteur = 0;
                    }
                    tabProduits[compteur] = produit;
                    compteur++;
                }
            }
        }
        produitsSelectionnes.add(tabProduits);
        return produitsSelectionnes;
    }
    public ObservableList<Produit[]> getProduits(){return produits;}

    public ObservableList<Magasin> getMagasins(){return magasins;}

    public ObservableList<Produit[]> getAllProduits(){return allProduits;}
    public Statistiques[] getStatistiques(){return statistiques;}
    public ObservableList<Stage> getStage(){return stages;}
    public void setProduits(ObservableList<Produit[]> p){
        produits.clear();
        produits.addAll(p);}

}