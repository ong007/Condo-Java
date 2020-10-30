package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfilePage {
    @FXML Button Backloginbtn ;

    @FXML public void BackLoginBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_ProfilePage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage.fxml"));
        stage_ProfilePage.setScene(new Scene(loader.load(), 882, 390));
        stage_ProfilePage.show();
    }
}
