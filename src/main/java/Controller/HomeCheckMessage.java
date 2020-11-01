package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeCheckMessage {
    @FXML Button stockcheckitembtn,recievecheckitembtn,backcheckitembtn;


    @FXML public void backcheckitembtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backcheckitem = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
        stage_backcheckitem.setScene(new Scene(loader.load(), 882, 390));
        stage_backcheckitem.show();}

    @FXML public void stockcheckitembtnonaction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_stock = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StockItem.fxml"));
        stage_stock.setScene(new Scene(loader.load(), 882, 390));

        stage_stock.show();}

    @FXML public void recievecheckitembtnonaction(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_recieve = (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ReceiveItem.fxml"));
        stage_recieve.setScene(new Scene(loader.load(), 882, 390));

        stage_recieve.show();}

    @FXML public void checkreceivebtnonaction(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_recieve = (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ReceiveItem.fxml"));
        stage_recieve.setScene(new Scene(loader.load(), 882, 390));

        stage_recieve.show();}
}
