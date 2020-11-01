package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class CustomerInfo {
    @FXML
    Button BackBtn;

    @FXML public void BackBtnOnAction(ActionEvent event) throws IOException {
        javafx.scene.control.Button a = (javafx.scene.control.Button) event.getSource();
        Stage stage_Back = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Information.fxml"));
        stage_Back.setScene(new Scene(loader.load(), 882, 390));
        stage_Back.show();
    }
}
