package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Text  {

    @FXML TextField sizetextbtn,nametextbtn,roomtextbtn,floortextbtn,companytextbtn,hourtextbtn,minutetextbtn,sendertextbtn;
    @FXML Button Backtextbtn,Summittextbtn;

    @FXML public void BackTextBtnOnAcTion(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_Backtext = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
        stage_Backtext.setScene(new Scene(loader.load(), 882, 390));
        stage_Backtext.show();}
}
