import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RouletteController {

    @FXML
    private Label totalID;

    @FXML
    private Label redID;

    @FXML
    private Label blackID;

    @FXML
    private Label greenID;

    @FXML
    private Label greenPercentID;

    @FXML
    private Label blackPercentID;

    @FXML
    private Label redPercentID;

    @FXML
    private ListView<Integer> lastNumbersID;

    public void init(Roulette roulette) {
        redID.textProperty().bind(roulette.redProperty().asString());
        greenID.textProperty().bind(roulette.greenProperty().asString());
        blackID.textProperty().bind(roulette.blackProperty().asString());
        totalID.textProperty().bind(roulette.numMatchesProperty().asString());
        lastNumbersID.itemsProperty().bind(roulette.getLastNumbers());

        lastNumbersID.setCellFactory(list -> new ListCell<Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item + "");
                    if (item == 0) setStyle("-fx-background-color: #00f315;");
                    else if (((item - 1) / 3) % 2 == 0) setStyle("-fx-background-color: #f30016;");
                    else setStyle("-fx-background-color: #000000; -fx-text-fill: #ffffff");

                }
            }
        });

        greenID.textProperty().addListener((ov, n, o) -> {
            double actual = roulette.greenProperty().get();
            double total = roulette.getNumMatches();
            double percent = round((actual/total) * 100);
            greenPercentID.setText(percent + "%");
        });

        redID.textProperty().addListener((ov, n, o) -> {
            double actual = roulette.redProperty().get();
            double total = roulette.getNumMatches();
            double percent = round((actual/total) * 100);
            redPercentID.setText(percent + "%");
        });

        blackID.textProperty().addListener((ov, n, o) -> {
            double actual = roulette.blackProperty().get();
            double total = roulette.getNumMatches();
            double percent = round((actual/total) * 100);
            blackPercentID.setText(percent + "%");
        });

    }

    private static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
