import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Mail {
    @FXML MenuButton levelmailbtn;
    @FXML MenuItem option1mailbtn,option2mailbtn,option3mailbtn;
    @FXML TextField Sizemailbtn,namemailbtn,roommailbtn,floormailbtn,companymailbtn,hourmailbtn,minutemailbtn,sendermailbtn;
    @FXML Button Backmailbtn,Summitmailbtn;

    @FXML public void BackMailBtnOnAcTion(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_Backmail = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Central.fxml"));
        stage_Backmail.setScene(new Scene(loader.load(), 882, 390));
        stage_Backmail.show();}

    @FXML public void  option1mailbtnonaction(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        option1mailbtn.setText(menuItem.getText());
    }

    @FXML public void  option2mailbtnonaction(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        option2mailbtn.setText(menuItem.getText());
    }

    @FXML public void  option3mailbtnonaction(ActionEvent event) throws  IOException{
        MenuItem menuItem = (MenuItem) event.getSource();
        option3mailbtn.setText(menuItem.getText());
    }
}
