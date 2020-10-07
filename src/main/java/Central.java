import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Central {
    @FXML Button Homecentralbtn;

    @FXML public void HomeCentralBtnOnAction(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_HomeCentralPage = (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        stage_HomeCentralPage.setScene(new Scene(loader.load(), 882, 390));
        stage_HomeCentralPage.show();
    }
}
