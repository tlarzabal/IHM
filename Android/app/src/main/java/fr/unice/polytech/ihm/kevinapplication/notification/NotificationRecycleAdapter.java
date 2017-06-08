package fr.unice.polytech.ihm.kevinapplication.notification;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import fr.unice.polytech.ihm.kevinapplication.R;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Magasin;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Notification;


/**
 * Created by thiba on 07/04/2017.
 */

public class NotificationRecycleAdapter extends RecyclerView.Adapter<NotificationViewHolder> {

    ArrayList<Notification> notifications=new ArrayList<>();
    ArrayList<Notification> notificationsPassif=new ArrayList<>();
    CardView cardNotification;

    public NotificationRecycleAdapter(ArrayList<Notification> notifications,ArrayList<Notification> notificationsPassif){
        this.notifications=notifications;
        this.notificationsPassif=notificationsPassif;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        cardNotification = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification, parent, false);
        NotificationViewHolder mvh= new NotificationViewHolder(cardNotification);
        return mvh;
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position){
        Notification notification;
        if(position==0)
            holder.setTitle(0);
        else if(position<=notifications.size()) {
            notification = notifications.get(position-1);
            holder.setCard(notification.getNom(), notification.getDate(), notification.getDescriptif());
        }
        else if(position== notifications.size()+1){
            holder.setTitle(1);
        }else{
            notification = notificationsPassif.get(position - (notifications.size()+2));
            holder.setCard(notification.getNom(),notification.getDate(),notification.getDescriptif());
        }
    }

    @Override
    public int getItemCount() {
        return notifications.size()+notificationsPassif.size()+2;
    }


}
