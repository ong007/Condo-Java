package Controller;

import Model.*;
import Model.Room;
import Service.CentralOfficerData;
import Service.CustomerData;
import Service.RoomData;
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

public class NewCustomer {
    private CustomerData consumerdata;
    private BucketCustomer consumerlist;
    private BucketCentralOfficer centrallist;
    private CentralOfficerData centraldata;
    private BucketRoom roomlist;
    private RoomData roomdata;
    @FXML Button backnewconsumerbtn, summitnewconsumerbtn;
    @FXML TextField nameconsumerbtn, surnameconsumerbtn, Newuserconsumerbtn, Newpasswordconsumerbtn, Newconfirmpasswordconsumerbtn;
    @FXML ComboBox<String> roomconsumerbtn;


    public void initialize(){
        consumerlist = new BucketCustomer();
        consumerdata = new CustomerData("data","Customer.csv");
        consumerlist = consumerdata.getConsumerList();
        roomdata = new RoomData("data","Room.csv");
        roomlist = roomdata.getRoomlist();
        centraldata = new CentralOfficerData("data","CentralOfficer.csv");
        centrallist = centraldata.getCentralList();
        for (Room room1: roomlist.getBucketRoom()){
            if(room1.getNowarrival() > 0) {
                roomconsumerbtn.getItems().add(room1.getBuilding() + room1.getFloor() + room1.getRoom() + " : " + room1.getType());
            }
        }
    }

    @FXML public void backnewconsumerbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backcentral = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CentralHome.fxml"));
        stage_backcentral.setScene(new Scene(loader.load(), 882, 390));
        stage_backcentral.show();
    }

    @FXML public void summitnewconsumerbtnonaction(ActionEvent event) throws IOException {
        if(nameconsumerbtn.getText().equals("") || surnameconsumerbtn.getText().equals("") || Newuserconsumerbtn.getText().equals("") || Newpasswordconsumerbtn.getText().equals("") || Newconfirmpasswordconsumerbtn.getText().equals("") || roomconsumerbtn.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please fill all information.");
            alert.showAndWait();}
        else{
            if (Newpasswordconsumerbtn.getText().equals(Newconfirmpasswordconsumerbtn.getText()) && consumerlist.checkUser(Newuserconsumerbtn.getText(),centrallist) ) {

                CustomerReader consumer = new CustomerReader(nameconsumerbtn.getText(),surnameconsumerbtn.getText(),roomconsumerbtn.getValue(),"","",roomconsumerbtn.getValue(),Newuserconsumerbtn.getText(),Newpasswordconsumerbtn.getText());
                String[] roomNum = roomconsumerbtn.getValue().split(" : ");
                consumerlist.add(consumer);
                roomlist.setMaxRoom(roomNum[0]);
                consumerdata.setConsumerList(consumerlist);
                roomdata.setRoomlist(roomlist);
                Button a = (Button) event.getSource();
                Stage stage_summitconsumer = (Stage) a.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/CentralHome.fxml"));
                stage_summitconsumer.setScene(new Scene(loader.load(), 882, 390));
                stage_summitconsumer.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Wrong password");
                alert.setContentText("INCORRECT USERNAME OR password");
                alert.showAndWait();
            }
        }
    }
}
