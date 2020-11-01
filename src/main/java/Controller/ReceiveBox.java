package Controller;

import Service.BoxData;

import Service.ReceiveBoxData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReceiveBox {
    @FXML
    private TableView<Model.ReceiveBox> tablestockbox;
    private ObservableList<Model.ReceiveBox> list;
    private BoxData boxData;
    private Model.ReceiveBox boxList,selectedBox;


    private ReceiveBoxData receiveBoxDataDataSource;
    private Model.ReceiveBox receiveboxlist;

    @FXML private TextField searchreceivebtn, namebtn,surnamenamestockbtn,nameofficerreceive;
    @FXML private Button okreceivrbtn;


    public void initialize (){
        receiveBoxDataDataSource = new ReceiveBoxData("data", "ReceiveBox.csv");
        receiveboxlist = receiveBoxDataDataSource.getReceiveboxlist();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if(!receiveboxlist.getUserListBox().isEmpty()){
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
            Model.ReceiveBox box = new Model.ReceiveBox();
            tablestockbox.getColumns().clear();
            for (Model.ReceiveBox consumerreader1:receiveboxlist.getUserListBox()){
            if (consumerreader1.getRoomnum().contains(search)){
            box.add(consumerreader1);
            }
            }
            if (search.equals("Search") || search.equals("")){
            list = FXCollections.observableList(receiveboxlist.getUserListBox());
            }
            else{
            list = FXCollections.observableList(box.getUserListBox());
            }

            tablestockbox.setItems(list);


            TableColumn sender = new TableColumn("SENDER");
            sender.setCellValueFactory(new PropertyValueFactory<Model.ReceiveBox,String>("sender"));
            TableColumn username = new TableColumn("USERNAME");
            username.setCellValueFactory(new PropertyValueFactory<Model.ReceiveBox,String>("username"));
            TableColumn company = new TableColumn("company");
            company.setCellValueFactory(new PropertyValueFactory<Model.ReceiveBox,String>("company"));
            TableColumn roomnum = new TableColumn("ROOM NUMBER");
            roomnum.setCellValueFactory(new PropertyValueFactory<Model.ReceiveBox,String>("roomnum"));
            TableColumn level = new TableColumn("LEVEL");
            level.setCellValueFactory(new PropertyValueFactory<Model.ReceiveBox,String>("level"));
            TableColumn size = new TableColumn("SIZE");
            size.setCellValueFactory(new PropertyValueFactory<Model.ReceiveBox,String>("size"));
            TableColumn tracking = new TableColumn("TRACKING");
            tracking.setCellValueFactory(new PropertyValueFactory<Model.ReceiveBox,String>("tracking"));
            TableColumn time = new TableColumn("TIME");
            time.setCellValueFactory(new PropertyValueFactory<Model.ReceiveBox,String>("time"));
            TableColumn nameofficer = new TableColumn("OFFICER");
            nameofficer.setCellValueFactory(new PropertyValueFactory<Model.ReceiveBox,String>("nameofficer"));

            roomnum.setSortType(TableColumn.SortType.ASCENDING);
            tablestockbox.getColumns().addAll(sender,username,company,roomnum,level,size,tracking,time,nameofficer);
            tablestockbox.getSortOrder().add(roomnum);
            }

    public void showSelectData(Model.ReceiveBox box){
        selectedBox = box;
        nameofficerreceive.setText(box.getNameofficer());
        namebtn.setText(box.getUsername());
        surnamenamestockbtn.setText(box.getSender());
        }

    @FXML public void okreceivrbtnonaction(){
            showData(searchreceivebtn.getText());
            }

}
