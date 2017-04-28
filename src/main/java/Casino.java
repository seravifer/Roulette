import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Casino extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("casino.fxml"));
            Parent root = miCargador.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Casino");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}