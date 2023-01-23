package com.example.medicalmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class purchaseController {

    @FXML
    private Button backtoproduct;

    @FXML
    private TextField customerage;

    @FXML
    private TextField customeremail;

    @FXML
    private TextField customername;

    @FXML
    private TextField customerphone;

    @FXML
    private TextField medicinename;

    @FXML
    private Label messageaftersubmit;

    @FXML
    private Button submit;

    Connection con;
    PreparedStatement pst;

    @FXML
    void backOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("product.fxml"));
        Stage window = (Stage) backtoproduct.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(),600,400));

    }

    @FXML
    void submitOnAction(ActionEvent event) {
        String  name= customername.getText();
        String email = customeremail.getText();
        String age = customerage.getText();
        String phoneno = customerphone.getText();
        String medicine = medicinename.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javamedical","root","850885@nithish");

            pst = con.prepareStatement("insert into buy(name,email,age,phoneno,medicine)values(?,?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2,email);
            pst.setString(3,age);
            pst.setString(4,phoneno);
            pst.setString(5,medicine);
            int status=pst.executeUpdate();

            if (status==1){
                System.out.println("record added");
                customername.setText("");
                customeremail.setText("");
                customerage.setText("");
                customerphone.setText("");
                medicinename.setText("");
                //messageaftersubmit.setText("request submitted");

            }else {
                System.out.println("record failed");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }


