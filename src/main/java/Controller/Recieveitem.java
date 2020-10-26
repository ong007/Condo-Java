package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Recieveitem {
    @FXML Button okrecievebtn,backrecievebtn;
    @FXML TextField searchrecievebtn,namerecievebtn,surnamerecievebtn,officerecievebtn;


    @FXML public void backrecievebtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backrecieve = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomeCheckMessage.fxml"));
        stage_backrecieve.setScene(new Scene(loader.load(), 882, 390));
        stage_backrecieve.show();
    }
}
