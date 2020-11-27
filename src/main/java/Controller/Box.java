package Controller;

import Model.BucketCustomer;
import Model.BucketItem;
import Model.CustomerReader;

import Model.Item;
import Service.BoxData;
import Service.CustomerData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Box {
    @FXML ComboBox<String> roomnumboxbtn;
    @FXML MenuButton levelboxbtn;
    @FXML MenuItem option1boxbtn,option2boxbtn,option3boxbtn;
    @FXML TextField sizeboxbtn,nameboxbtn,companyboxbtn,trackingboxbtn,senderboxbtn;
    @FXML Button Backboxbtn,Summitboxbtn;
    private BoxData boxdata;
    private BucketItem boxlist;
    private Item item;
    private CustomerData consumerdata;
    private BucketCustomer consumerlist;

    public void initialize(){
        item = new Item();
        boxlist = new BucketItem();
        boxdata = new BoxData("data","/Box.csv");
        boxlist = boxdata.getBoxlist();

        consumerdata = new CustomerData("data","Customer.csv");
        consumerlist = consumerdata.getConsumerList();
        for (CustomerReader customerReader1 : consumerlist.getBucketCustomer()){

            roomnumboxbtn.getItems().add(customerReader1.getName() + " : " + customerReader1.getRoomnum());

        }
    }

    @FXML public void BackBoxBtnOnAcTion(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_Backbox = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
        stage_Backbox.setScene(new Scene(loader.load(), 882, 390));
        stage_Backbox.show();}

    @FXML public void  option1boxbtnonaction(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        levelboxbtn.setText(menuItem.getText());
    }

    @FXML public void  option2boxbtnonaction(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        levelboxbtn.setText(menuItem.getText());
    }

    @FXML public void  option3boxbtnonaction(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        levelboxbtn.setText(menuItem.getText());
    }


    public void Summitboxbtnonaction(ActionEvent event) throws IOException {
            if(sizeboxbtn.getText().equals("") || nameboxbtn.getText().equals("") || trackingboxbtn.getText().equals("") || senderboxbtn.getText().equals("") || companyboxbtn.getText().equals("") || roomnumboxbtn.getValue() == null || levelboxbtn.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("ERROR");
                alert.setContentText("Please filling all information.");
                alert.showAndWait();}
            else {
                String time = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
                String[] roomNum = roomnumboxbtn.getValue().split(" : ");

                Model.Box boxReader = new Model.Box(nameboxbtn.getText(),senderboxbtn.getText(),sizeboxbtn.getText(),companyboxbtn.getText(),roomNum[1],time,levelboxbtn.getText(),trackingboxbtn.getText());
                boxlist.addItem(boxReader);
                item.add(boxReader);
                boxdata.setBoxlist(boxlist);
                Button a = (Button) event.getSource();
                Stage stage_summitconsumer = (Stage) a.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
                stage_summitconsumer.setScene(new Scene(loader.load(), 882, 390));
                stage_summitconsumer.show();}
        }
}
