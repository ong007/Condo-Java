package Controller;

import Model.Boxreader;
import Service.Boxdatasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Box {
    @FXML ComboBox<String> roomboxbtn,floorboxbtn;
    @FXML MenuButton levelboxbtn;
    @FXML MenuItem option1boxbtn,option2boxbtn,option3boxbtn;
    @FXML TextField sizeboxbtn,nameboxbtn,companyboxbtn,hourboxbtn,minuteboxbtn,trackingboxbtn,senderboxbtn;
    @FXML Button Backboxbtn,Summitboxbtn;
    private Boxdatasource boxdata;
    private Boxreader boxlist;

    public void initialize(){
        boxlist = new Boxreader();
        boxdata = new Boxdatasource("data","/box.csv");
        boxlist = boxdata.getBoxlist();
        roomboxbtn.getItems().addAll("STANDARD","LUXURY");
        floorboxbtn.getItems().addAll("1","2","3","4","5","6","7","8");
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

            //centraldata = new Service.CentralFileDataSource("data", "Service.Centraldata.csv");
            //centralList = centraldata.getCentralList();
            Boxreader boxreader = new Boxreader(nameboxbtn.getText(),senderboxbtn.getText(),sizeboxbtn.getText(),companyboxbtn.getText(),levelboxbtn.getText(),floorboxbtn.getValue(), roomboxbtn.getValue(),hourboxbtn.getText(),minuteboxbtn.getText(),trackingboxbtn.getText());
            boxlist.add(boxreader);
            boxdata.setBoxlist(boxlist);
            Button a = (Button) event.getSource();
            Stage stage_summitconsumer = (Stage) a.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
            stage_summitconsumer.setScene(new Scene(loader.load(), 882, 390));
            stage_summitconsumer.show();
        }
}
