import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Timetable {
    @FXML
    Button Backtimetablebtn;


    @FXML
    public void BackTimeTaBleBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_Backtimetable = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListAdmin.fxml"));
        stage_Backtimetable.setScene(new Scene(loader.load(), 882, 390));
        stage_Backtimetable.show();
    }
}

