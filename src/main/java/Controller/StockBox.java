package Controller;

import Model.Box;
import Model.CentralOfficer;
import Model.CustomerReader;

import Model.ReceiveBox;
import Service.BoxData;
import Service.CentralOfficerData;
import Service.CustomerData;
import Service.ReceiveBoxData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public class StockBox {

    @FXML
    private TableView<Box> tablestockbox;
    private ObservableList<Box> list;
    private BoxData boxData;
    private Box boxList,selectedBox;
    private CustomerReader consumerList;
    private CustomerData customerData;
    private CentralOfficer centralList;
    private CentralOfficerData centralOfficerData;
    private ReceiveBoxData receiveBoxDataDataSource;
    private ReceiveBox receiveboxlist;

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
            for(CentralOfficer central : centralList.getUserList()) {
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
        Box boxes = new Box();
        tablestockbox.getColumns().clear();
        for (Box box : boxList.getUserList()){
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
        tablestockbox.getSortOrder().add(roomnum);
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

                    receiveboxlist.add(box);
                    receiveBoxDataDataSource.setlist(receiveboxlist);
                    boxList.removeBox(selectedBox);
                    this.boxData.setBoxlist(boxList);
                    clearData();
                    tablestockbox.refresh();
                }
            }
        }
    }

}
