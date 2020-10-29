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

public class Stockmail {
    @FXML
    private TableView<Mailreader> tablestockmail;
    private ObservableList<Mailreader> list;
    private MailDataSource mailDataSource;
    private Mailreader maillist,selectedMail;
    private Consumerreader consumerList;
    private Consumerdatasource consumerdatasource;
    private Centraluserreader centralList;
    private CentralFileDataSource centralFileDataSource;
    private ReceiveMailDataSource receiveMailDataSource;
    private ReceiveMailReader receivemaillist;
    @FXML
    private TextField searchstockmailbtn, usernamestockmailbtn;
    @FXML
    private ComboBox<String> officestockbtn;
    @FXML
    private PasswordField passwordstockbtn;
    @FXML
    private Button okstockbtn,recievestockbtn;


    public void initialize (){
        recievestockbtn.setDisable(true);
        receiveMailDataSource = new ReceiveMailDataSource("data","checkreceivemail.csv");
        receivemaillist = receiveMailDataSource.getReceiveboxlist();
        mailDataSource = new MailDataSource("data", "mail.csv");
        maillist = mailDataSource.getMaillist();
        consumerdatasource = new Consumerdatasource("data", "Consumerdata.csv");
        consumerList = consumerdatasource.getConsumerList();
        centralFileDataSource = new CentralFileDataSource("data", "Centraldata.csv");
        centralList = centralFileDataSource.getCentralList();
        Platform.runLater(()->{
            showMailData("");
            for(Centraluserreader central : centralList.getUserList()) {
                officestockbtn.getItems().add(central.getName());
            }
        });
        tablestockmail.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null){
                showSelectData(newValue);
            }
        }));
    }

    public void showMailData(String search){
        Mailreader mails = new Mailreader();
        tablestockmail.getColumns().clear();
        for (Mailreader mail : maillist.getUserList()){
            if (mail.getRoomnum().contains(search)){
                mails.add(mail);
            }
        }
        if (search.equals("searchstockbtn") || search.equals("")){
            list = FXCollections.observableList(maillist.getUserList());
        }
        else{
            list = FXCollections.observableList(mails.getUserList());
        }

        tablestockmail.setItems(list);

        TableColumn sender = new TableColumn("SENDER");
        sender.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("username"));
        TableColumn company= new TableColumn("COMPANY");
        company.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("roomnum"));

        TableColumn size= new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("size"));

        TableColumn time= new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("time"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockmail.getColumns().addAll(sender,username,company,roomnum,size,time);
        tablestockmail.getSortOrder().add(roomnum);
    }
    @FXML public void okstockmailbtnonaction(){
        showMailData(searchstockmailbtn.getText());
    }

    public void showSelectData(Mailreader box){
        selectedMail = box;
        recievestockbtn.setDisable(false);

    }
    public void clearData(){
        selectedMail = null;
        recievestockbtn.setDisable(true);
        usernamestockmailbtn.setText("");
        passwordstockbtn.setText("");
        officestockbtn.getSelectionModel().clearSelection();
    }

    public void receivedOnAction(){
        if(usernamestockmailbtn.getText().equals("") || passwordstockbtn.getText().equals("") || officestockbtn.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please fill all information.");
            alert.showAndWait();
        }else{
            if(consumerList.checkReceived(usernamestockmailbtn.getText(), passwordstockbtn.getText())){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Confirmation.");
                alert.setHeaderText("");
                alert.setContentText("CONFIRM?");
                Optional<ButtonType> confirmation = alert.showAndWait();
                if (confirmation.get() == ButtonType.OK) {
                    ReceiveMailReader mail = new ReceiveMailReader(selectedMail.getSender(), selectedMail.getUsername(), selectedMail.getCompany(), selectedMail.getRoomnum(), selectedMail.getSize(),selectedMail.getTime(),officestockbtn.getValue());
                    receivemaillist.add(mail);
                    receiveMailDataSource.setMaillist(receivemaillist);
                    maillist.removeBox(selectedMail);
                    mailDataSource.setMaillist(maillist);
                    clearData();
                    tablestockmail.refresh();
            }
        }
    }
}}
