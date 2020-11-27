package Controller;

import Model.*;
import Model.ReceiveBox;
import Model.ReceiveMail;
import Service.*;
import Service.ReceiveBoxData;
import Service.ReceiveMailData;
import Service.ReceiveTextData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceiveConsumer {
    @FXML
    Button backbtn;
    @FXML private TableView<ReceiveMail> tablereceivebox;
    private ObservableList<ReceiveMail> receiveBoxObservableList;
    @FXML private TableView<ReceiveMail> tablereceivemail;
    private ObservableList<ReceiveMail> receiveMailObservableList;
    @FXML private TableView<ReceiveMail> tablereceivetext;
    private ObservableList<ReceiveMail> receiveTextObservableList;
    private ReceiveMailData receiveMailData;
    private BucketReceiveItem receiveMailList;
    private ReceiveTextData receiveTextData;
    private BucketReceiveItem receiveTextList;
    private ReceiveBoxData receiveBoxDataDataSource;
    private BucketReceiveItem receiveBoxList;
    private BucketCustomer consumerList;
    private CustomerReader consumer;
    private CustomerData customerData;
    public void setConsumer(CustomerReader consumer){
        this.consumer = consumer;
    }

    public void initialize (){
        receiveBoxDataDataSource = new ReceiveBoxData("data", "ReceiveBox.csv");
        receiveBoxList = receiveBoxDataDataSource.getReceiveboxlist();
        receiveMailData = new ReceiveMailData("data", "ReceiveMail.csv");
        receiveMailList = receiveMailData.getReceivemaillist();
        receiveTextData = new ReceiveTextData("data", "ReceiveText.csv");
        receiveTextList = receiveTextData.getReceiveTextlist();
        customerData = new CustomerData("data", "Customer.csv");
        consumerList = customerData.getConsumerList();


    }
    @FXML public void backbtnonaction (ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backconsumerhome = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CustomerHome.fxml"));
        stage_backconsumerhome.setScene(new Scene(loader.load(), 882, 390));
        CustomerHome customerHome = loader.getController();
        customerHome.setConsumer(consumer);
        stage_backconsumerhome.show();
    }

    public void showBoxData(){
        tablereceivemail.setVisible(false);
        tablereceivetext.setVisible(false);
        tablereceivebox.setVisible(true);
        tablereceivebox.getColumns().clear();
        BucketReceiveItem matchedRoomNum = receiveBoxList.getListByRoomNum(consumer.getRoomnum());
        receiveBoxObservableList = FXCollections.observableList(matchedRoomNum.getBucketReceiveItem());
        tablereceivebox.setItems(receiveBoxObservableList);

        TableColumn sender = new TableColumn("SENDER");
        sender.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("username"));
        TableColumn company = new TableColumn("company");
        company.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("roomnum"));
        TableColumn level = new TableColumn("LEVEL");
        level.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("level"));
        TableColumn size = new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("size"));
        TableColumn tracking = new TableColumn("TRACKING");
        tracking.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("tracking"));
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("time"));
        TableColumn nameofficer = new TableColumn("OFFICER");
        nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("nameofficer"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablereceivebox.getColumns().addAll(sender,username,company,roomnum,level,size,tracking,time,nameofficer);
        tablereceivebox.getSortOrder().add(roomnum);
    }

    public void showMailData(){
        tablereceivemail.setVisible(true);
        tablereceivetext.setVisible(false);
        tablereceivebox.setVisible(false);
        tablereceivemail.getColumns().clear();
        BucketReceiveItem matchedRoomNum = receiveMailList.getListByRoomNum(consumer.getRoomnum());
        receiveMailObservableList = FXCollections.observableList(matchedRoomNum.getBucketReceiveItem());
        tablereceivemail.setItems(receiveMailObservableList);

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
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("time"));
        TableColumn nameofficer = new TableColumn("OFFICER");
        nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBox,String>("nameofficer"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablereceivemail.getColumns().addAll(sender,username,company,roomnum,size,time,nameofficer);
        tablereceivemail.getSortOrder().add(roomnum);
    }

    public void showTextData(){
        tablereceivemail.setVisible(false);
        tablereceivetext.setVisible(true);
        tablereceivebox.setVisible(false);
        tablereceivetext.getColumns().clear();
        BucketReceiveItem matchedRoomNum = receiveTextList.getListByRoomNum(consumer.getRoomnum());
        receiveTextObservableList = FXCollections.observableList(matchedRoomNum.getBucketReceiveItem());
        tablereceivetext.setItems(receiveTextObservableList);

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
        tablereceivetext.getColumns().addAll(sender,username,company,roomnum,level,size,time,nameofficer);
        tablereceivetext.getSortOrder().add(roomnum);
    }

    @FXML public void textbtnonaction(ActionEvent event) throws IOException {
        showTextData();}

    @FXML public void boxbtnonaction(ActionEvent event) throws IOException {
        showBoxData();}

    @FXML public void mailbtnonaction(ActionEvent event) throws IOException {
        showMailData();}
}
