package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Newpasswordcentral {
    @FXML Button backnewpasswordcentralbtn,submitnewpasswordcentralbtn;

    @FXML public void backnewpasswordcentralbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_back = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_back.setScene(new Scene(loader.load(), 882, 390));
        stage_back.show();}

    @FXML public void submitnewpasswordcentralbtnonaction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_submit = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_submit.setScene(new Scene(loader.load(), 882, 390));
        stage_submit.show();}
}
