import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ListAdmin {
    @FXML Button HomeAdminbtn,Useradminsystembtn,Timetableadminsystembtn;

    @FXML public void HomeAdminBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_ProfilePage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        stage_ProfilePage.setScene(new Scene(loader.load(), 882, 390));
        stage_ProfilePage.show();
    }
    @FXML public void UserAdminSystemBtnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_useradminsystem = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Useradmin.fxml"));
        stage_useradminsystem.setScene(new Scene(loader.load(), 882, 390));
        stage_useradminsystem.show();}

    @FXML public void TimetableAdminSystemBtnOnAction(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_Timetable = (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Timetable.fxml"));
        stage_Timetable.setScene(new Scene(loader.load(), 882, 390));
        stage_Timetable.show();}
    
}
