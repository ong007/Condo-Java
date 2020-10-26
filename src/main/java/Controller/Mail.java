package Controller;

import Model.Consumerreader;
import Model.Mailreader;

import Service.Consumerdatasource;
import Service.MailDataSource;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Mail {

    @FXML ComboBox<String> roomconsumermailbtn;
    @FXML TextField sizemailbtn,namemailbtn,sendermailbtn,companymailbtn;
    @FXML Button Backmailbtn,Summitmailbtn;

    private MailDataSource maildata;
    private Mailreader maillist,nowmail;
    private Consumerdatasource consumerdata;
    private Consumerreader consumerlist;

    public void initialize(){
        maillist = new Mailreader();
        maildata = new MailDataSource("data","/mail.csv");
        maillist = maildata.getMaillist();
        consumerdata = new Consumerdatasource("data","Consumerdata.csv");
        consumerlist = consumerdata.getConsumerList();
        for (Consumerreader consumerreader1: consumerlist.getUserList()){

            roomconsumermailbtn.getItems().add(consumerreader1.getName() + " : " + consumerreader1.getRoomnum());

        }
    }

    @FXML public void BackmailBtnOnAcTion(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_Backtext = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
        stage_Backtext.setScene(new Scene(loader.load(), 882, 390));
        stage_Backtext.show();}


    public void Summitmailbtnonaction(ActionEvent event) throws IOException {
        if(sizemailbtn.getText().equals("") || namemailbtn.getText().equals("") || sendermailbtn.getText().equals("") || companymailbtn.getText().equals("")  || roomconsumermailbtn.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText("Please filling all information.");
            alert.showAndWait();}
        else{
            String time = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(Calendar.getInstance().getTime());
            String[] roomNum = roomconsumermailbtn.getValue().split(" : ");
            Mailreader mailreader = new Mailreader(namemailbtn.getText(),sendermailbtn.getText(),sizemailbtn.getText(),companymailbtn.getText(),roomNum[1],time);
            maillist.add(mailreader);
            maildata.setMaillist(maillist);
            Button a = (Button) event.getSource();
            Stage stage_summitconsumer = (Stage) a.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Central.fxml"));
            stage_summitconsumer.setScene(new Scene(loader.load(), 882, 390));
            stage_summitconsumer.show();}
    }
}
