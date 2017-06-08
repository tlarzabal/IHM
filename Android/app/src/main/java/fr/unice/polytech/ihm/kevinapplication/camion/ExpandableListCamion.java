package fr.unice.polytech.ihm.kevinapplication.camion;

/**
 * Created by thiba on 14/05/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.unice.polytech.ihm.kevinapplication.model.bd.Camion;
import fr.unice.polytech.ihm.kevinapplication.model.bd.TypeNotification;

public class ExpandableListCamion {
    private static List<Camion> camions;
    private static HashMap<String, List<Camion>> expandableListDetail;

    public static HashMap<String, List<Camion>> getData() {
        return expandableListDetail;
    }

    public static void setCamions(ArrayList<Camion> camion){
        camions=camion;
        expandableListDetail = new HashMap<String, List<Camion>>();
        for (Camion c: camions){
            if(!expandableListDetail.containsKey(c.getDate())) {
                expandableListDetail.put(c.getDate(), new ArrayList<Camion>());
            }
            expandableListDetail.get(c.getDate()).add(c);
        }

    }
}