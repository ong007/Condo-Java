package Controller;

import Model.Consumerreader;
import Model.Item;
import Model.Textreader;
import Service.Boxdatasource;
import Service.Consumerdatasource;
import Service.TextDataSource;
import com.sun.glass.ui.Size;
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
    private Consumerdatasource consumerdata;
    private Consumerreader consumerlist;
    private TextDataSource textdata;
    private Textreader textlist;
    private Item item;
    public void initialize(){
        item = new Item();
        textlist = new Textreader();
        textdata = new TextDataSource("data","/text.csv");
        textlist = textdata.getTextlist();
        consumerdata = new Consumerdatasource("data","Consumerdata.csv");
        consumerlist = consumerdata.getConsumerList();
        for (Consumerreader consumerreader1: consumerlist.getUserList()){

            roomconsumertextbtn.getItems().add(consumerreader1.getName() + " : " + consumerreader1.getRoomnum());

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
            //Textreader textreader = new Textreader(nametextbtn.getText(),sendertextbtn.getText(),Sizetextbtn.getText(),companytextbtn.getText(),leveltextbtn.getText(),roomconsumertextbtn.getValue(),time);
            Textreader textReader = new Textreader(sendertextbtn.getText(),nametextbtn.getText(), Sizetextbtn.getText(),companytextbtn.getText(),roomNum[1],time,leveltextbtn.getText());
            textlist.add(textReader);
            item.add(textReader);
            textdata.setTextlist(textlist);
            Button a = (Button) event.getSource();
            Stage stage_summitconsumer = (Stage) a.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
            stage_summitconsumer.setScene(new Scene(loader.load(), 882, 390));
            stage_summitconsumer.show();}
    }
}
