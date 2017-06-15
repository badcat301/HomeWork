package AppFX.view;

import AppFX.controller.Autorize;
import AppFX.controller.Registration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by adm on 05.06.2017.
 */
public class StartFxApp extends Application {


    public static void main(String[] args) {
        launch(args);
        // controller.DbConnect dbConnect = new DbConnect();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(this.getClass().getResource("registration.fxml"));
        Pane pane = (Pane) fxmlLoader.load();

//эта хрень дает закрыть окно регистрации
       Registration controller = (Registration) fxmlLoader.getController();
      controller.setPrevStage(primaryStage);





        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Registration");
        primaryStage.show();
    }


}

