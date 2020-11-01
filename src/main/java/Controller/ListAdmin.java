package Controller;

import Model.CentralOfficer;
import Service.CentralOfficerData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ListAdmin {
    @FXML
    Label namebtn,surnamebtn;
    @FXML Button HomeAdminbtn,Useradminsystembtn,banbtn,unbanbtn;
    @FXML
    TableView<CentralOfficer> table;
    private CentralOfficer centralOfficer,selectedCentral;
    private CentralOfficerData centralOfficerData;
    private ObservableList<CentralOfficer> list;

    public void initialize(){
        banbtn.setDisable(true);
        unbanbtn.setDisable(true);
        centralOfficer = new CentralOfficer();
        centralOfficerData = new CentralOfficerData("data","CentralOfficer.csv");
        centralOfficer = centralOfficerData.getCentralList();
        Platform .runLater(new Runnable() {
            @Override
            public void run() {
                if(!centralOfficer.getUserList().isEmpty()){
                    showData();
                }
            }
        });
        table.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue != null){
                showCentralData(newValue);
            }
        }));
    }
    @FXML public void HomeAdminBtnOnAction(ActionEvent event) throws IOException {
        Button a = (Button) event.getSource();
        Stage stage_ProfilePage = (Stage) a.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Homepage.fxml"));
        stage_ProfilePage.setScene(new Scene(loader.load(), 882, 390));
        stage_ProfilePage.show();
    }
    @FXML public void UserAdminSystemBtnOnAction(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage_useradminsystem = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/NewUserCentral.fxml"));
        stage_useradminsystem.setScene(new Scene(loader.load(), 882, 390));
        stage_useradminsystem.show();}
    @FXML public void banbtnonaction(ActionEvent event) throws IOException {
        selectedCentral.setStatus("Banned");
        centralOfficerData.setCentralList(centralOfficer);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Ban");
        alert.setContentText("User has been banned");
        alert.showAndWait();
        clearData();
        Button b = (Button) event.getSource();
        Stage stage_AdminloginPage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ListAdmin.fxml"));
        stage_AdminloginPage.setScene(new Scene(loader.load(), 882, 390));
        stage_AdminloginPage.show();
    }
    @FXML public void unbanbtnonaction(ActionEvent event) throws IOException {
        selectedCentral.setStatus("Access");

        selectedCentral.setAttempt(0);
        centralOfficerData.setCentralList(centralOfficer);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Unban");
        alert.setContentText("User has been unban");
        alert.showAndWait();
        clearData();
        Button b = (Button) event.getSource();
        Stage stage_AdminloginPage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ListAdmin.fxml"));
        stage_AdminloginPage.setScene(new Scene(loader.load(), 882, 390));
        stage_AdminloginPage.show();
    }




    public void showData(){
        list = FXCollections.observableList(centralOfficer.getUserList());
        table.setItems(list);

        TableColumn username = new TableColumn("USERNAME");
        username.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("username"));
        TableColumn password = new TableColumn("PASSWORD");
        password.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("password"));
        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("name"));
        TableColumn surname = new TableColumn("SURNAME");
        surname.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("surname"));
        TableColumn time = new TableColumn("TIME");
        time.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("time"));
        TableColumn status = new TableColumn("STATUS");
        status.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("status"));
        TableColumn attempt = new TableColumn("ATTEMPT");
        attempt.setCellValueFactory(new PropertyValueFactory<CentralOfficer,String>("attempt"));

        time.setSortType(TableColumn.SortType.DESCENDING);
        table.getColumns().addAll(name,surname,username,password,time,status,attempt);
        table.getSortOrder().add(time);

    }
    public void showCentralData(CentralOfficer central){
        selectedCentral = central;
        namebtn.setText(central.getName());
        surnamebtn.setText(central.getSurname());
        banbtn.setDisable(false);
        unbanbtn.setDisable(false);
    }

    public void clearData(){
        selectedCentral = null;
        namebtn.setText("-");
        surnamebtn.setText("-");
        banbtn.setDisable(true);
        unbanbtn.setDisable(true);

    }
}
