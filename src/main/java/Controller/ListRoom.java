package Controller;

import Model.CentralOfficer;
import Model.Room;
import Service.RoomData;
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
    @FXML TableView<Room> tableroomlistbtn;
    private ObservableList<Room> list;

    private Room roomlist;
    private RoomData roomdata;

    public void initialize(){

        roomdata = new RoomData("data","Room.csv");
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Room.fxml"));
        stage_ProfilePage.setScene(new Scene(loader.load(), 882, 390));
        stage_ProfilePage.show();
    }

    public void showData(String search){
        Room room = new Room();
        tableroomlistbtn.getColumns().clear();
        for (Room room1:roomlist.getUserList()){
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
        building.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("building"));
        TableColumn type = new TableColumn("TYPE");
        type.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("type"));
        TableColumn floor = new TableColumn("FLOOR");
        floor.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("floor"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("roomnum"));
        TableColumn max= new TableColumn("MAX");
        max.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("maxarrival"));
        TableColumn arrival= new TableColumn("AVAILABILITY");
        arrival.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("nowarrival"));


        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tableroomlistbtn.getColumns().addAll(building,type,floor,roomnum,max,arrival);
        tableroomlistbtn.getSortOrder().add(roomnum);
    }
    @FXML public void okroomlistbtnonaction(){
        showData(searchroomlistbtn.getText());
    }
}
