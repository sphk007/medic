package com.example.medicalmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class medicinesController {

    @FXML
    private Button paracetamol;

    @FXML
    void paraOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("product.fxml"));
        Stage window = (Stage) paracetamol.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),600,400));

    }

}
