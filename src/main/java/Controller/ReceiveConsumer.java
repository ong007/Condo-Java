package Controller;

import Model.*;
import Service.*;
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
    @FXML private TableView<ReceiveBoxReader> tablereceivebox;
    private ObservableList<ReceiveBoxReader> receiveBoxReaderObservableList;
    @FXML private TableView<ReceiveMailReader> tablereceivemail;
    private ObservableList<ReceiveMailReader> receiveMailReaderObservableList;
    @FXML private TableView<ReceiveTextReader> tablereceivetext;
    private ObservableList<ReceiveTextReader> receiveTextReaderObservableList;
    private ReceiveMailDataSource receiveMailDataSource;
    private ReceiveMailReader receiveMailList;
    private ReceiveTextDataSource receiveTextDataSource;
    private ReceiveTextReader receiveTextList;
    private ReceiveBoxDataSource receiveBoxDataSource;
    private ReceiveBoxReader receiveBoxList;
    private Consumerreader consumerList, consumer;
    private Consumerdatasource consumerdatasource;
    public void setConsumer(Consumerreader consumer){
        this.consumer = consumer;
    }

    public void initialize (){
        receiveBoxDataSource = new ReceiveBoxDataSource("data", "checkreceivebox.csv");
        receiveBoxList = receiveBoxDataSource.getReceiveboxlist();
        receiveMailDataSource = new ReceiveMailDataSource("data", "checkreceivemail.csv");
        receiveMailList = receiveMailDataSource.getReceivemaillist();
        receiveTextDataSource = new ReceiveTextDataSource("data", "checkreceivetext.csv");
        receiveTextList = receiveTextDataSource.getReceiveTextlist();
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
        tablereceivemail.setVisible(false);
        tablereceivetext.setVisible(false);
        tablereceivebox.setVisible(true);
        tablereceivebox.getColumns().clear();
        ReceiveBoxReader matchedRoomNum = receiveBoxList.getListByRoomNum(consumer.getRoomnum());
        receiveBoxReaderObservableList = FXCollections.observableList(matchedRoomNum.getUserListBox());
        tablereceivebox.setItems(receiveBoxReaderObservableList);

        TableColumn sender = new TableColumn("SENDER");
        sender.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("username"));
        TableColumn company = new TableColumn("company");
        company.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("roomnum"));
        TableColumn level = new TableColumn("LEVEL");
        level.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("level"));
        TableColumn size = new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("size"));
        TableColumn tracking = new TableColumn("TRACKING");
        tracking.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("tracking"));
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("time"));
        TableColumn nameofficer = new TableColumn("OFFICER");
        nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("nameofficer"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablereceivebox.getColumns().addAll(sender,username,company,roomnum,level,size,tracking,time,nameofficer);
        tablereceivebox.getSortOrder().add(roomnum);
    }

    public void showMailData(){
        tablereceivemail.setVisible(true);
        tablereceivetext.setVisible(false);
        tablereceivebox.setVisible(false);
        tablereceivemail.getColumns().clear();
        ReceiveMailReader matchedRoomNum = receiveMailList.getListByRoomNum(consumer.getRoomnum());
        receiveMailReaderObservableList = FXCollections.observableList(matchedRoomNum.getUserList1());
        tablereceivemail.setItems(receiveMailReaderObservableList);

        TableColumn sender = new TableColumn("SENDER");
        sender.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("username"));
        TableColumn company = new TableColumn("company");
        company.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("roomnum"));
        TableColumn size = new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("size"));
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("time"));
        TableColumn nameofficer = new TableColumn("OFFICER");
        nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("nameofficer"));

        roomnum.setSortType(TableColumn.SortType.ASCENDING);
        tablereceivemail.getColumns().addAll(sender,username,company,roomnum,size,time,nameofficer);
        tablereceivemail.getSortOrder().add(roomnum);
    }

    public void showTextData(){
        tablereceivemail.setVisible(false);
        tablereceivetext.setVisible(true);
        tablereceivebox.setVisible(false);
        tablereceivetext.getColumns().clear();
        ReceiveTextReader matchedRoomNum = receiveTextList.getListByRoomNum(consumer.getRoomnum());
        receiveTextReaderObservableList = FXCollections.observableList(matchedRoomNum.getUserList1());
        tablereceivetext.setItems(receiveTextReaderObservableList);

        TableColumn sender = new TableColumn("SENDER");
        sender.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("sender"));
        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("username"));
        TableColumn company = new TableColumn("company");
        company.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("company"));
        TableColumn roomnum = new TableColumn("ROOM NUMBER");
        roomnum.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("roomnum"));
        TableColumn size = new TableColumn("SIZE");
        size.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("size"));
        TableColumn level = new TableColumn("LEVEL");
        level.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("level"));
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("time"));
        TableColumn nameofficer = new TableColumn("OFFICER");
        nameofficer.setCellValueFactory(new PropertyValueFactory<ReceiveBoxReader,String>("nameofficer"));

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
