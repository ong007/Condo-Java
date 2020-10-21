package Controller;

import Model.Centraluserreader;
import Service.CentralFileDataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;


public class Newusercentral {
    private CentralFileDataSource centraldata;
    private Centraluserreader centralList;
    @FXML
    TextField Newuseradminbtn,nameuserbtn,surnameuserbtn,teluserbtn,emailuserbtn;
    @FXML
    PasswordField Newpasswordadminbtn, Newconfirmpasswordadminbtn;
    @FXML
    Button backcentralbtn;
    public void initialize(){
        centralList = new Centraluserreader();
        centraldata = new CentralFileDataSource("data","Centraldata.csv");
        centralList = centraldata.getCentralList();
    }
    public void summitonaction(ActionEvent event) throws IOException {
        if (Newpasswordadminbtn.getText().equals(Newconfirmpasswordadminbtn.getText()) && centralList.checkUser(Newuseradminbtn.getText())) {
            //centraldata = new Service.CentralFileDataSource("data", "Service.Centraldata.csv");
            //centralList = centraldata.getCentralList();
            Centraluserreader central = new Centraluserreader(nameuserbtn.getText(), surnameuserbtn.getText(), teluserbtn.getText(), emailuserbtn.getText(), Newuseradminbtn.getText(), Newpasswordadminbtn.getText(), "-","Access",0);
            centralList.add(central);
            centraldata.setCentralList(centralList);
            Button a = (Button) event.getSource();
            Stage stage_backuseradmin = (Stage) a.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ListAdmin.fxml"));
            stage_backuseradmin.setScene(new Scene(loader.load(), 882, 390));
            stage_backuseradmin.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong password");
            alert.setContentText("Cannot add");
            alert.showAndWait();
        }


    }
    @FXML public void BackCentralBtnOnAction (ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_backcentral = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ListAdmin.fxml"));
        stage_backcentral.setScene(new Scene(loader.load(), 882, 390));
        stage_backcentral.show();
    }
}
