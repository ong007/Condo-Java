import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Useradmin {
    @FXML Button Newusercentralbtn,backuseradminbtn;

    @FXML public void NewUserCentralBtnOnAction(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_newuseradmin = (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Newuseradmin.fxml"));
        stage_newuseradmin.setScene(new Scene(loader.load(), 882, 390));
        stage_newuseradmin.show();
    }
    @FXML public void BackUserAdminBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backuseradmin = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListAdmin.fxml"));
        stage_backuseradmin.setScene(new Scene(loader.load(), 882, 390));
        stage_backuseradmin.show();}

}

