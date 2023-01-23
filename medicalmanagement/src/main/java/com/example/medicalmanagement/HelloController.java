package com.example.medicalmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    @FXML
    private Button cancelbutton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private Button loginbutton;

    @FXML
    private PasswordField passwordpasswordfield;

    @FXML
    private TextField usernametextfield;



    public void loginbuttonOnAction(ActionEvent e) {
        if (usernametextfield.getText().isBlank() == false && passwordpasswordfield.getText().isBlank() == false) {
            //loginMessageLabel.setText("You try to login!");
            validateLogin();

        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void cancelbuttonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();

    }

    public void validateLogin() {
        Databaseconnection connectNow = new Databaseconnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM UserAccounts WHERE username = '" + usernametextfield.getText() + "' AND password = '" + passwordpasswordfield.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    // loginMessageLabel.setText("Welcome!");
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("medicines.fxml"));
                    Stage window = (Stage) loginbutton.getScene().getWindow();
                    window.setScene(new Scene(fxmlLoader.load(),600,400));

                } else {
                    loginMessageLabel.setText("Invalid Login. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


