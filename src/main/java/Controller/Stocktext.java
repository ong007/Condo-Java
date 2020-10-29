package Controller;

import Model.*;

import Service.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class Stocktext {
    @FXML
    private TableView<Textreader> tablestockbox;
    private ObservableList<Textreader> list;
    private TextDataSource textDataSource;
    private Textreader textList, selectedText;
    private Consumerreader consumerList;
    private Consumerdatasource consumerdatasource;
    private Centraluserreader centralList;
    private CentralFileDataSource centralFileDataSource;
    private ReceiveTextDataSource receiveTextDataSource;
    private ReceiveTextReader receivetextlist;
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
        receiveTextDataSource = new ReceiveTextDataSource("data", "checkreceivetext.csv");
        receivetextlist = receiveTextDataSource.getReceiveTextlist();
        textDataSource = new TextDataSource("data", "text.csv");
        textList = textDataSource.getTextlist();
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
        Textreader texts = new Textreader();
        tablestockbox.getColumns().clear();
        for (Textreader text : textList.getUserList()){
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

        TableColumn time= new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("time"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockbox.getColumns().addAll(sender,username,company,roomnum,level,size,time);
        tablestockbox.getSortOrder().add(roomnum);
    }
    @FXML public void okstockboxbtnonaction(){
        showBoxData(searchstockbtn.getText());
    }

    public void showSelectData(Textreader box){
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
                    ReceiveTextReader text = new ReceiveTextReader(selectedText.getSender(), selectedText.getUsername(), selectedText.getCompany(), selectedText.getRoomnum(), selectedText.getLevel(), selectedText.getSize(),selectedText.getTime(),officestockbtn.getValue());
                    receivetextlist.add(text);
                    receiveTextDataSource.setTextlist(receivetextlist);
                    textList.removeText(selectedText);
                    textDataSource.setTextlist(textList);
                    clearData();
                    tablestockbox.refresh();
                }
            }
        }
    }
}
