package fr.unice.polytech.ihm.kevinapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.unice.polytech.ihm.kevinapplication.camion.CamionExpandableListAdapter;
import fr.unice.polytech.ihm.kevinapplication.camion.ExpandableListCamion;
import fr.unice.polytech.ihm.kevinapplication.magasin.MagasinRecycleAdapter;
import fr.unice.polytech.ihm.kevinapplication.model.Menu;
import fr.unice.polytech.ihm.kevinapplication.model.MenuTitle;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Camion;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Notification;
import fr.unice.polytech.ihm.kevinapplication.model.bd.TypeNotification;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Magasin;
import fr.unice.polytech.ihm.kevinapplication.model.bd.Responsable;
import fr.unice.polytech.ihm.kevinapplication.notification.NotificationRecycleAdapter;
import fr.unice.polytech.ihm.kevinapplication.parametres.ParametreExpandableListAdapter;
import fr.unice.polytech.ihm.kevinapplication.parametres.ExpandableListDataPump;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Menu.MenuItem mItem;

    protected Responsable responsable=null;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    private View rootView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Menu.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content.toString());
                if(mItem.id.equals("1")) {
                    appBarLayout.setTitle(mItem.content+" de CapSophia");
                }
                else if(mItem.id.equals("3")) {
                    try {
                        DataBaseHelper bd=new DataBaseHelper(getActivity());
                        bd.createDataBase();
                        bd.openDataBase();
                        responsable=bd.getResponsable();
                        bd.close();
                    }catch(Exception e){}
                    appBarLayout.setTitle("Contactez " + responsable.getNom() +" "+ responsable.getPrenom());
                }
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Show the dummy content as text in a TextView.
        DataBaseHelper bd=new DataBaseHelper(getActivity());
        try {
            bd.createDataBase();
            bd.openDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(mItem != null){

            switch ( mItem.content){
                case MAGASIN:
                    rootView = inflater.inflate(R.layout.grid, container, false);
                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.test);
                    RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(this.getContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    ArrayList<Magasin> magasins=bd.getAllMagasins();
                    MagasinRecycleAdapter magasinRecycleAdapter = new MagasinRecycleAdapter(magasins);
                    recyclerView.setAdapter(magasinRecycleAdapter);
                    break;
                case CAMION:
                    rootView = inflater.inflate(R.layout.expandable_list, container, false);
                    ExpandableListView elv;
                    List<String> expandableListTitle;
                    HashMap<String, List<Camion>> expandableListDetail;
                    elv = (ExpandableListView) rootView.findViewById(R.id.expandableListView);
                    ExpandableListCamion.setCamions(bd.getCamions(7));
                    expandableListDetail = ExpandableListCamion.getData();
                    expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
                    ExpandableListAdapter ela= new CamionExpandableListAdapter(this.getContext(), expandableListTitle, expandableListDetail);
                    elv.setAdapter(ela);
                    break;
                case RESPONSABLE:
                    responsable=bd.getResponsable();
                    rootView = inflater.inflate(R.layout.responsable, container, false);
                    break;
                case NOTIFICATION:
                    rootView = inflater.inflate(R.layout.grid, container, false);
                    RecyclerView recyclerViewnot = (RecyclerView) rootView.findViewById(R.id.test);
                    RecyclerView.LayoutManager layoutManager1= new LinearLayoutManager(this.getContext());
                    recyclerViewnot.setLayoutManager(layoutManager1);
                    ArrayList<Notification> notifications=bd.getNotificationsActif();
                    ArrayList<Notification> notificationsPassif=bd.getNotificationsPassif();
                    NotificationRecycleAdapter notificationRecycleAdapter = new NotificationRecycleAdapter(notifications,notificationsPassif);
                    recyclerViewnot.setAdapter(notificationRecycleAdapter);
                    break;
                case PARAMETRE:
                    rootView = inflater.inflate(R.layout.expandable_list, container, false);
                    ExpandableListView expandableListView;
                    ExpandableListAdapter expandableListAdapter;
                    List<String> listTitle;
                    HashMap<String, List<TypeNotification>> listDetail;
                    expandableListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);
                    List<TypeNotification> test=bd.getTypeNotifications();
                    ExpandableListDataPump.setNotifications(test);
                    listDetail = ExpandableListDataPump.getData();
                    listTitle = new ArrayList<String>(listDetail.keySet());
                    expandableListAdapter = new ParametreExpandableListAdapter(this.getContext(), listTitle, listDetail);
                    expandableListView.setAdapter(expandableListAdapter);

                    expandableListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getContext() , MapsActivity.class);
                            startActivity(intent);
                        }
                    });
                    break;
                default:
                    rootView = inflater.inflate(R.layout.item_detail, container, false);
                    ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);
                    break;
            }
        }

        bd.close();
        return rootView;
    }

    public void call(View target){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:+33" + responsable.getTel()));
        startActivity(callIntent);
    }
    public void sendMail(View target) {
        final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        Intent.createChooser(emailIntent, "Send mail...");
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{responsable.getMail()});
        RadioGroup radioGroup=(RadioGroup) rootView.findViewById(R.id.radioButtons);
        RadioButton b=(RadioButton) rootView.findViewById(radioGroup.getCheckedRadioButtonId());
        i.putExtra(Intent.EXTRA_SUBJECT, "CapSophia - "+b.getText());
        startActivity(Intent.createChooser(i, "Titre:"));
    }

}
