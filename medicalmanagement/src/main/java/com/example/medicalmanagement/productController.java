package com.example.medicalmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class productController {

    @FXML
    private Button buy;

    @FXML
    void buyOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("purchase.fxml"));
        Stage window = (Stage) buy.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),600,400));
    }

}
