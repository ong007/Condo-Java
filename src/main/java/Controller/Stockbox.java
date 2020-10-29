package Controller;

import Model.Boxreader;
import Model.Centraluserreader;
import Model.Consumerreader;

import Model.ReceiveBoxReader;
import Service.Boxdatasource;
import Service.CentralFileDataSource;
import Service.Consumerdatasource;
import Service.ReceiveBoxDataSource;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class Stockbox {

    @FXML
    private TableView<Boxreader> tablestockbox;
    private ObservableList<Boxreader> list;
    private Boxdatasource boxdatasource;
    private Boxreader boxList,selectedBox;
    private Consumerreader consumerList;
    private Consumerdatasource consumerdatasource;
    private Centraluserreader centralList;
    private CentralFileDataSource centralFileDataSource;
    private ReceiveBoxDataSource receiveBoxDataSource;
    private ReceiveBoxReader receiveboxlist;

    @FXML
    private TextField searchstockbtn, usernamestockbtn;
    @FXML
    private ComboBox<String> officestockbtn;
    @FXML
    private PasswordField passwordstockbtn;
    @FXML
    private Button okstockbtn,recievestockbtn;


    public void initialize (){
        recievestockbtn.setDisable(true);
        receiveBoxDataSource = new ReceiveBoxDataSource("data", "checkreceivebox.csv");
        receiveboxlist = receiveBoxDataSource.getReceiveboxlist();
        boxdatasource = new Boxdatasource("data", "box.csv");
        boxList = boxdatasource.getBoxlist();
        consumerdatasource = new Consumerdatasource("data", "Consumerdata.csv");
        consumerList = consumerdatasource.getConsumerList();
        centralFileDataSource = new CentralFileDataSource("data", "Centraldata.csv");
        centralList = centralFileDataSource.getCentralList();
        Platform.runLater(()->{
            showBoxData("");
            for(Centraluserreader central : centralList.getUserList()) {
                officestockbtn.getItems().add(central.getName());
            }
        });
        tablestockbox.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null){
                showSelectData(newValue);
            }
        }));
    }

    public void showBoxData(String search){
        Boxreader boxes = new Boxreader();
        tablestockbox.getColumns().clear();
        for (Boxreader box : boxList.getUserList()){
            if (box.getRoomnum().contains(search)){
                boxes.add(box);
            }
        }
        if (search.equals("searchstockbtn") || search.equals("")){
            list = FXCollections.observableList(boxList.getUserList());
        }
        else{
            list = FXCollections.observableList(boxes.getUserList());
        }

        tablestockbox.setItems(list);

        TableColumn sender = new TableColumn("SENDER");
        sender.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("username"));
        TableColumn company= new TableColumn("COMPANY");
        company.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("roomnum"));
        TableColumn level = new TableColumn("LEVEL");
        level.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("level"));
        TableColumn size= new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("size"));
        TableColumn tracking= new TableColumn("TRACKING");
        tracking.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("tracking"));
        TableColumn time= new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("time"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockbox.getColumns().addAll(sender,username,company,roomnum,level,size,tracking,time);
        tablestockbox.getSortOrder().add(roomnum);
    }
    @FXML public void okstockboxbtnonaction(){
        showBoxData(searchstockbtn.getText());
    }

    public void showSelectData(Boxreader box){
        selectedBox = box;
        recievestockbtn.setDisable(false);

    }
    public void clearData(){
        selectedBox = null;
        recievestockbtn.setDisable(true);
        usernamestockbtn.setText("");
        passwordstockbtn.setText("");
        officestockbtn.getSelectionModel().clearSelection();
    }

    public void receivedOnAction(){
        if(usernamestockbtn.getText().equals("") || passwordstockbtn.getText().equals("") || officestockbtn.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please fill all information.");
            alert.showAndWait();

        }else{
            if(consumerList.checkReceived(usernamestockbtn.getText(), passwordstockbtn.getText())) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation.");
                alert.setHeaderText("");
                alert.setContentText("CONFIRM?");
                Optional<ButtonType> confirmation = alert.showAndWait();
                if (confirmation.get() == ButtonType.OK) {
                    ReceiveBoxReader box = new ReceiveBoxReader(selectedBox.getSender(), selectedBox.getUsername(), selectedBox.getCompany(), selectedBox.getRoomnum(), selectedBox.getLevel(), selectedBox.getSize(), selectedBox.getTracking(),selectedBox.getTime(),officestockbtn.getValue());
                    receiveboxlist.add(box);
                    receiveBoxDataSource.setlist(receiveboxlist);
                    boxList.removeBox(selectedBox);
                    boxdatasource.setBoxlist(boxList);
                    clearData();
                    tablestockbox.refresh();
                }
            }
        }
    }

}
