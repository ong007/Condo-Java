package Controller;


import Model.Centraluserreader;
import Model.Consumerreader;
import Service.CentralFileDataSource;
import Service.Consumerdatasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Homepage {

    @FXML  Button LoginHomepagebtn,Profilebtn,Adminbtn,Centralbtn;
    @FXML  TextField Userhomepagebtn;
    @FXML  PasswordField Passwordhomepagebtn;
    private Consumerdatasource consumerdata;
    private Consumerreader consumerlist;

    public void initialize(){
        consumerlist = new Consumerreader();
        consumerdata = new Consumerdatasource("data","Consumerdata.csv");
        consumerlist = consumerdata .getConsumerList();
    }

    @FXML public void ProfileBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_ProfilePage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Profilepage.fxml"));
        stage_ProfilePage.setScene(new Scene(loader.load(), 882, 390));
        stage_ProfilePage.show();}

    @FXML public void AdminBtnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_AdminPage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginAdmin.fxml"));
        stage_AdminPage.setScene(new Scene(loader.load(), 882, 390));
        stage_AdminPage.show();}

    @FXML public void Centralbtnonaction(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_CentralloginPage = (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Logincentral.fxml"));
        stage_CentralloginPage.setScene(new Scene(loader.load(), 882, 390));
        stage_CentralloginPage.show();}

    @FXML public void LoginHomepagebtnonaction(ActionEvent event) throws IOException {
        if(consumerlist.checkReceived(Userhomepagebtn.getText(),Passwordhomepagebtn.getText())) {
            consumerdata.setConsumerList(consumerlist);;
            Button d = (Button) event.getSource();
            Stage stage_consumerlogin = (Stage) d.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ConsumerHome.fxml"));
            stage_consumerlogin.setScene(new Scene(loader.load(), 882, 390));
            stage_consumerlogin.show();
        }


        }

}
