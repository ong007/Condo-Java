import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Createroom {
    @FXML ComboBox<String> buildbox,typebox,floorbox;
    @FXML TextField roombtn;
    @FXML Button createnewroombtn,backcreateroombtn;

    public void initialize (){
        buildbox.getItems().addAll("A","B");
        typebox.getItems().addAll("STANDARD","LUXURY");
        floorbox.getItems().addAll("1","2","3","4","5","6","7","8");
    }

    @FXML public void backcreateroombtn(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backCreateRoom = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Centralhome.fxml"));
        stage_backCreateRoom.setScene(new Scene(loader.load(), 882, 390));
        stage_backCreateRoom.show();}
}

