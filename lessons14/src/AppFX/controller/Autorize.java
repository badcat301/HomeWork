package AppFX.controller;

import AppFX.repository.DbConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by adm on 05.06.2017.
 */
public class Autorize implements Initializable {

    @FXML
    TextField emailLogInTextF;

    @FXML
    PasswordField passLogInPassF;

    Registration registration = new Registration();
    DbConnect dbConnect = new DbConnect();

    public void sInButton(ActionEvent actionEvent) throws IOException {

        goBack();

    }

    public void lInButton(ActionEvent actionEvent) throws SQLException, IOException {
        final boolean found = dbConnect.findByDbTable(emailLogInTextF.getText());
        if (found) {

            openMainShop();
        } else {
            showDialog();
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sqliteWork();
    }

    private void sqliteWork() {
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
        dialog.setHeaderText("Пользователь не существует." + "\n" + "Пожалуйста зарегистрируйтесть!");
        dialog.showAndWait();
    }

    public void goBack() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/registration.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

    }
    private void openMainShop() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/mainShop.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.setTitle("Shop");
        stage.setResizable(false);
        stage.show();
    }

}
