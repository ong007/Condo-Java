package Controller;

import Model.ReceiveBoxReader;
import Model.ReceiveMailReader;
import Model.ReceiveTextReader;
import Service.Boxdatasource;
import Service.ReceiveTextDataSource;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReceiveText {
    @FXML
    private TableView<ReceiveTextReader> tablestockbox;
    private ObservableList<ReceiveTextReader> list;
    private Boxdatasource boxdatasource;
    private ReceiveMailReader boxList;
    private ReceiveTextReader selectedBox;


    private ReceiveTextDataSource receiveTextDataSource;
    private ReceiveTextReader receiveTextlist;

    @FXML private TextField searchreceivebtn, namebtn,surnamenamestockbtn,nameofficerreceive;
    @FXML private Button okreceivrbtn;


    public void initialize (){
        receiveTextDataSource = new ReceiveTextDataSource("data", "checkreceivetext.csv");
        receiveTextlist = receiveTextDataSource.getReceiveTextlist();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(!receiveTextlist.getUserList1().isEmpty()){
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
        ReceiveTextReader text = new ReceiveTextReader();
        tablestockbox.getColumns().clear();
        for (ReceiveTextReader consumerreader1:receiveTextlist.getUserList1()){
            if (consumerreader1.getRoomnum().contains(search)){
                text.add(consumerreader1);
            }
        }
        if (search.equals("Search") || search.equals("")){
            list = FXCollections.observableList(receiveTextlist.getUserList1());
        }
        else{
            list = FXCollections.observableList(text.getUserList1());
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
        TableColumn level = new TableColumn("LEVEL");
        level.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("level"));
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("time"));
        TableColumn nameofficer = new TableColumn("OFFICER");
        nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("nameofficer"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockbox.getColumns().addAll(sender,username,company,roomnum,size,level,time,nameofficer);
        tablestockbox.getSortOrder().add(roomnum);
    }

    public void showSelectData(ReceiveTextReader box){
        selectedBox = box;
        nameofficerreceive.setText(box.getNameofficer());
        namebtn.setText(box.getUsername());
        surnamenamestockbtn.setText(box.getSender());
    }

    @FXML public void okreceivrbtnonaction(){
        showData(searchreceivebtn.getText());
    }

}
