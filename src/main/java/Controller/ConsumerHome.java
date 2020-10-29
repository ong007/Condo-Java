package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ConsumerHome {
    @FXML Button homebtn,newpasswordbtn;

    @FXML public void homebtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backhome = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage.fxml"));
        stage_backhome.setScene(new Scene(loader.load(), 882, 390));
        stage_backhome.show();}

    @FXML public void newpasswordbtnonaction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_newpassword = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Newpasswordconsumer.fxml"));
        stage_newpassword.setScene(new Scene(loader.load(), 882, 390));
        stage_newpassword.show();}
}
