package fr.polytech.ihm.controller.magasins;

import com.lynden.gmapsfx.javascript.object.*;
import fr.polytech.ihm.model.Singleton;
import fr.polytech.ihm.model.magasin.Magasin;
import fr.polytech.ihm.model.magasin.Statistiques;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.lynden.gmapsfx.GoogleMapView;

/**
 * Created by Pierre on 04/03/2017.
 */
public class MagasinController {

    public static ObservableList<Magasin> getMagasinsData() {
        return magasinsData;
    }

    private static ObservableList<Magasin> magasinsData;
    @FXML
    protected TableView<Magasin> magasinTable;
    @FXML
    private TableColumn<Magasin, String> magasinColumn;
    @FXML
    private TableColumn<Magasin, String> villeColumn;

    @FXML
    private Label magasinLabel;
    @FXML
    private Label adresseLabel;
    @FXML
    private Label villeLabel;
    @FXML
    private Label codePostalLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label emailLabel;




    @FXML
    private GoogleMapView googleMapView;

    @FXML
    private Axis<String> xAxis;
    @FXML
    private Axis<Integer> yAxis;


    @FXML
    private BarChart<String, Integer> BarChart;


    private GoogleMap map;


    @FXML
    public void initialize() {
        initialize(false);

    }

    public void initialize(boolean admin) {

        //BarChart=new BarChart<String, Integer>(xAxis,yAxis);

        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getMagasins().get(0).getAdresse());
        this.magasinsData = singleton.getMagasins();
        System.out.println("taille liste magasin data :" + magasinsData.size());
        this.magasinTable.setItems(magasinsData);

        this.magasinColumn.setCellValueFactory(cellData -> cellData.getValue().magasinProperty());
        this.villeColumn.setCellValueFactory(cellData -> cellData.getValue().villeProperty());

        // Clear person details.
        showMagasinDetail(magasinsData.get(0));

        // Listen for selection changes and show the person details when changed.
        magasinTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMagasinDetail(newValue));

        if(!admin)
            googleMapView.addMapInializedListener(() -> configureMap(43.615564,7.071918));
    }

    public void showMagasinDetail(Magasin magasin) {
        telephoneLabel.setText(Integer.toString(magasin.getTelephone()));
        emailLabel.setText(magasin.getEmail());
        magasinLabel.setText(magasin.getMagasin());
        adresseLabel.setText(magasin.getAdresse());
        codePostalLabel.setText(Integer.toString(magasin.getCodePostal()));
        villeLabel.setText(magasin.getVille());
        magasinLabel.setText(magasin.getMagasin());
        //googleMapView.addMapInializedListener(() -> configureMap(0,0));
    }

    protected void configureMap(double latitude,double longitude) {
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(latitude, longitude))
                .mapType(MapTypeIdEnum.ROADMAP)
                .zoom(15);
        map = googleMapView.createMap(mapOptions, false);
        MarkerOptions markerOptions = new MarkerOptions();
        LatLong markerLatLong = new LatLong(latitude, longitude);
        markerOptions.position(markerLatLong)
                .title("Cap Sophia")
                .animation(Animation.BOUNCE)
                .visible(true);
        final Marker myMarker = new Marker(markerOptions);
        map.addMarker(myMarker);
    }


    public void setChart() {
        XYChart.Series setcA = new XYChart.Series<>();
        setcA.setName("Chiffre d'affaire");
        XYChart.Series setnbEmp= new XYChart.Series<>();
        setnbEmp.setName("Coût de la maintenance");
        Singleton singleton=Singleton.getInstance();

        for (Statistiques statistiques : singleton.getStatistiques()) {
            setcA.getData().add(new XYChart.Data(statistiques.getMagasinNom(), statistiques.getCa()));
            setnbEmp.getData().add(new XYChart.Data(statistiques.getMagasinNom(), statistiques.getMaintenance()));
        }
        BarChart.getData().addAll(setcA);
        BarChart.getData().addAll(setnbEmp);
    }

}
