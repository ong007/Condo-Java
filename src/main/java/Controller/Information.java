package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Information {


    @FXML public void BackBtnOnAction(ActionEvent event) throws IOException {
        javafx.scene.control.Button a = (javafx.scene.control.Button) event.getSource();
        Stage stage_Back = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage.fxml"));
        stage_Back.setScene(new Scene(loader.load(), 882, 390));
        stage_Back.show();
    }

    @FXML public void AdminInfoBtnOnAction(ActionEvent event) throws IOException {
        javafx.scene.control.Button a = (javafx.scene.control.Button) event.getSource();
        Stage stage_Admin = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdminInfo.fxml"));
        stage_Admin.setScene(new Scene(loader.load(), 882, 390));
        stage_Admin.show();
    }

    @FXML public void OfficeInfoBtnOnAction(ActionEvent event) throws IOException {
        javafx.scene.control.Button a = (javafx.scene.control.Button) event.getSource();
        Stage stage_officer = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CentralInfo.fxml"));
        stage_officer.setScene(new Scene(loader.load(), 882, 390));
        stage_officer.show();
    }

    @FXML public void CustomerInfoBtnOnAction(ActionEvent event) throws IOException {
        javafx.scene.control.Button a = (javafx.scene.control.Button) event.getSource();
        Stage stage_Customer = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CustomerInfo.fxml"));
        stage_Customer.setScene(new Scene(loader.load(), 882, 390));
        stage_Customer.show();
    }


}
