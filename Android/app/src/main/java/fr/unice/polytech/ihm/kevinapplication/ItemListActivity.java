package fr.unice.polytech.ihm.kevinapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import fr.unice.polytech.ihm.kevinapplication.model.Menu;
import fr.unice.polytech.ihm.kevinapplication.model.bd.TypeNotification;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    public View mView=null;
    private ItemDetailFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        View recyclerView = findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(Menu.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Menu.MenuItem> mValues;

        public SimpleItemRecyclerViewAdapter(List<Menu.MenuItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            parent.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            ImageAsyncTask imageAsyncTask = new ImageAsyncTask(holder.mimage);
            imageAsyncTask.execute(mValues.get(position).image);
            holder.mContentView.setText(mValues.get(position).content.toString());
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        if(mView!=null)
                            mView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        holder.mView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                        mView=holder.mView;
                        fragment = new ItemDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.item_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, ItemDetailActivity.class);
                        intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final ImageView mimage;
            public final TextView mContentView;
            public Menu.MenuItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mimage = (ImageView) view.findViewById(R.id.image);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }

    public void call(View target){
        fragment.call(target);
    }
    public void sendMail(View target) {
        fragment.sendMail(target);
    }
    public void onswitch(View target){
        DataBaseHelper bd=new DataBaseHelper(this);
        try {
            bd.createDataBase();
            bd.openDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bd.updateNotification(new TypeNotification((String) ((Switch) target.findViewById(R.id.expandedListItem)).getText(),((Switch) target.findViewById(R.id.expandedListItem)).isChecked()));
        List<fr.unice.polytech.ihm.kevinapplication.model.bd.Notification> notifications=bd.getNotificationsActif();
        if(((Switch) target.findViewById(R.id.expandedListItem)).isChecked())
            createNotification(notifications);
    }


    private final void createNotification(List<fr.unice.polytech.ihm.kevinapplication.model.bd.Notification> notifications){
        int i=0;
        for(fr.unice.polytech.ihm.kevinapplication.model.bd.Notification n :notifications) {
            NotificationManager mNotification = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Intent launchNotifiactionIntent = new Intent(this, ItemDetailActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, launchNotifiactionIntent, PendingIntent.FLAG_ONE_SHOT);
            Notification.Builder builder = new Notification.Builder(this)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle(n.getNom())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText(n.getDescriptif())
                    .setContentIntent(pendingIntent);
            mNotification.notify(i, builder.build());
            i++;
        }
    }

}
