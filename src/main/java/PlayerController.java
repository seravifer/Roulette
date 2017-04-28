import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerController {

    @FXML
    private Label nameID;

    @FXML
    private Label moneyID;

    public void init(Player p) {
        nameID.setText(p.getName());
        moneyID.textProperty().bind(p.getMoneyProperty().asString());
    }

}
