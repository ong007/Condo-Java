package Controller;


import Model.BucketCustomer;
import Model.CustomerReader;
import Service.CustomerData;
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


public class Homepage {

    @FXML  Button LoginHomepagebtn,Profilebtn,Adminbtn,Centralbtn,InformationBtn;
    @FXML  TextField Userhomepagebtn;
    @FXML  PasswordField Passwordhomepagebtn;
    private CustomerData consumerdata;
    private BucketCustomer consumerlist;
    private CustomerReader consumer;


    public void initialize(){
        consumerlist = new BucketCustomer();
        consumerdata = new CustomerData("data","Customer.csv");
        consumerlist = consumerdata .getConsumerList();
    }

    @FXML public void ProfileBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_ProfilePage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProfilePage.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginCentral.fxml"));
        stage_CentralloginPage.setScene(new Scene(loader.load(), 882, 390));
        stage_CentralloginPage.show();}

    @FXML public void InformationBtnOnAction(ActionEvent event) throws IOException {
        Button d = (Button) event.getSource();
        Stage stage_Information = (Stage) d.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Information.fxml"));
        stage_Information.setScene(new Scene(loader.load(), 882, 390));
        stage_Information.show();}

    @FXML public void LoginHomepagebtnonaction(ActionEvent event) throws IOException {
        if(Userhomepagebtn.getText().equals("") || Passwordhomepagebtn.getText().equals("") ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please fill all information.");
            alert.showAndWait();}
        else{
            if (consumerlist.checkReceived(Userhomepagebtn.getText(),Passwordhomepagebtn.getText())){
                consumer = consumerlist.getAcc(Userhomepagebtn.getText());
                consumerdata.setConsumerList(consumerlist);;
                Button e = (Button) event.getSource();
                Stage stage_consumerlogin = (Stage) e.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/CustomerHome.fxml"));
                stage_consumerlogin.setScene(new Scene(loader.load(), 882, 390));
                CustomerHome home = loader.getController();
                home.setConsumer(consumer);
                stage_consumerlogin.show();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setContentText("INCORRECT USERNAME OR PASSWORD");
                alert.showAndWait();
            }
        }
    }

}
