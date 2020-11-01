package Controller;

import Model.CentralOfficer;
import Service.CentralOfficerData;
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

public class NewPasswordCentral {
    private CentralOfficer central;
    private CentralOfficerData centralData;
    @FXML Button backnewpasswordcentralbtn,submitnewpasswordcentralbtn;
    @FXML
    TextField usernamenewcentralbtn;
    @FXML
    PasswordField passwordnewcentralbtn,newpasswordnewcentral;
    public void initialize(){
        central = new CentralOfficer();
        centralData = new CentralOfficerData("data","CentralOfficer.csv");
        central = centralData.getCentralList();
    }
    @FXML public void backnewpasswordcentralbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_back = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CentralHome.fxml"));
        stage_back.setScene(new Scene(loader.load(), 882, 390));
        stage_back.show();}

    @FXML public void submitnewpasswordcentralbtnonaction(ActionEvent event) throws IOException {
        if(usernamenewcentralbtn.getText().equals("") || passwordnewcentralbtn.getText().equals("") || newpasswordnewcentral.getText().equals("") ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please fill all information.");
            alert.showAndWait();}
        else{
            if (central.checkPassword(usernamenewcentralbtn.getText(),passwordnewcentralbtn.getText())){
                central.changePassword(usernamenewcentralbtn.getText(),passwordnewcentralbtn.getText(),newpasswordnewcentral.getText());
                centralData.setCentralList(central);
                Button b = (Button) event.getSource();
                Stage stage_submit = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage.fxml"));
                stage_submit.setScene(new Scene(loader.load(), 882, 390));
                stage_submit.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setContentText("INCORRECT USERNAME OR PASSWORD");
                alert.showAndWait();
            }
        }
//        central.changePassword(usernamenewcentralbtn.getText(),passwordnewcentralbtn.getText(),newpasswordnewcentral.getText());
//        centralData.setCentralList(central);
//        Button b = (Button) event.getSource();
//        Stage stage_submit = (Stage) b.getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CentralHome.fxml"));
//        stage_submit.setScene(new Scene(loader.load(), 882, 390));
//        stage_submit.show();
    }
}
