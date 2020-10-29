package Controller;

import Model.Consumerreader;
import Model.Roomreader;
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

public class Createroom {
    private Roomdatasource roomdata;
    private Roomreader roomlist;
    @FXML ComboBox<String> buildbox,typebox,floorbox,roombtn;

    @FXML Button createnewroombtn,backcreateroombtn;

    public void initialize (){
        buildbox.getItems().addAll("A","B");
        typebox.getItems().addAll("STANDARD","LUXURY");
        floorbox.getItems().addAll("1","2","3","4","5","6","7","8");
        roombtn.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        roomlist = new Roomreader();
        roomdata = new Roomdatasource("data","createroom.csv");
        roomlist = roomdata.getRoomlist();
    }

    @FXML public void backcreateroombtn(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backCreateRoom = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_backCreateRoom.setScene(new Scene(loader.load(), 882, 390));
        stage_backCreateRoom.show();}

    @FXML public void createnewroombtnonaction (ActionEvent event) throws IOException{
        String roomNum = buildbox.getValue() + floorbox.getValue() + roombtn.getValue();
        Roomreader room = new Roomreader(buildbox.getValue(),typebox.getValue(),floorbox.getValue(),roombtn.getValue(),"",typebox.getValue().equals("STANDARD") ? 2:3,typebox.getValue().equals("STANDARD") ? 2:3);
        if(buildbox.getValue() == null || typebox.getValue() == null || floorbox.getValue() == null || roombtn.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please fill all information.");
            alert.showAndWait();}
        else{
            if(roomlist.checkAddRoom(roomNum)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("");
            alert.setTitle("FULL");
            alert.setContentText("Can't reserve a room");
            alert.showAndWait();
            }else {
            roomlist.add(room);
            roomdata.setRoomlist(roomlist);
            Button b = (Button) event.getSource();
            Stage stage_createroom = (Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
            stage_createroom.setScene(new Scene(loader.load(), 882, 390));
            stage_createroom.show();
        }}
    }
}

