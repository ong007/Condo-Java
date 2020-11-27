package Controller;

import Model.BucketReceiveItem;
import Model.ReceiveBox;
import Model.ReceiveMail;
import Service.BoxData;
import Service.ReceiveTextData;
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
    private TableView<ReceiveMail> tablestockbox;
    private ObservableList<ReceiveMail> list;
    private BoxData boxData;
    private ReceiveMail boxList;
    private Model.ReceiveText selectedBox;


    private ReceiveTextData receiveTextData;
    private BucketReceiveItem receiveTextlist;

    @FXML private TextField searchreceivebtn, namebtn,surnamenamestockbtn,nameofficerreceive;
    @FXML private Button okreceivrbtn;


    public void initialize (){
        receiveTextData = new ReceiveTextData("data", "ReceiveText.csv");
        receiveTextlist = receiveTextData.getReceiveTextlist();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(!receiveTextlist.getBucketReceiveItem().isEmpty()){
                    showData("");
                }
            }
        });
        tablestockbox.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null){
                showSelectData((Model.ReceiveText) newValue);
            }
        }));
    }


    public void showData(String search){
        BucketReceiveItem text = new BucketReceiveItem();
        tablestockbox.getColumns().clear();
        for (ReceiveMail consumerreader1:receiveTextlist.getBucketReceiveItem()){
            if (consumerreader1.getRoomnum().contains(search)){
                text.addItem(consumerreader1);
            }
        }
        if (search.equals("Search") || search.equals("")){
            list = FXCollections.observableList(receiveTextlist.getBucketReceiveItem());
        }
        else{
            list = FXCollections.observableList(text.getBucketReceiveItem());
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
        TableColumn level = new TableColumn("LEVEL");
        level.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("level"));
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("time"));
        TableColumn nameofficer = new TableColumn("OFFICER");
        nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("nameofficer"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockbox.getColumns().addAll(sender,username,company,roomnum,size,level,time,nameofficer);
        tablestockbox.getSortOrder().add(roomnum);
    }

    public void showSelectData(Model.ReceiveText box){
        selectedBox = box;
        nameofficerreceive.setText(box.getNameofficer());
        namebtn.setText(box.getUsername());
        surnamenamestockbtn.setText(box.getSender());
    }

    @FXML public void okreceivrbtnonaction(){
        showData(searchreceivebtn.getText());
    }

}
