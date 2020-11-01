package Controller;

import Model.CentralOfficer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceiveItem {
    @FXML Button backstockbtn;
    @FXML ComboBox<String> selectlist;
    @FXML AnchorPane showliststock, listreceive;
    private CentralOfficer nowCentral;

    public void setNowCentral(CentralOfficer nowCentral){
        this.nowCentral = nowCentral;
    }

    public void initialize() {
        selectlist.getItems().addAll("text", "mail", "box");
        selectlist.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (selectlist.getValue().equals("text")) {
                        listreceive = FXMLLoader.load(getClass().getResource("/ReceiveText.fxml"));
                    } else if (selectlist.getValue().equals("mail")) {
                        listreceive = FXMLLoader.load(getClass().getResource("/ReceiveMail.fxml"));
                    } else if (selectlist.getValue().equals("box")) {
                        listreceive = FXMLLoader.load(getClass().getResource("/ReceiveBox.fxml"));
                    }
                    showliststock.getChildren().setAll(listreceive);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML public void backrecievebtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backrecieve = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomeCheckMessage.fxml"));
        stage_backrecieve.setScene(new Scene(loader.load(), 882, 390));
        stage_backrecieve.show();
    }

}
