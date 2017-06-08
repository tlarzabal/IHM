package fr.unice.polytech.ihm.kevinapplication.magasin;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.Random;

import fr.unice.polytech.ihm.kevinapplication.ImageAsyncTask;
import fr.unice.polytech.ihm.kevinapplication.MapsActivity;
import fr.unice.polytech.ihm.kevinapplication.R;


/**
 * Created by thiba on 07/04/2017.
 */

class MagasinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    CardView cardView;
    public IMyViewHolderClicks mListener;
    private LatLng position;
    private String nom;

    public MagasinViewHolder(CardView cardView,IMyViewHolderClicks listener) {
        super(cardView);
        this.cardView=cardView;
        mListener=listener;
        cardView.setOnClickListener(this);
    }

    public void setCard(String nom, String image, String description,double x,double y){
        TextView title= (TextView) cardView.findViewById(R.id.title);
        title.setText(description);
        TextView date= (TextView) cardView.findViewById(R.id.category);
        date.setText(nom);
        TextView nbPersonne= (TextView) cardView.findViewById(R.id.nbPersonnes);
        Random r = new Random();
        int valeur = r.nextInt(1000);
        nbPersonne.setText(valeur +" visiteurs aujourd'hui");
        ImageAsyncTask imageAsyncTask=new ImageAsyncTask((ImageView) cardView.findViewById(R.id.image));
        imageAsyncTask.execute(image);
        position=new LatLng(x,y);
        this.nom=nom;
    }

    @Override
    public void onClick(View v) {
        MapsActivity.nom=nom;
        MapsActivity.pos = position;
        mListener.maps(v);
    }

    public static interface IMyViewHolderClicks {
        public void maps(View v);
    }
}
