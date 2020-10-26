package Controller;

import Model.Centraluserreader;
import Model.Consumerreader;
import Model.Roomreader;
import Service.CentralFileDataSource;
import Service.Consumerdatasource;
import Service.Roomdatasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Newconsumer {
    private Consumerdatasource consumerdata;
    private Consumerreader consumerlist;
    private Centraluserreader centrallist;
    private CentralFileDataSource centraldata;
    private Roomreader roomlist;
    private Roomdatasource roomdata;
    @FXML Button backnewconsumerbtn, summitnewconsumerbtn;
    @FXML TextField nameconsumerbtn, surnameconsumerbtn, Newuserconsumerbtn, Newpasswordconsumerbtn, Newconfirmpasswordconsumerbtn;
    @FXML ComboBox<String> roomconsumerbtn;


    public void initialize(){
        consumerlist = new Consumerreader();
        consumerdata = new Consumerdatasource("data","Consumerdata.csv");
        consumerlist = consumerdata.getConsumerList();
        roomdata = new Roomdatasource("data","createroom.csv");
        roomlist = roomdata.getRoomlist();
        centraldata = new CentralFileDataSource("data","Centraldata.csv");
        centrallist = centraldata.getCentralList();
        for (Roomreader room1: roomlist.getUserList()){
            if(room1.getNowarrival() > 0) {
                roomconsumerbtn.getItems().add(room1.getBuilding() + room1.getFloor() + room1.getRoom() + " : " + room1.getType());
            }

        }


    }

    public void backnewconsumerbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backcentral = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_backcentral.setScene(new Scene(loader.load(), 882, 390));
        stage_backcentral.show();
    }

    @FXML public void summitnewconsumerbtnonaction(ActionEvent event) throws IOException {
        if(nameconsumerbtn.getText().equals("") || surnameconsumerbtn.getText().equals("") || Newuserconsumerbtn.getText().equals("") || Newpasswordconsumerbtn.getText().equals("") || Newconfirmpasswordconsumerbtn.getText().equals("") || roomconsumerbtn.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please filling all information.");
            alert.showAndWait();}
        else{
            if (Newpasswordconsumerbtn.getText().equals(Newconfirmpasswordconsumerbtn.getText()) && consumerlist.checkUser(Newuserconsumerbtn.getText(),centrallist) ) {
                //centraldata = new Service.CentralFileDataSource("data", "Service.Centraldata.csv");
                //centralList = centraldata.getCentralList();
                Consumerreader consumer = new Consumerreader(nameconsumerbtn.getText(),surnameconsumerbtn.getText(),roomconsumerbtn.getValue(),"","",roomconsumerbtn.getValue(),Newuserconsumerbtn.getText(),Newpasswordconsumerbtn.getText());
                String[] roomNum = roomconsumerbtn.getValue().split(" : ");
                consumerlist.add(consumer);
                roomlist.setMaxRoom(roomNum[0]);
                consumerdata.setConsumerList(consumerlist);
                roomdata.setRoomlist(roomlist);
                Button a = (Button) event.getSource();
                Stage stage_summitconsumer = (Stage) a.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
                stage_summitconsumer.setScene(new Scene(loader.load(), 882, 390));
                stage_summitconsumer.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Wrong password");
                alert.setContentText("INCORRECT USERNAME OR password");
                alert.showAndWait();
        }}
    }
}
