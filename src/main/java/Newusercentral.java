import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class Newusercentral {
    private CentralFileDataSource centraldata;
    private Centraluserreader centralList;
    @FXML TextField Newuseradminbtn;
    @FXML PasswordField Newpasswordadminbtn,Newconfirmpasswordadminbtn;
    @FXML
    public void summitonaction(ActionEvent event) throws IOException {
        centraldata = new CentralFileDataSource("data","Centraldata.csv");
        centralList = centraldata.getCentralList();
        Centraldata central = new Centraldata(Newuseradminbtn.getText(),Newpasswordadminbtn.getText());
        centralList.add(central);
        centraldata.setCentralList(centralList);
        Button a = (Button) event.getSource();
        Stage stage_backuseradmin = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Useradmin.fxml"));
        stage_backuseradmin.setScene(new Scene(loader.load(), 882, 390));
        stage_backuseradmin.show();
    }

}
