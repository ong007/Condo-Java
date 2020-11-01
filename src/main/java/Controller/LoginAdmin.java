package Controller;

import Model.SetPasswordAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginAdmin {

    private SetPasswordAdmin a;
    @FXML Button Homeloginadminbtn,LoginAdmin;
    @FXML TextField UserAdminbtn;
    @FXML PasswordField PasswordAdminbtn;

    @FXML public void initialize(){
        a = new SetPasswordAdmin();
    }


    @FXML public void HomeLoginAdminBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_HomeAdminloginPage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage.fxml"));
        stage_HomeAdminloginPage.setScene(new Scene(loader.load(), 882, 390));
        stage_HomeAdminloginPage.show();
    }
    @FXML public void LoginAdminBtnOnAction(ActionEvent event) throws IOException {
        if(a.check(UserAdminbtn.getText(), PasswordAdminbtn.getText())){
            Button b = (Button) event.getSource();
            Stage stage_AdminloginPage = (Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ListAdmin.fxml"));
            stage_AdminloginPage.setScene(new Scene(loader.load(), 882, 390));
            stage_AdminloginPage.show();
        }

    }


}
