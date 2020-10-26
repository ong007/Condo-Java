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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ListRoom {
    @FXML Button okroomlistbtn,backroomlistbtn;
    @FXML TextField searchroomlistbtn;
    @FXML TableView<Roomreader> tableroomlistbtn;
    private ObservableList<Roomreader> list;

    private Roomreader roomlist;
    private Roomdatasource roomdata;

    public void initialize(){

        roomdata = new Roomdatasource("data","createroom.csv");
        roomlist = roomdata.getRoomlist();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(!roomlist.getUserList().isEmpty()){
                    showData("");
                }
            }
        });

    }

    @FXML public void backroomlistbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_ProfilePage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/room.fxml"));
        stage_ProfilePage.setScene(new Scene(loader.load(), 882, 390));
        stage_ProfilePage.show();
    }

    public void showData(String search){
        Roomreader room = new Roomreader();
        tableroomlistbtn.getColumns().clear();
        for (Roomreader room1:roomlist.getUserList()){
            if (room1.getRoomnum().contains(search)){
                room.add(room1);
            }
        }
        if (search.equals("Search") || search.equals("")){
            list = FXCollections.observableList(roomlist.getUserList());
        }
        else{
            list = FXCollections.observableList(room.getUserList());
        }

        tableroomlistbtn.setItems(list);

        TableColumn building = new TableColumn("BUILDING");
        building.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("building"));
        TableColumn type = new TableColumn("TYPE");
        type.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("type"));
        TableColumn floor = new TableColumn("FLOOR");
        floor.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("floor"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("roomnum"));
        TableColumn max= new TableColumn("MAX");
        max.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("maxarrival"));
        TableColumn arrival= new TableColumn("AVAILABILITY");
        arrival.setCellValueFactory(new PropertyValueFactory<Centraluserreader,String>("nowarrival"));


        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tableroomlistbtn.getColumns().addAll(building,type,floor,roomnum,max,arrival);
        tableroomlistbtn.getSortOrder().add(roomnum);
    }
    @FXML public void okroomlistbtnonaction(){
        showData(searchroomlistbtn.getText());
    }
}
