package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by Pierre on 03/03/2017.
 */
public class EmailController {

    @FXML
    private TextField emailField;
    @FXML
    private TextArea textField;

    public void sendEmail(){
        String email ="Email : "+emailField.getText() +"\n" + "Contenu : "+ textField.getText();
        System.out.println(email);
    }

}
