package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Room {
    @FXML Button createroombtn,backroombtn,checkroombtn;

    @FXML public void backroombtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backroom = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_backroom.setScene(new Scene(loader.load(), 882, 390));
        stage_backroom.show();
    }
    @FXML public void createroombtnonaction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_createroom = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Createroom.fxml"));
        stage_createroom.setScene(new Scene(loader.load(), 882, 390));
        stage_createroom.show();
    }

    @FXML public void checkroombtnonaction(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_checkroom = (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Listroom.fxml"));
        stage_checkroom.setScene(new Scene(loader.load(), 882, 390));
        stage_checkroom.show();
    }
}
