package Controller;

import Model.Centraluserreader;
import Model.Consumerreader;
import Service.CentralFileDataSource;
import Service.Consumerdatasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Newpasswordconsumer {
    private Consumerreader consumer;
    private Consumerdatasource consumerData;
    @FXML Button backbtn,submitbtn;
    @FXML TextField username;
    @FXML PasswordField password,newpassword;

    public void initialize(){
        consumer = new Consumerreader();
        consumerData = new Consumerdatasource("data","Consumerdata.csv");
        consumer = consumerData.getConsumerList();
    }

    @FXML public void backbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backconsumerhome = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ConsumerHome.fxml"));
        stage_backconsumerhome.setScene(new Scene(loader.load(), 882, 390));
        stage_backconsumerhome.show();
    }

    @FXML public void submitbtnonaction(ActionEvent event) throws IOException {
        if(username.getText().equals("") || password.getText().equals("") || newpassword.getText().equals("") ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please fill all information.");
            alert.showAndWait();}
        else{
            if (consumer.checkReceived(username.getText(),password.getText())){
                consumer.changePassword(username.getText(),password.getText(),newpassword.getText());
                consumerData.setConsumerList(consumer);
                Button b = (Button) event.getSource();
                Stage stage_submit = (Stage) b.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage.fxml"));
                stage_submit.setScene(new Scene(loader.load(), 882, 390));
                stage_submit.show();
            }
            else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("INCORRECT USERNAME OR PASSWORD");
            alert.showAndWait();
            }
        }
    }
}
