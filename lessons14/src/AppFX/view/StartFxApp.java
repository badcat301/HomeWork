package AppFX.view;

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
        //fxmlLoader.setLocation(this.getClass().getResource("autorize.fxml"));
        Pane pane = (Pane) fxmlLoader.load();

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Registration");
        primaryStage.show();
    }



}

