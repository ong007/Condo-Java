package Controller;

import Model.CentralOfficer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StockItem {
    @FXML
    Button backstockbtn;
    @FXML
    AnchorPane showlistreceive, liststock;
    @FXML
    ComboBox<String> selectlist;
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
                        liststock = FXMLLoader.load(getClass().getResource("/StockText.fxml"));
                    } else if (selectlist.getValue().equals("mail")) {
                        liststock = FXMLLoader.load(getClass().getResource("/StockMail.fxml"));
                    } else if (selectlist.getValue().equals("box")) {
                        liststock = FXMLLoader.load(getClass().getResource("/StockBox.fxml"));
                    }
                    showlistreceive.getChildren().setAll(liststock);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    public void backstockbtnonaction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_backstock = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomeCheckMessage.fxml"));
        stage_backstock.setScene(new Scene(loader.load(), 882, 390));
        stage_backstock.show();
    }

}