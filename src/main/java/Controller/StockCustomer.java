package Controller;

import Model.*;
import Model.Box;
import Model.Text;
import Service.BoxData;
import Service.CustomerData;
import Service.MailData;
import Service.TextData;
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
import java.util.HashMap;

public class StockCustomer {
    @FXML Button backbtn;
    @FXML private TableView<Item> tablestockbox;
    private ObservableList<Item> boxObservableList;
    @FXML private TableView<Item> tablestockmail;
    private ObservableList<Item> mailObservableList;
    @FXML private TableView<Item> tablestocktext;
    private ObservableList<Item> textObservableList;
    private MailData mailData;
    private BucketItem maillist;
    private TextData textData;
    private BucketItem textList;
    private BoxData boxData;
    private BucketItem boxList;
    private BucketCustomer consumerList;
    private CustomerReader consumer;
    private CustomerData customerData;
    public void setConsumer(CustomerReader consumer){
        this.consumer = consumer;
    }

    public void initialize (){
        boxData = new BoxData("data", "Box.csv");
        boxList = boxData.getBoxlist();
        mailData = new MailData("data", "Mail.csv");
        maillist = mailData.getMaillist();
        textData = new TextData("data", "Text.csv");
        textList = textData.getTextlist();
        customerData = new CustomerData("data", "Customer.csv");
        consumerList = customerData.getConsumerList();
        //showBoxData();

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
        tablestockmail.setVisible(false);
        tablestocktext.setVisible(false);
        tablestockbox.setVisible(true);
        tablestockbox.getColumns().clear();
        BucketItem matchedRoomNum = boxList.getListByRoomNum(consumer.getRoomnum());
        boxObservableList = FXCollections.observableList(matchedRoomNum.getBucketItem());
        tablestockbox.setItems(boxObservableList);

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

    public void showMailData(){
        tablestockmail.setVisible(true);
        tablestocktext.setVisible(false);
        tablestockbox.setVisible(false);
        tablestockmail.getColumns().clear();
        BucketItem matchedRoomNum = maillist.getListByRoomNum(consumer.getRoomnum());
        mailObservableList = FXCollections.observableList(matchedRoomNum.getBucketItem());
        tablestockmail.setItems(mailObservableList);

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

    public void showTextData(){
        tablestockmail.setVisible(false);
        tablestocktext.setVisible(true);
        tablestockbox.setVisible(false);
        tablestocktext.getColumns().clear();
        BucketItem matchedRoomNum = textList.getListByRoomNum(consumer.getRoomnum());
        textObservableList = FXCollections.observableList(matchedRoomNum.getBucketItem());
        tablestocktext.setItems(textObservableList);

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
        tablestocktext.getColumns().addAll(sender,username,company,roomnum,level,size,time);
        tablestocktext.getSortOrder().add(roomnum);
    }

    @FXML public void textbtnonaction(ActionEvent event) throws IOException {
        showTextData();
    }

    @FXML public void boxbtnonaction(ActionEvent event) throws IOException {
        showBoxData();
    }

    @FXML public void mailbtnonaction(ActionEvent event) throws IOException {
        showMailData();
    }

}

