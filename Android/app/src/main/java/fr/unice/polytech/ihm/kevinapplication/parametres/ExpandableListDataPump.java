package fr.unice.polytech.ihm.kevinapplication.parametres;

/**
 * Created by thiba on 14/05/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import fr.unice.polytech.ihm.kevinapplication.model.bd.TypeNotification;

public class ExpandableListDataPump {
    private static List<TypeNotification> notifications=null;

    public static HashMap<String, List<TypeNotification>> getData() {
        HashMap<String, List<TypeNotification>> expandableListDetail = new HashMap<String, List<TypeNotification>>();
        expandableListDetail.put("NOTIFICATIONS",  notifications);
        expandableListDetail.put("PARAMETRES", new ArrayList<TypeNotification>() );
        return expandableListDetail;
    }

    public static void setNotifications(List<TypeNotification> n){
        notifications=  n;
    }
}