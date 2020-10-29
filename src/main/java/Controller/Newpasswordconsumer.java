package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Newpasswordconsumer {
    @FXML Button backbtn,submitbtn;

    @FXML public void backbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backconsumerhome = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ConsumerHome.fxml"));
        stage_backconsumerhome.setScene(new Scene(loader.load(), 882, 390));
        stage_backconsumerhome.show();
    }
}
