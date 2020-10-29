package Controller;

import Model.ReceiveBoxReader;

import Model.ReceiveBoxReader;
import Service.Boxdatasource;

import Service.Consumerdatasource;
import Service.ReceiveBoxDataSource;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class ReceiveBox {
    @FXML
    private TableView<ReceiveBoxReader> tablestockbox;
    private ObservableList<ReceiveBoxReader> list;
    private Boxdatasource boxdatasource;
    private ReceiveBoxReader boxList,selectedBox;


    private ReceiveBoxDataSource receiveBoxDataSource;
    private ReceiveBoxReader receiveboxlist;

    @FXML private TextField searchreceivebtn, namebtn,surnamenamestockbtn,nameofficerreceive;
    @FXML private Button okreceivrbtn;


    public void initialize (){
        receiveBoxDataSource = new ReceiveBoxDataSource("data", "checkreceivebox.csv");
        receiveboxlist = receiveBoxDataSource.getReceiveboxlist();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(!receiveboxlist.getUserList1().isEmpty()){
                    showData("");
                }
            }
        });
        tablestockbox.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null){
                showSelectData(newValue);
            }
        }));
    }


    public void showData(String search){
            ReceiveBoxReader box = new ReceiveBoxReader();
            tablestockbox.getColumns().clear();
            for (ReceiveBoxReader consumerreader1:receiveboxlist.getUserList1()){
            if (consumerreader1.getRoomnum().contains(search)){
            box.add(consumerreader1);
            }
            }
            if (search.equals("Search") || search.equals("")){
            list = FXCollections.observableList(receiveboxlist.getUserList1());
            }
            else{
            list = FXCollections.observableList(box.getUserList1());
            }

            tablestockbox.setItems(list);

            TableColumn sender = new TableColumn("SENDER");
            sender.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("sender"));
            TableColumn username = new TableColumn("USERNAME");
            username.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("username"));
            TableColumn company = new TableColumn("company");
            company.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("company"));
            TableColumn roomnum = new TableColumn("ROOM NUMBER");
            roomnum.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("roomnum"));
            TableColumn level = new TableColumn("LEVEL");
            level.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("level"));
            TableColumn size = new TableColumn("SIZE");
            size.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("size"));
            TableColumn tracking = new TableColumn("TRACKING");
            tracking.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("tracking"));
            TableColumn time = new TableColumn("TIME");
            time.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("time"));
            TableColumn nameofficer = new TableColumn("OFFICER");
            nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("nameofficer"));

            roomnum.setSortType(TableColumn.SortType.ASCENDING);
            tablestockbox.getColumns().addAll(sender,username,company,roomnum,level,size,tracking,time,nameofficer);
            tablestockbox.getSortOrder().add(roomnum);
            }

    public void showSelectData(ReceiveBoxReader box){
        selectedBox = box;
        nameofficerreceive.setText(box.getNameofficer());
        namebtn.setText(box.getUsername());
        surnamenamestockbtn.setText(box.getSender());
        }

    @FXML public void okreceivrbtnonaction(){
            showData(searchreceivebtn.getText());
            }

}
