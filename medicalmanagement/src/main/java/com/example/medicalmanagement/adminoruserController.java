package com.example.medicalmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class adminoruserController {

    @FXML
    private Button loginbutton;

    @FXML
    private Button loginbutton1;

    @FXML
    void loginbutton1OnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Stage window = (Stage) loginbutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),600,400));

    }

    @FXML
    void loginbuttonOnAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Stage window = (Stage) loginbutton1.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),600,400));

    }

}
