package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Centealhome {
    @FXML Button Newmessengerbtn,Homecentralhomebtn,Newconsumerbtn;

    @FXML public void NewMessengerBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_newmessage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
        stage_newmessage.setScene(new Scene(loader.load(), 882, 390));
        stage_newmessage.show();}


    @FXML public void HomeCentralHomeBtnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_newmessage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage.fxml"));
        stage_newmessage.setScene(new Scene(loader.load(), 882, 390));
        stage_newmessage.show();}

    @FXML public void NewConSumerBtnOnAcTion(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_newconsumer= (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Newconsumer.fxml"));
        stage_newconsumer.setScene(new Scene(loader.load(), 882, 390));
        stage_newconsumer.show();}

    @FXML public void Newroomconsumerbtnonaction(ActionEvent event) throws IOException {
        Button d = (Button) event.getSource();
        Stage stage_room = (Stage) d.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Room.fxml"));
        stage_room.setScene(new Scene(loader.load(), 882, 390));
        stage_room.show();
    }

}
