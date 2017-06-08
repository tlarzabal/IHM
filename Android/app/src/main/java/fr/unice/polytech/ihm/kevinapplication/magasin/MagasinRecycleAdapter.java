package fr.unice.polytech.ihm.kevinapplication.magasin;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import fr.unice.polytech.ihm.kevinapplication.MapsActivity;
import fr.unice.polytech.ihm.kevinapplication.R;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Magasin;

import static java.security.AccessController.getContext;


/**
 * Created by thiba on 07/04/2017.
 */

public class MagasinRecycleAdapter extends RecyclerView.Adapter<MagasinViewHolder> {

    ArrayList<Magasin> magasins=new ArrayList<>();
    CardView Cardmagasin;

    public MagasinRecycleAdapter(ArrayList<Magasin> magasins){
        this.magasins=magasins;
    }

    @Override
    public MagasinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Cardmagasin = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.magasin, parent, false);
        MagasinViewHolder mvh= new MagasinViewHolder(Cardmagasin,new MagasinViewHolder.IMyViewHolderClicks() {
            public void maps(View v) { Intent intent = new Intent(v.getContext() , MapsActivity.class);
                v.getContext().startActivity(intent);}
        });
        return mvh;
    }

    @Override
    public void onBindViewHolder(MagasinViewHolder holder, int position){
        Magasin magasin=magasins.get(position);
        holder.setCard(magasin.getNom(),magasin.getImage(),magasin.getDescription(),magasin.getX(),magasin.getY());
    }

    @Override
    public int getItemCount() {
        return magasins.size();
    }



}
