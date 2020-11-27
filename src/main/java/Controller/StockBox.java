package Controller;

import Model.*;

import Model.Box;
import Model.ReceiveBox;
import Service.BoxData;
import Service.CentralOfficerData;
import Service.CustomerData;
import Service.ReceiveBoxData;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public class StockBox {

    @FXML
    private TableView<Item> tablestockbox;
    private ObservableList<Item> list;
    private BoxData boxData;
    private Box selectedBox;
    private BucketCustomer consumerList;
    private CustomerData customerData;
    private BucketCentralOfficer centralList;
    private CentralOfficerData centralOfficerData;
    private ReceiveBoxData receiveBoxDataDataSource;
    private BucketReceiveItem receiveboxlist;
    private BucketItem boxList;
    private Sortby sortby;
    @FXML
    private TextField searchstockbtn, usernamestockbtn;
    @FXML
    private ComboBox<String> officestockbtn,sortstock;
    @FXML
    private PasswordField passwordstockbtn;
    @FXML
    private Button recievestockbtn;


    public void initialize (){
        recievestockbtn.setDisable(true);
        receiveBoxDataDataSource = new ReceiveBoxData("data", "ReceiveBox.csv");
        receiveboxlist = receiveBoxDataDataSource.getReceiveboxlist();
        boxData = new BoxData("data", "Box.csv");
        boxList = boxData.getBoxlist();
        customerData = new CustomerData("data", "Customer.csv");
        consumerList = customerData.getConsumerList();
        centralOfficerData = new CentralOfficerData("data", "CentralOfficer.csv");
        centralList = centralOfficerData.getCentralList();
        Platform.runLater(()->{
            showBoxData("");
            for(CentralOfficer central : centralList.getBucketCentralOfficer()) {
                officestockbtn.getItems().add(central.getName());
            }
        });
        tablestockbox.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null){
                showSelectData((Box) newValue);
            }
        }));
        sortstock.getItems().addAll("early date", "last date", "First Room number","Last Room number");
        sortstock.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (sortstock.getValue().equals("early date")) {
                    sortby = null;
                    sortby = new SortByEarlyTime();
                } else if (sortstock.getValue().equals("last date")) {
                    sortby = null;
                    sortby = new SortByLastTime();
                } else if (sortstock.getValue().equals("First Room number")) {
                    sortby = null;
                    sortby = new SortByFirstRoom();
                }else if (sortstock.getValue().equals("Last Room number")) {
                    sortby = null;
                    sortby = new SortByLastRoom();
                }
            }
        });
    }
    public void handleSortBtn() throws ParseException {
        if(sortby!=null){
            sortby.sort(boxList);
            showBoxData("");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please select orders");
            alert.showAndWait();
        }
    }
    public void showBoxData(String search){
        BucketItem box = new BucketItem();
        tablestockbox.getColumns().clear();
        for (Item boxItem : boxList.getBucketItem()){
            if (boxItem.getRoomnum().contains(search)){
                box.addItem(boxItem);
            }
        }
        if (search.equals("searchstockbtn") || search.equals("")){
            list = FXCollections.observableList(boxList.getBucketItem());
        }
        else{
            list = FXCollections.observableList(box.getBucketItem());
        }

        tablestockbox.setItems(list);


        TableColumn sender = new TableColumn("SENDER");
        sender.setCellValueFactory(new PropertyValueFactory<Box,String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<Box,String>("username"));
        TableColumn company= new TableColumn("COMPANY");
        company.setCellValueFactory(new PropertyValueFactory<Box,String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<Box,String>("roomnum"));
        TableColumn level = new TableColumn("LEVEL");
        level.setCellValueFactory(new PropertyValueFactory<Box,String>("level"));
        TableColumn size= new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<Box,String>("size"));
        TableColumn tracking= new TableColumn("TRACKING");
        tracking.setCellValueFactory(new PropertyValueFactory<Box,String>("tacking"));
        TableColumn time= new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<Box,String>("time"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockbox.getColumns().addAll(sender,username,company,roomnum,level,size,tracking,time);
    }
    @FXML public void okstockboxbtnonaction(){
        showBoxData(searchstockbtn.getText());
    }

    public void showSelectData(Box box){
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
                    String time = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
                    ReceiveBox box = new ReceiveBox(selectedBox.getSender(),selectedBox.getUsername(),selectedBox.getCompany(), selectedBox.getRoomnum(), selectedBox.getLevel(),selectedBox.getSize(), selectedBox.getTacking(), time,officestockbtn.getValue());

                    receiveboxlist.addItem(box);
                    receiveBoxDataDataSource.setlist(receiveboxlist);
                    boxList.removeItem(selectedBox);
                    this.boxData.setBoxlist(boxList);
                    clearData();
                    tablestockbox.refresh();
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Incorrect");
                alert.setContentText("Incorrect username or password.");
                alert.showAndWait();
            }
        }
    }

}
