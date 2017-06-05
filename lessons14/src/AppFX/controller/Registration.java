package AppFX.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by adm on 05.06.2017.
 */
public class Registration implements Initializable {
    DbConnect dbConnect = new DbConnect();
    @FXML
    TextField email;
    @FXML
    PasswordField pass;

    @FXML
    public void buttonReg(ActionEvent actionEvent) throws SQLException, IOException {
        final boolean found = dbConnect.findByDbTable(email.getText());
        if (found) {
            showDialog();


        } else {
            String newUsers = "('" + email.getText() + "', '" + pass.getText() + "')";
            dbConnect.createNewUserDbTable(newUsers);
            dbConnect.getDBConnection().close();
            secondStageLoad();
        }
    }

    @FXML
    public void logInButton(ActionEvent actionEvent) throws IOException {
        secondStageLoad();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbConnect.dBCheck();
        dbConnect.getDBConnection();

        try {
            dbConnect.createDbUserTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void showDialog() {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle("Инфо");
        dialog.setHeaderText("Пользователь существует." + "\n" + "Введите другой Email");
        dialog.showAndWait();
    }
// этот метод неработает
    private void secondStageLoad() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("autorize.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

   }

