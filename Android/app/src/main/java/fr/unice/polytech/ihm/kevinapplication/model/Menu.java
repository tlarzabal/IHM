package fr.unice.polytech.ihm.kevinapplication.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thiba on 10/05/2017.
 */

public class Menu {

    public static final List<MenuItem> ITEMS = new ArrayList<MenuItem>();


    public static final Map<String, MenuItem> ITEM_MAP = new HashMap<String, MenuItem>();


    static {

        addItem(new MenuItem(String.valueOf(1),"http://www.icone-png.com/png/43/43306.png", MenuTitle.MAGASIN, makeDetails("Magasins ")));
        addItem(new MenuItem(String.valueOf(2),"http://solubrux.fr/wp-content/uploads/2013/01/V4-Icone-camion1.png", MenuTitle.CAMION, makeDetails("Camions ")));
        addItem(new MenuItem(String.valueOf(3),"http://laboratoire-gbvb.tn/wp-content/uploads/2016/01/user-icon-512-274x300.png", MenuTitle.RESPONSABLE, makeDetailsResponsable()));
        addItem(new MenuItem(String.valueOf(4),"https://cdn.pixabay.com/photo/2015/12/16/17/41/bell-1096280_960_720.png", MenuTitle.NOTIFICATION, makeDetails("TypeNotification ")));
        addItem(new MenuItem(String.valueOf(5),"https://cdn.pixabay.com/photo/2015/12/04/22/20/gear-1077550_960_720.png", MenuTitle.PARAMETRE, makeDetails("Parametres ")));

    }

    private static void addItem(MenuItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    private static String makeDetails(String theme) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about "+theme+": ");
        builder.append("\nMore details information here.");
        return builder.toString();
    }
    private static String makeDetailsResponsable() {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about : ");
        builder.append("\nMore details information here.");
        return builder.toString();
    }


    public static class MenuItem {
        public final String image;
        public final String id;
        public final MenuTitle content;
        public final String details;

        public MenuItem(String id,String image, MenuTitle content, String details) {
            this.id=id;
            this.image = image;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content.toString();
        }
    }
}
