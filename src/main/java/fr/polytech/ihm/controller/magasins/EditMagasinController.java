package fr.polytech.ihm.controller.magasins;
import fr.polytech.ihm.model.magasin.Magasin;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Pierre on 12/03/2017.
 */
public class EditMagasinController {




        @FXML
        private TextField magasinField;
        @FXML
        private TextField adresseField;
        @FXML
        private TextField villeField;
        @FXML
        private TextField postalCodeField;
        @FXML
        private TextField telephoneField;
        @FXML
        private TextField emailField;


        private Stage dialogStage;
        private Magasin magasin;
        private boolean okClicked = false;


        @FXML
        private void initialize() {
        }


        public void setDialogStage(Stage dialogStage) {
            this.dialogStage = dialogStage;
        }

        /**
         * Sets the person to be edited in the dialog.
         *
         * @param magasin
         */
        public void setMagasin(Magasin magasin) {
            this.magasin = magasin;

            magasinField.setText(magasin.getMagasin());
            adresseField.setText(magasin.getAdresse());
            villeField.setText(magasin.getVille());
            postalCodeField.setText(Integer.toString(magasin.getCodePostal()));
            telephoneField.setText(Integer.toString(magasin.getTelephone()));
            emailField.setText(magasin.getEmail());
        }

        /**
         * Returns true if the user clicked OK, false otherwise.
         *
         * @return
         */
        public boolean isOkClicked() {
            return okClicked;
        }

        /**
         * Called when the user clicks ok.
         */
        @FXML
        private void handleOk() {
            this.magasin.setMagasin(magasinField.getText());
            this.magasin.setAdresse(adresseField.getText());
            this.magasin.setVille(villeField.getText());
            this.magasin.setCodePostal(Integer.parseInt(postalCodeField.getText()));
            this.magasin.setTelephone(Integer.parseInt(telephoneField.getText()));
            this.magasin.setEmail(emailField.getText());

                okClicked = true;
                dialogStage.close();
        }


        /**
         * Called when the user clicks cancel.
         */
        @FXML
        private void handleCancel() {
            dialogStage.close();
        }

    }
