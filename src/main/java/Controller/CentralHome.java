package Controller;

import Model.CentralOfficer;
import Model.CustomerReader;

import Model.Room;
import Service.CustomerData;
import Service.RoomData;
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

public class CentralHome {
    @FXML
    TableView<CustomerReader> table;
    @FXML Button Newmessengerbtn,Homecentralhomebtn,Newconsumerbtn,Removeconsumerbtn,Newpasswordcentralhomebtn;
    @FXML TextField nameconsumertext,surnamecomsumertext,usernameconsumertext,searchCentralhomebtn;
    private CustomerReader customerReader,selectedCentral;
    private CustomerData customerData;
    private ObservableList<CustomerReader> list;
    private Room roomlist;
    private RoomData roomdata;



    public void initialize(){
        Removeconsumerbtn.setDisable(true);
        customerReader = new CustomerReader();
        customerData = new CustomerData("data" , "Customer.csv");
        customerReader = customerData.getConsumerList();
        roomdata = new RoomData("data","Room.csv");
        roomlist = roomdata.getRoomlist();
     Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(!customerReader.getUserList().isEmpty()){
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
        customerReader.removeConsumer(selectedCentral);
        customerData = new CustomerData("data" , "Customer.csv");
        roomdata = new RoomData("data","Room.csv");
        roomdata.setRoomlist(roomlist);
        customerData.setConsumerList(customerReader);
        clearData();
        Button a = (Button) event.getSource();
        Stage stage_removeconsumer = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CentralHome.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginCentral.fxml"));
        stage_newmessage.setScene(new Scene(loader.load(), 882, 390));
        stage_newmessage.show();}

    @FXML public void NewConSumerBtnOnAcTion(ActionEvent event) throws IOException {
        Button c = (Button) event.getSource();
        Stage stage_newconsumer= (Stage) c.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewCustomer.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewPasswordCentral.fxml"));
        stage_newpassword.setScene(new Scene(loader.load(), 882, 390));
        stage_newpassword.show();
    }

    public void showData(String search){
        CustomerReader consumer = new CustomerReader();
        table.getColumns().clear();
        for (CustomerReader customerReader1 : customerReader.getUserList()){
            if (customerReader1.getRoomnum().contains(search)){
                consumer.add(customerReader1);
            }
        }
        if (search.equals("Search") || search.equals("")){
            list = FXCollections.observableList(customerReader.getUserList());
        }
        else{
            list = FXCollections.observableList(consumer.getUserList());
        }

        table.setItems(list);

        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("username"));
        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("name"));
        TableColumn surname = new TableColumn("SURNAME");
        surname.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("surname"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("roomnum"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        table.getColumns().addAll(name,surname,username,roomnum);
        table.getSortOrder().add(roomnum);

    }

    public void showCentralData(CustomerReader consumer){
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
