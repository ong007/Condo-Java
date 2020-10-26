package Controller;

import Service.Boxdatasource;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Stockitem {
    @FXML Button okstockbtn,recievestockbtn,backstockbtn;
    @FXML TextField searchstockbtn,usernamestockbtn,officestockbtn;
    @FXML PasswordField passwordstockbtn;
    @FXML AnchorPane showliststock,liststock;
    @FXML ComboBox<String> selectlist;


    public void initialize(){
        selectlist.getItems().addAll("text","mail","box");
        selectlist.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (selectlist.getValue().equals("text")) {
                        liststock = FXMLLoader.load(getClass().getResource("/Stocktext.fxml"));
                    } else if (selectlist.getValue().equals("mail")) {
                        liststock = FXMLLoader.load(getClass().getResource("/Stockmail.fxml"));
                    } else if (selectlist.getValue().equals("box")){
                        liststock = FXMLLoader.load(getClass().getResource("/Stockbox.fxml"));
                    }
                    showliststock.getChildren().setAll(liststock);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML public void backstockbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backstock = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomeCheckMessage.fxml"));
        stage_backstock.setScene(new Scene(loader.load(), 882, 390));
        stage_backstock.show();
    }

//    public void showData(String search){
//        Roomreader room = new Roomreader();
//        tableroomlistbtn.getColumns().clear();
//        for (Roomreader room1:roomlist.getUserList()){
//            if (room1.getRoomnum().contains(search)){
//                room.add(room1);
//            }
//        }
//        if (search.equals("Search") || search.equals("")){
//            list = FXCollections.observableList(roomlist.getUserList());
//        }
//        else{
//            list = FXCollections.observableList(room.getUserList());
//        }
//
//        tableroomlistbtn.setItems(list);
//
//        TableColumn building = new TableColumn("BUILDING");
//        building.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("building"));
//        TableColumn type = new TableColumn("TYPE");
//        type.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("type"));
//        TableColumn floor = new TableColumn("FLOOR");
//        floor.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("floor"));
//        TableColumn roomnum = new TableColumn("ROOM NUMBER");
//        roomnum.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("roomnum"));
//        TableColumn max= new TableColumn("MAX");
//        max.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("maxarrival"));
//        TableColumn arrival= new TableColumn("AVAILABILITY");
//        arrival.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("nowarrival"));
//
//
//        roomnum.setSortType(TableColumn.SortType.ASCENDING);
//        tableroomlistbtn.getColumns().addAll(building,type,floor,roomnum,max,arrival);
//        tableroomlistbtn.getSortOrder().add(roomnum);
//    }
}
