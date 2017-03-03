package fr.polytech.ihm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Observable;

/**
 * Created by Pierre on 03/03/2017.
 */
public class StageController extends EmailController {

    private ObservableList<Stage> stagesData ;

    @FXML
    private TableView<Stage> stageTable;
    @FXML
    private TableColumn<Stage, Integer> idStageColumn;
    @FXML
    private TableColumn<Stage, String> villeColumn;

    @FXML
    private Label idStageLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label dureeLabel;
    @FXML
    private Label codePostalLabel;
    @FXML
    private Label villeLabel;
    @FXML
    private Label magasinLabel;



    @FXML
    private TextField idStageField;
    /*
    @FXML
    private TextField emailField;
    @FXML
    private TextArea textField;
*/
    @FXML
    public void initialize(){
        this.stagesData= FXCollections.observableArrayList();
        this.stagesData.add(new Stage(156,"12/10/2017","7 jours","EuroDiscount","Paris",75000));
        this.stagesData.add(new Stage(105,"22/06/2016","10 jours","Nice Books","Nice",06000));
        this.stagesData.add(new Stage(105,"22/04/2016","5 jours","World Book","Lyon",69000));
        this.stagesData.add(new Stage(105,"05/09/2016","1 mois","Forum","Marseille",13000));

        stageTable.setItems(stagesData);

        idStageColumn.setCellValueFactory(cellData -> cellData.getValue().iDStageProperty().asObject());
        villeColumn.setCellValueFactory(cellData -> cellData.getValue().villeProperty());

        // Clear person details.
        showStageDetail(stagesData.get(0));

        // Listen for selection changes and show the person details when changed.
        stageTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showStageDetail(newValue));

    }

    public void sendEmail(){
        String email ="ID Stage : "+idStageField.getText() +"\n";
        System.out.print(email);
        super.sendEmail();

    }

    private void showStageDetail(Stage stage) {
        idStageLabel.setText(Integer.toString(stage.getiDStage()));
        dateLabel.setText(stage.getDate());
        dureeLabel.setText(stage.getDuree());
        codePostalLabel.setText(Integer.toString(stage.getCodePostal()));
        villeLabel.setText(stage.getVille());
        magasinLabel.setText(stage.getMagasin());
    }



}
