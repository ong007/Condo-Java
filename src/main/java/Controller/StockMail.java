package Controller;

import Model.*;
import Model.Box;
import Model.Mail;
import Model.ReceiveMail;
import Model.ReceiveText;
import Service.*;
import Service.MailData;
import Service.ReceiveMailData;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

public class StockMail {
    @FXML
    private TableView<Item> tablestockmail;
    private ObservableList<Item> list;
    private MailData mailData;
    private Mail selectedMail;
    private BucketCustomer consumerList;
    private CustomerData customerData;
    private BucketCentralOfficer centralList;
    private CentralOfficerData centralOfficerData;
    private ReceiveMailData receiveMailData;
    private BucketReceiveItem receivemaillist;
    private BucketItem maillist;
    private Sortby sortby;

    @FXML
    private TextField searchstockmailbtn, usernamestockmailbtn;
    @FXML
    private ComboBox<String> officestockbtn,sortstock;
    @FXML
    private PasswordField passwordstockbtn;
    @FXML
    private Button okstockbtn, recievestockbtn;


    public void initialize() {
        recievestockbtn.setDisable(true);
        receiveMailData = new ReceiveMailData("data", "ReceiveMail.csv");
        receivemaillist = receiveMailData.getReceivemaillist();
        mailData = new MailData("data", "Mail.csv");
        maillist = mailData.getMaillist();
        customerData = new CustomerData("data", "Customer.csv");
        consumerList = customerData.getConsumerList();
        centralOfficerData = new CentralOfficerData("data", "CentralOfficer.csv");
        centralList = centralOfficerData.getCentralList();
        Platform.runLater(() -> {
            showMailData("");
            for (CentralOfficer central : centralList.getBucketCentralOfficer()) {
                officestockbtn.getItems().add(central.getName());
            }
        });
        tablestockmail.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showSelectData((Mail) newValue);
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
            sortby.sort(maillist);
            showMailData("");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please select orders");
            alert.showAndWait();
        }
    }

    public void showMailData(String search) {
        BucketItem mails = new BucketItem();
        tablestockmail.getColumns().clear();
        for (Item mail : maillist.getBucketItem()) {
            if (mail.getRoomnum().contains(search)) {
                mails.addItem(mail);
            }
        }
        if (search.equals("searchstockbtn") || search.equals("")) {
            list = FXCollections.observableList(maillist.getBucketItem());
        } else {
            list = FXCollections.observableList(mails.getBucketItem());
        }

        tablestockmail.setItems(list);

        TableColumn sender = new TableColumn("SENDER");
        sender.setCellValueFactory(new PropertyValueFactory<Box, String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<Box, String>("username"));
        TableColumn company = new TableColumn("COMPANY");
        company.setCellValueFactory(new PropertyValueFactory<Box, String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<Box, String>("roomnum"));

        TableColumn size = new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<Box, String>("size"));

        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<Box, String>("time"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockmail.getColumns().addAll(sender, username, company, roomnum, size, time);
    }

    @FXML
    public void okstockmailbtnonaction() {
        showMailData(searchstockmailbtn.getText());
    }

    public void showSelectData(Mail box) {
        selectedMail = box;
        recievestockbtn.setDisable(false);

    }

    public void clearData() {
        selectedMail = null;
        recievestockbtn.setDisable(true);
        usernamestockmailbtn.setText("");
        passwordstockbtn.setText("");
        officestockbtn.getSelectionModel().clearSelection();
    }

    public void receivedOnAction() {
        if (usernamestockmailbtn.getText().equals("") || passwordstockbtn.getText().equals("") || officestockbtn.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please fill all information.");
            alert.showAndWait();
        } else {
            if (consumerList.checkReceived(usernamestockmailbtn.getText(), passwordstockbtn.getText())) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Confirmation.");
                alert.setHeaderText("");
                alert.setContentText("CONFIRM?");
                Optional<ButtonType> confirmation = alert.showAndWait();
                if (confirmation.get() == ButtonType.OK) {
                    String time = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
                    ReceiveMail mail = new ReceiveMail(selectedMail.getSender(), selectedMail.getUsername(), selectedMail.getCompany(), selectedMail.getRoomnum(), selectedMail.getSize(), time, officestockbtn.getValue());
                    receivemaillist.addItem(mail);
                    receiveMailData.setMaillist(receivemaillist);
                    maillist.removeItem(selectedMail);
                    this.mailData.setMaillist(maillist);
                    clearData();
                    tablestockmail.refresh();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Incorrect");
                alert.setContentText("Incorrect username or password.");
                alert.showAndWait();
            }
        }
    }
}