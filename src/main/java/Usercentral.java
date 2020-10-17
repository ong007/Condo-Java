import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Usercentral {
    @FXML Button Backusercentralbtn;

    @FXML public void BackUserCentralBtnOnAcion(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backusercentral = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Useradmin.fxml"));
        stage_backusercentral.setScene(new Scene(loader.load(), 882, 390));
        stage_backusercentral.show();
    }
}
