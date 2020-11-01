package Controller;

import Model.*;
import Model.Box;
import Model.Mail;
import Model.ReceiveMail;
import Service.*;
import Service.MailData;
import Service.ReceiveMailData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public class StockMail {
    @FXML
    private TableView<Mail> tablestockmail;
    private ObservableList<Mail> list;
    private MailData mailData;
    private Mail maillist,selectedMail;
    private CustomerReader consumerList;
    private CustomerData customerData;
    private CentralOfficer centralList;
    private CentralOfficerData centralOfficerData;
    private ReceiveMailData receiveMailData;
    private ReceiveMail receivemaillist;
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
        receiveMailData = new ReceiveMailData("data","ReceiveMail.csv");
        receivemaillist = receiveMailData.getReceivemaillist();
        mailData = new MailData("data", "Mail.csv");
        maillist = mailData.getMaillist();
        customerData = new CustomerData("data", "Customer.csv");
        consumerList = customerData.getConsumerList();
        centralOfficerData = new CentralOfficerData("data", "CentralOfficer.csv");
        centralList = centralOfficerData.getCentralList();
        Platform.runLater(()->{
            showMailData("");
            for(CentralOfficer central : centralList.getUserList()) {
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
        Mail mails = new Mail();
        tablestockmail.getColumns().clear();
        for (Mail mail : maillist.getUserList()){
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
        sender.setCellValueFactory(new PropertyValueFactory<Box,String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<Box,String>("username"));
        TableColumn company= new TableColumn("COMPANY");
        company.setCellValueFactory(new PropertyValueFactory<Box,String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<Box,String>("roomnum"));

        TableColumn size= new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<Box,String>("size"));

        TableColumn time= new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<Box,String>("time"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockmail.getColumns().addAll(sender,username,company,roomnum,size,time);
        tablestockmail.getSortOrder().add(roomnum);
    }
    @FXML public void okstockmailbtnonaction(){
        showMailData(searchstockmailbtn.getText());
    }

    public void showSelectData(Mail box){
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
                    String time = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
                    ReceiveMail mail = new ReceiveMail(selectedMail.getSender(),selectedMail.getUsername(), selectedMail.getCompany(), selectedMail.getRoomnum(),selectedMail.getSize(),time,officestockbtn.getValue());
                    receivemaillist.add(mail);
                    receiveMailData.setMaillist(receivemaillist);
                    maillist.removeBox(selectedMail);
                    this.mailData.setMaillist(maillist);
                    clearData();
                    tablestockmail.refresh();
            }
        }
    }
}}
