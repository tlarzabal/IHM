package fr.polytech.ihm.controller.magasins;

import fr.polytech.ihm.model.Singleton;
import fr.polytech.ihm.model.magasin.Magasin;
import fr.polytech.ihm.model.magasin.Statistiques;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Pierre on 12/03/2017.
 */
public class MagasinAdminController extends  MagasinController {

    @FXML
    public void initialize(){
        super.initialize(true);
        setChart();
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = this.magasinTable.getSelectionModel().getSelectedIndex();
        magasinTable.getItems().remove(selectedIndex);
    }


    public boolean showMagasinEditDialog(Magasin magasin) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/EditMagasin.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Magasin");
            dialogStage.initModality(Modality.WINDOW_MODAL);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            EditMagasinController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMagasin(magasin);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @FXML
    private void handleNewMagasin() {
        Magasin tempMagasin = new Magasin();
        boolean okClicked = this.showMagasinEditDialog(tempMagasin);
        if (okClicked) {
            MagasinController.getMagasinsData().add(tempMagasin);
        }
    }
    @FXML
    private void handleEditMagasin() {
        Magasin selectedMagasin = this.magasinTable.getSelectionModel().getSelectedItem();
        if (selectedMagasin != null) {
            boolean okClicked = this.showMagasinEditDialog(selectedMagasin);
            if (okClicked) {
                showMagasinDetail(selectedMagasin);
            }
        }
    }

}
