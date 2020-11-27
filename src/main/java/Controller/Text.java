package Controller;

import Model.BucketCustomer;
import Model.BucketItem;
import Model.CustomerReader;
import Model.Item;
import Service.CustomerData;
import Service.TextData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Text {
    @FXML
    ComboBox<String> roomconsumertextbtn;
    @FXML MenuButton leveltextbtn;
    @FXML MenuItem option1textbtn,option2textbtn,option3textbtn;
    @FXML TextField nametextbtn,Sizetextbtn,sendertextbtn,companytextbtn;
    @FXML Button Backtextbtn,Summittextbtn;
    private CustomerData consumerdata;
    private BucketCustomer consumerlist;
    private TextData textdata;
    private BucketItem textlist;
    private Item item;
    public void initialize(){
        item = new Item();
        textlist = new BucketItem();
        textdata = new TextData("data","/Text.csv");
        textlist = textdata.getTextlist();
        consumerdata = new CustomerData("data","Customer.csv");
        consumerlist = consumerdata.getConsumerList();
        for (CustomerReader customerReader1 : consumerlist.getBucketCustomer()){

            roomconsumertextbtn.getItems().add(customerReader1.getName() + " : " + customerReader1.getRoomnum());

        }
    }

    @FXML public void BackTextBtnOnAcTion(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_Backmail = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
        stage_Backmail.setScene(new Scene(loader.load(), 882, 390));
        stage_Backmail.show();}

    @FXML public void  option1boxbtnonaction(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        leveltextbtn.setText(menuItem.getText());
    }

    @FXML public void  option2boxbtnonaction(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        leveltextbtn.setText(menuItem.getText());
    }

    @FXML public void  option3boxbtnonaction(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        leveltextbtn.setText(menuItem.getText());
    }
    public void Summittextbtnonaction(ActionEvent event) throws IOException {
        if(Sizetextbtn.getText().equals("") || nametextbtn.getText().equals("") || sendertextbtn.getText().equals("") || companytextbtn.getText().equals("") || leveltextbtn.getText().equals("") || roomconsumertextbtn.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please filling all information.");
            alert.showAndWait();}
        else{
            String time = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
            String[] roomNum = roomconsumertextbtn.getValue().split(" : ");
            Model.Text textReader = new Model.Text(nametextbtn.getText(),sendertextbtn.getText(), Sizetextbtn.getText(),companytextbtn.getText(),roomNum[1],time,leveltextbtn.getText());
            textlist.addItem(textReader);
            item.add(textReader);
            textdata.setTextlist(textlist);
            Button a = (Button) event.getSource();
            Stage stage_summitconsumer = (Stage) a.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
            stage_summitconsumer.setScene(new Scene(loader.load(), 882, 390));
            stage_summitconsumer.show();}
    }
}
