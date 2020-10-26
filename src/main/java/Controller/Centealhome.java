package Controller;

import Model.Centraluserreader;
import Model.Consumerreader;

import Model.Roomreader;
import Service.Consumerdatasource;
import Service.Roomdatasource;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Centealhome {
    @FXML
    TableView<Consumerreader> table;
    @FXML Button Newmessengerbtn,Homecentralhomebtn,Newconsumerbtn,Removeconsumerbtn,Newpasswordcentralhomebtn;
    @FXML TextField nameconsumertext,surnamecomsumertext,usernameconsumertext,searchCentralhomebtn;
    private Consumerreader consumerreader,selectedCentral;
    private Consumerdatasource consumerdatasource;
    private ObservableList<Consumerreader> list;
    private Roomreader roomlist;
    private Roomdatasource roomdata;


    public void initialize(){
        Removeconsumerbtn.setDisable(true);
        consumerreader = new Consumerreader();
        consumerdatasource = new Consumerdatasource("data" , "Consumerdata.csv");
        consumerreader = consumerdatasource.getConsumerList();
        roomdata = new Roomdatasource("data","createroom.csv");
        roomlist = roomdata.getRoomlist();
     Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(!consumerreader.getUserList().isEmpty()){
                    showData("");
                }
            }
        });
        table.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null){
                showCentralData(newValue);
            }
        }));
    }


    @FXML public void RemoveconsumerbtnOnaction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation.");
        alert.setHeaderText("");
        alert.setContentText("Do you really want to remove this user?");
        Optional<ButtonType> confirmation = alert.showAndWait();
        if (confirmation.get() == ButtonType.OK) {

        String[] roomNum = selectedCentral.getRoomnum().split(" : ");
        roomlist.setRemoveRoom(roomNum[0]);
        consumerreader.removeConsumer(selectedCentral);
        consumerdatasource = new Consumerdatasource("data" , "Consumerdata.csv");
        roomdata = new Roomdatasource("data","createroom.csv");
        roomdata.setRoomlist(roomlist);
        consumerdatasource.setConsumerList(consumerreader);
        clearData();
        Button a = (Button) event.getSource();
        Stage stage_removeconsumer = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Centralhome.fxml"));
        stage_removeconsumer.setScene(new Scene(loader.load(), 882, 390));
        stage_removeconsumer.show();}}

    @FXML public void NewMessengerBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_newmessage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
        stage_newmessage.setScene(new Scene(loader.load(), 882, 390));
        stage_newmessage.show();}


    @FXML public void HomeCentralHomeBtnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_newmessage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Logincentral.fxml"));
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

    @FXML public void Newpasswordcentralhomebtnonaction(ActionEvent event) throws IOException {
        Button e = (Button) event.getSource();
        Stage stage_newpassword = (Stage) e.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Newpasswordcentral.fxml"));
        stage_newpassword.setScene(new Scene(loader.load(), 882, 390));
        stage_newpassword.show();
    }

    public void showData(String search){
        Consumerreader consumer = new Consumerreader();
        table.getColumns().clear();
        for (Consumerreader consumerreader1:consumerreader.getUserList()){
            if (consumerreader1.getRoomnum().contains(search)){
                consumer.add(consumerreader1);
            }
        }
        if (search.equals("Search") || search.equals("")){
            list = FXCollections.observableList(consumerreader.getUserList());
        }
        else{
            list = FXCollections.observableList(consumer.getUserList());
        }

        table.setItems(list);

        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("username"));
        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("name"));
        TableColumn surname = new TableColumn("SURNAME");
        surname.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("surname"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("roomnum"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        table.getColumns().addAll(name,surname,username,roomnum);
        table.getSortOrder().add(roomnum);
    }

    public void showCentralData(Consumerreader consumer){
        selectedCentral = consumer;
        nameconsumertext.setText(consumer.getName());
        usernameconsumertext.setText(consumer.getUsername());
        surnamecomsumertext.setText(consumer.getSurname());

        Removeconsumerbtn.setDisable(false);

    }
    public void clearData(){
        selectedCentral = null;
        nameconsumertext.setText("-");
        usernameconsumertext.setText("-");
        surnamecomsumertext.setText("-");

        Removeconsumerbtn.setDisable(true);

    }

    @FXML public void oksearchcentralhomebtnonaction(){
        showData(searchCentralhomebtn.getText());
    }

}
