package com.example.medicalmanagement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Databaseconnection {
    public Connection databaselink;
    public Connection getConnection(){
        String databaseName = "javamedical";
        String databaseUser = "root";
        String databasePassword = "850885@nithish";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url,databaseUser, databasePassword);

        }catch (Exception e){
            e.printStackTrace();
        }
        return databaselink;
    }
}
