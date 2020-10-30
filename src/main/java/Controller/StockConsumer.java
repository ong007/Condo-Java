package Controller;

import Model.Boxreader;
import Model.Consumerreader;
import Model.Mailreader;
import Model.Textreader;
import Service.Boxdatasource;
import Service.Consumerdatasource;
import Service.MailDataSource;
import Service.TextDataSource;
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
import java.util.ArrayList;
import java.util.Collections;

public class StockConsumer {
    @FXML Button backbtn;
    @FXML private TableView<Boxreader> tablestockbox;
    private ObservableList<Boxreader> boxreaderObservableList;
    @FXML private TableView<Mailreader> tablestockmail;
    private ObservableList<Mailreader> mailreaderObservableList;
    @FXML private TableView<Textreader> tablestocktext;
    private ObservableList<Textreader> textreaderObservableList;
    private MailDataSource mailDataSource;
    private Mailreader maillist;
    private TextDataSource textDataSource;
    private Textreader textList;
    private Boxdatasource boxdatasource;
    private Boxreader boxList;
    private Consumerreader consumerList, consumer;
    private Consumerdatasource consumerdatasource;
    public void setConsumer(Consumerreader consumer){
        this.consumer = consumer;
    }

    public void initialize (){
        boxdatasource = new Boxdatasource("data", "box.csv");
        boxList = boxdatasource.getBoxlist();
        mailDataSource = new MailDataSource("data", "mail.csv");
        maillist = mailDataSource.getMaillist();
        textDataSource = new TextDataSource("data", "text.csv");
        textList = textDataSource.getTextlist();
        consumerdatasource = new Consumerdatasource("data", "Consumerdata.csv");
        consumerList = consumerdatasource.getConsumerList();
        //showBoxData();

    }
    @FXML public void backbtnonaction (ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backconsumerhome = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ConsumerHome.fxml"));
        stage_backconsumerhome.setScene(new Scene(loader.load(), 882, 390));
        ConsumerHome consumerHome = loader.getController();
        consumerHome.setConsumer(consumer);
        stage_backconsumerhome.show();
    }

    public void showBoxData(){
        tablestockmail.setVisible(false);
        tablestocktext.setVisible(false);
        tablestockbox.setVisible(true);
        tablestockbox.getColumns().clear();
        Boxreader matchedRoomNum = boxList.getListByRoomNum(consumer.getRoomnum());
        boxreaderObservableList = FXCollections.observableList(matchedRoomNum.getUserList());
        tablestockbox.setItems(boxreaderObservableList);

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
        tracking.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("tacking"));
        TableColumn time= new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<Boxreader,String>("time"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablestockbox.getColumns().addAll(sender,username,company,roomnum,level,size,tracking,time);
        tablestockbox.getSortOrder().add(roomnum);
    }

    public void showMailData(){
        tablestockmail.setVisible(true);
        tablestocktext.setVisible(false);
        tablestockbox.setVisible(false);
        tablestockmail.getColumns().clear();
        Mailreader matchedRoomNum = maillist.getListByRoomNum(consumer.getRoomnum());
        mailreaderObservableList = FXCollections.observableList(matchedRoomNum.getUserList());
        tablestockmail.setItems(mailreaderObservableList);

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

    public void showTextData(){
        tablestockmail.setVisible(false);
        tablestocktext.setVisible(true);
        tablestockbox.setVisible(false);
        tablestocktext.getColumns().clear();
        Textreader matchedRoomNum = textList.getListByRoomNum(consumer.getRoomnum());
        textreaderObservableList = FXCollections.observableList(matchedRoomNum.getUserList());
        tablestocktext.setItems(textreaderObservableList);

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
        tablestocktext.getColumns().addAll(sender,username,company,roomnum,level,size,time);
        tablestocktext.getSortOrder().add(roomnum);
    }

    @FXML public void textbtnonaction(ActionEvent event) throws IOException {
        showTextData();}

    @FXML public void boxbtnonaction(ActionEvent event) throws IOException {
        showBoxData();}

    @FXML public void mailbtnonaction(ActionEvent event) throws IOException {
        showMailData();}
}

