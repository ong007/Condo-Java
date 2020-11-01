package Controller;

import Model.ReceiveBox;
import Service.BoxData;
import Service.ReceiveMailData;
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
    private TableView<Model.ReceiveMail> tablestockbox;
    private ObservableList<Model.ReceiveMail> list;
    private BoxData boxData;
    private Model.ReceiveMail boxList,selectedBox;


    private ReceiveMailData receiveMailData;
    private Model.ReceiveMail receiveMaillist;

    @FXML private TextField searchreceivebtn, namebtn,surnamenamestockbtn,nameofficerreceive;
    @FXML private Button okreceivrbtn;


    public void initialize (){
        receiveMailData = new ReceiveMailData("data", "ReceiveMail.csv");
        receiveMaillist = receiveMailData.getReceivemaillist();

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
        Model.ReceiveMail box = new Model.ReceiveMail();
        tablestockbox.getColumns().clear();
        for (Model.ReceiveMail consumerreader1:receiveMaillist.getUserList1()){
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
        sender.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("username"));
        TableColumn company = new TableColumn("company");
        company.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("roomnum"));
        TableColumn size = new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("size"));
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("time"));
        TableColumn nameofficer = new TableColumn("OFFICER");
        nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("nameofficer"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockbox.getColumns().addAll(sender,username,company,roomnum,size,time,nameofficer);
        tablestockbox.getSortOrder().add(roomnum);
    }

    public void showSelectData(Model.ReceiveMail box){
        selectedBox = box;
        nameofficerreceive.setText(box.getNameofficer());
        namebtn.setText(box.getUsername());
        surnamenamestockbtn.setText(box.getSender());
    }

    @FXML public void okreceivrbtnonaction(){
        showData(searchreceivebtn.getText());
    }

}
