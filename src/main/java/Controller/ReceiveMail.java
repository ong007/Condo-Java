package Controller;

import Model.ReceiveBoxReader;
import Model.ReceiveMailReader;
import Service.Boxdatasource;
import Service.ReceiveBoxDataSource;
import Service.ReceiveMailDataSource;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReceiveMail {
    @FXML
    private TableView<ReceiveMailReader> tablestockbox;
    private ObservableList<ReceiveMailReader> list;
    private Boxdatasource boxdatasource;
    private ReceiveMailReader boxList,selectedBox;


    private ReceiveMailDataSource receiveMailDataSource;
    private ReceiveMailReader receiveMaillist;

    @FXML private TextField searchreceivebtn, namebtn,surnamenamestockbtn,nameofficerreceive;
    @FXML private Button okreceivrbtn;


    public void initialize (){
        receiveMailDataSource = new ReceiveMailDataSource("data", "checkreceivemail.csv");
        receiveMaillist = receiveMailDataSource.getReceiveboxlist();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(!receiveMaillist.getUserList1().isEmpty()){
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
        ReceiveMailReader box = new ReceiveMailReader();
        tablestockbox.getColumns().clear();
        for (ReceiveMailReader consumerreader1:receiveMaillist.getUserList1()){
            if (consumerreader1.getRoomnum().contains(search)){
                box.add(consumerreader1);
            }
        }
        if (search.equals("Search") || search.equals("")){
            list = FXCollections.observableList(receiveMaillist.getUserList1());
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
        TableColumn size = new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("size"));
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("time"));
        TableColumn nameofficer = new TableColumn("OFFICER");
        nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("nameofficer"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockbox.getColumns().addAll(sender,username,company,roomnum,size,time,nameofficer);
        tablestockbox.getSortOrder().add(roomnum);
    }

    public void showSelectData(ReceiveMailReader box){
        selectedBox = box;
        nameofficerreceive.setText(box.getNameofficer());
        namebtn.setText(box.getUsername());
        surnamenamestockbtn.setText(box.getSender());
    }

    @FXML public void okreceivrbtnonaction(){
        showData(searchreceivebtn.getText());
    }

}
