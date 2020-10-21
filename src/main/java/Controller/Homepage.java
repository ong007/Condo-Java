package Controller;

import Model.Centraluserreader;
import Model.setpasswordC;
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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Homepage {
    private setpasswordC c;
    private CentralFileDataSource centraldata;
    private Centraluserreader centralList, nowCentral;
    @FXML  Button Loginbtn,Profilebtn,Adminbtn;
    @FXML  TextField Userbtn;
    @FXML  PasswordField Passwordbtn;
    public void initialize(){
        centralList = new Centraluserreader();
        centraldata = new CentralFileDataSource("data","Centraldata.csv");
        centralList = centraldata.getCentralList();
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

    @FXML public void LoginBtnOnAction(ActionEvent event) throws IOException {
            if(centralList.checkPassword(Userbtn.getText(),Passwordbtn.getText()) && centralList.checkStatus(Userbtn.getText())) {

                nowCentral = centralList.getAcc(Userbtn.getText());
                String time = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
                nowCentral.setTime(time);
                centraldata.setCentralList(centralList);
                Button c = (Button) event.getSource();
                Stage stage_CentralloginPage = (Stage) c.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
                stage_CentralloginPage.setScene(new Scene(loader.load(), 882, 390));
                stage_CentralloginPage.show();
            }
            else if (!centralList.checkStatus(Userbtn.getText())){
                centralList.getAcc(Userbtn.getText()).setAttempt(centralList.getAcc(Userbtn.getText()).getAttempt()+1);
                centraldata.setCentralList(centralList);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("");
                alert.setTitle("Please contact admin");
                alert.setContentText("Your user has been ban");
                alert.showAndWait();

            }


    }

}
