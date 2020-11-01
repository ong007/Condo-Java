package Controller;

import Model.*;

import Model.Box;
import Model.ReceiveText;
import Model.Text;
import Service.*;
import Service.ReceiveTextData;
import Service.TextData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public class StockText {
    @FXML
    private TableView<Text> tablestockbox;
    private ObservableList<Text> list;
    private TextData textData;
    private Text textList, selectedText;
    private CustomerReader consumerList;
    private CustomerData customerData;
    private CentralOfficer centralList;
    private CentralOfficerData centralOfficerData;
    private ReceiveTextData receiveTextData;
    private ReceiveText receivetextlist;
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
        receiveTextData = new ReceiveTextData("data", "ReceiveText.csv");
        receivetextlist = receiveTextData.getReceiveTextlist();
        textData = new TextData("data", "Text.csv");
        textList = textData.getTextlist();
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
        Text texts = new Text();
        tablestockbox.getColumns().clear();
        for (Text text : textList.getUserList()){
            if (text.getRoomnum().contains(search)){
                texts.add(text);
            }
        }
        if (search.equals("searchstockbtn") || search.equals("")){
            list = FXCollections.observableList(textList.getUserList());
        }
        else{
            list = FXCollections.observableList(texts.getUserList());
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
        TableColumn time= new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<Box,String>("time"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockbox.getColumns().addAll(sender,username,company,roomnum,level,size,time);
        tablestockbox.getSortOrder().add(roomnum);
    }
    @FXML public void okstockboxbtnonaction(){
        showBoxData(searchstockbtn.getText());
    }

    public void showSelectData(Text box){
        selectedText = box;
        recievestockbtn.setDisable(false);

    }
    public void clearData(){
        selectedText = null;
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
                    ReceiveText text = new ReceiveText(selectedText.getSender(),selectedText.getUsername(), selectedText.getCompany(), selectedText.getRoomnum(), selectedText.getLevel(),selectedText.getSize(),time,officestockbtn.getValue());
                    receivetextlist.add(text);
                    receiveTextData.setTextlist(receivetextlist);
                    textList.removeText(selectedText);
                    this.textData.setTextlist(textList);
                    clearData();
                    tablestockbox.refresh();
                }
            }
        }
    }
}
