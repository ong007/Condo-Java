package Controller;

import Model.Consumerreader;
import Service.Consumerdatasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Newconsumer {
    private Consumerdatasource consumerdata;
    private Consumerreader consumerlist;
    @FXML Button backnewconsumerbtn, summitnewconsumerbtn;
    @FXML TextField nameconsumerbtn, surnameconsumerbtn, Newuserconsumerbtn, Newpasswordconsumerbtn, Newconfirmpasswordconsumerbtn,floorconsumerbtn,roomconsumerbtn;


    public void initialize(){
        consumerlist = new Consumerreader();
        consumerdata = new Consumerdatasource("data","Consumerdata.csv");
        consumerlist = consumerdata.getConsumerList();
    }

    public void backnewconsumerbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backcentral = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_backcentral.setScene(new Scene(loader.load(), 882, 390));
        stage_backcentral.show();
    }

    public void summitnewconsumerbtnonaction(ActionEvent event) throws IOException {
        if (Newpasswordconsumerbtn.getText().equals(Newconfirmpasswordconsumerbtn.getText())) {
            //centraldata = new Service.CentralFileDataSource("data", "Service.Centraldata.csv");
            //centralList = centraldata.getCentralList();
            Consumerreader consumer = new Consumerreader(nameconsumerbtn.getText(),surnameconsumerbtn.getText(),roomconsumerbtn.getText(),floorconsumerbtn.getText(), Newuserconsumerbtn.getText(),Newpasswordconsumerbtn.getText());
            consumerlist.add(consumer);
            consumerdata.setConsumerList(consumerlist);
            Button a = (Button) event.getSource();
            Stage stage_summitconsumer = (Stage) a.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
            stage_summitconsumer.setScene(new Scene(loader.load(), 882, 390));
            stage_summitconsumer.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong password");
            alert.setContentText("Please input your password again");
            alert.showAndWait();
        }
    }
}
