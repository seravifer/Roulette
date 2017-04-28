import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class AppController implements Initializable {

    public boolean status;
    @FXML
    private ChoiceBox<String> moveID;
    @FXML
    private Button playID;
    @FXML
    private TextField parameterID;
    @FXML
    private Button stopID;
    @FXML
    private TextField nameID;
    @FXML
    private TextField moneyID;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        moveID.setItems(FXCollections.observableArrayList("James Bond", "Martingala", "Martingala inversa", "Alembert", "Fibonacci", "Pins"));

        playID.setOnMouseClicked(event -> {

            Player p = new Player(nameID.getText(), Integer.parseInt(moneyID.getText()));

            Stage stagePlayer = new Stage();
            FXMLLoader loadPLayer = new FXMLLoader(getClass().getResource("player.fxml"));
            Parent rootPlayer = null;
            try {
                rootPlayer = loadPLayer.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            PlayerController controllerPLayer = loadPLayer.getController();
            controllerPLayer.init(p);
            Scene scene = new Scene(rootPlayer);
            stagePlayer.setScene(scene);
            stagePlayer.setX(0);
            stagePlayer.show();


            Roulette r = new Roulette();
            Stage stageRoulette = new Stage();
            FXMLLoader loadRoulette = new FXMLLoader(getClass().getResource("roulette.fxml"));
            Parent rootRoulette = null;
            try {
                rootRoulette = loadRoulette.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            RouletteController controllerRoulette = loadRoulette.getController();
            controllerRoulette.init(r);
            Scene sceneRoulette = new Scene(rootRoulette);
            stageRoulette.setScene(sceneRoulette);
            stageRoulette.setX(300);
            stageRoulette.show();


            Simulator s = new Simulator(p, r);
            status = true;

            new Thread(() -> {
                while (p.getMoney()>=0 && status) {

                    r.spin();
                    switch (moveID.getValue()) {
                        case "James Bond":
                            s.bond(1);
                            break;
                        case "Martingala":
                            s.martingala("Black");
                            break;
                        case "Martingala inversa":
                            s.martingalaInverse("Black");
                            break;
                        case "Alembert":
                            s.alembert("Black");
                            break;
                        case "Fibonacci":
                            s.fibonacci("Black");
                            break;
                        case "Pins":
                            s.pins();
                            break;
                    }

                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Platform.runLater(() -> {
                    stagePlayer.close();
                    stageRoulette.close();
                });
            }).start();
        });

        stopID.setOnAction(event -> status = false);

    }

}
