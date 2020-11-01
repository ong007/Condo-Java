package Controller;

import Model.CustomerReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerHome {
    @FXML Button homebtn,newpasswordbtn,checkstockbtn,checkreceivebtn;
    private CustomerReader consumer;

    public void setConsumer(CustomerReader consumer){
        this.consumer = consumer;
    }

    @FXML public void homebtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backhome = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage.fxml"));
        stage_backhome.setScene(new Scene(loader.load(), 882, 390));
        stage_backhome.show();}

    @FXML public void newpasswordbtnonaction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_newpassword = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewPasswordCustomer.fxml"));
        stage_newpassword.setScene(new Scene(loader.load(), 882, 390));
        stage_newpassword.show();}

    @FXML public void checkstockbtnonaction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_stock = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StockCustomer.fxml"));
        stage_stock.setScene(new Scene(loader.load(), 882, 390));
        StockCustomer stockCustomer = loader.getController();
        stockCustomer.setConsumer(consumer);
        stage_stock.show();}

    @FXML public void checkreceivebtnonaction(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_recieve = (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ReceiveConsumer.fxml"));
        stage_recieve.setScene(new Scene(loader.load(), 882, 390));
        ReceiveConsumer receiveConsumer = loader.getController();
        receiveConsumer.setConsumer(consumer);
        stage_recieve.show();}
}
