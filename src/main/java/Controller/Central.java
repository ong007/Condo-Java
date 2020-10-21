package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Central {
    @FXML Button Backcentralmessagebtn,Textbtn,Mailbtn,Boxbtn;

    @FXML public void BackCentralMessageBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_BackhomeCentralPage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_BackhomeCentralPage.setScene(new Scene(loader.load(), 882, 390));
        stage_BackhomeCentralPage.show();}

    @FXML public void TextBtnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_Text = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Text.fxml"));
        stage_Text.setScene(new Scene(loader.load(), 882, 390));
        stage_Text.show();}

    @FXML public void MailBtnOnAction(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_Mail = (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mail.fxml"));
        stage_Mail.setScene(new Scene(loader.load(), 882, 390));
        stage_Mail.show();}

    @FXML public void BoxBtnOnAction(ActionEvent event) throws IOException {
        Button d = (Button) event.getSource();
        Stage stage_Box = (Stage) d.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Box.fxml"));
        stage_Box.setScene(new Scene(loader.load(), 882, 390));
        stage_Box.show();}


}
