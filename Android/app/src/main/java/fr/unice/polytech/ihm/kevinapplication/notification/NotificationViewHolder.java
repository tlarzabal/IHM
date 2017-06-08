package fr.unice.polytech.ihm.kevinapplication.notification;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.unice.polytech.ihm.kevinapplication.ImageAsyncTask;
import fr.unice.polytech.ihm.kevinapplication.R;


/**
 * Created by thiba on 07/04/2017.
 */

class NotificationViewHolder extends RecyclerView.ViewHolder{

    CardView cardView;

    public NotificationViewHolder(CardView cardView) {
        super(cardView);
        this.cardView=cardView;
    }

    public void setCard(String category, String date, String descriptif){
        TextView title= (TextView) cardView.findViewById(R.id.category);
        title.setText(category);
        TextView date2= (TextView) cardView.findViewById(R.id.date);
        date2.setText(date);
        TextView descriptif2= (TextView) cardView.findViewById(R.id.descriptif);
        descriptif2.setText(descriptif);


        title.setTextColor(Color.rgb(20,20,20));
        switch (category){
            case "Ouverture/Fermeture de magasin":
                title.setBackgroundColor(Color.rgb(220,0,0));
                break;
            case "Offres/Promotions":
                title.setBackgroundColor(Color.rgb(0,220,0));
                break;
            case "Evenements spéciaux":
                title.setBackgroundColor(Color.rgb(0,100,220));
                break;
            default:
                title.setBackgroundColor(Color.rgb(255,255,255));
                break;
        }
    }

    public void setTitle(int i){
        TextView title= (TextView) cardView.findViewById(R.id.Title);
        if(i==0) {
            title.setText("Notifications A Venir");
            title.setBackgroundColor(Color.rgb(255, 255, 255));
        }
        else {
            title.setText("Notifications Passées");
            title.setBackgroundColor(Color.rgb(200,200,200));
            cardView.setBackgroundColor(Color.rgb(200,200,200));
        }

    }

}
