package Controller;

import Model.Centraluserreader;
import Service.CentralFileDataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Newpasswordcentral {
    private Centraluserreader central;
    private CentralFileDataSource centralData;
    @FXML Button backnewpasswordcentralbtn,submitnewpasswordcentralbtn;
    @FXML
    TextField usernamenewcentralbtn;
    @FXML
    PasswordField passwordnewcentralbtn,newpasswordnewcentral;
    public void initialize(){
        central = new Centraluserreader();
        centralData = new CentralFileDataSource("data","Centraldata.csv");
        central = centralData.getCentralList();
    }
    @FXML public void backnewpasswordcentralbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_back = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_back.setScene(new Scene(loader.load(), 882, 390));
        stage_back.show();}

    @FXML public void submitnewpasswordcentralbtnonaction(ActionEvent event) throws IOException {
        central.changePassword(usernamenewcentralbtn.getText(),passwordnewcentralbtn.getText(),newpasswordnewcentral.getText());
        centralData.setCentralList(central);
        Button b = (Button) event.getSource();
        Stage stage_submit = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_submit.setScene(new Scene(loader.load(), 882, 390));
        stage_submit.show();}
}
