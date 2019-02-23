import component.GridTable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CasinoController implements Initializable{

    @FXML
    private Button betingID;

    @FXML
    private TextField betID;

    @FXML
    private TextField moneyID;

    @FXML
    private Label actualMoneyID;

    @FXML
    private StackPane tabID;

    @FXML
    private Pane paneID;

    @FXML
    private Pane oneHalfID;

    @FXML
    private Pane evenID;

    @FXML
    private Pane redID;

    @FXML
    private Pane blackID;

    @FXML
    private Pane oddID;

    @FXML
    private Pane twoHalfID;

    @FXML
    private Pane firstColumID;

    @FXML
    private Pane secondColumID;

    @FXML
    private Pane thirdtColumID;

    @FXML
    private Label numberID;

    private GridPane grid;

    private void addPane(int col, int row) {
        Pane p = new Pane();
        if (col % 2 != 0) {
            p.setPrefSize(14, 14);
            //p.setStyle("-fx-background-color: #f44336;");
        } else {
            p.setPrefSize(30, 14);
            //p.setStyle("-fx-background-color: #15f400;");
        }
        p.setOnMouseClicked(event -> {
            //p.setStyle("-fx-opacity: 0;");
            System.out.println(col + " + " + row);
            System.out.println(p);
            //System.out.println(p.getChildren().toString());
            //System.out.println(grid.getChildren().get((col+1) * (row+1)));

            Circle c = new Circle(13,30,10, Paint.valueOf("#FFD700"));
            String estado = "nada";
            System.out.println(estado);
            /*if (getNode(col, row) != null) {
                grid.getChildren().remove(getNode(col, row));
            } else {*/
                if (col == 0 && row < 5) { // 0
                    GridPane.setConstraints(c, 0, 2);
                    grid.getChildren().add(c);
                    estado = "lleno";
                } else if (row == 5) {
                    if (col > 0 && col < 9) { //1rd
                        GridPane.setConstraints(c, 5, 5);
                        grid.getChildren().add(c);
                    } else if (col > 8 && col < 17) { //2rd
                        GridPane.setConstraints(c, 13, 5);
                        grid.getChildren().add(c);
                    } else if (col > 16 && col < 25) { //3rd
                        GridPane.setConstraints(c, 21, 5);
                        grid.getChildren().add(c);
                    }

                } else if (row == 6) {
                    if (col > 0 && col < 5) { //1-18
                        GridPane.setConstraints(c, 3, 6);
                        grid.getChildren().add(c);
                    } else if (col > 4 && col < 9) { //even
                        GridPane.setConstraints(c, 7, 6);
                        grid.getChildren().add(c);
                    } else if (col > 8 && col < 13) { //red
                        GridPane.setConstraints(c, 11, 6);
                        grid.getChildren().add(c);
                    } else if (col > 12 && col < 17) { //black
                        GridPane.setConstraints(c, 15, 6);
                        grid.getChildren().add(c);
                    } else if (col > 16 && col < 21) { //odd
                        GridPane.setConstraints(c, 19, 6);
                        grid.getChildren().add(c);
                    } else if (col > 20 && col < 25) { //19-36
                        GridPane.setConstraints(c, 23, 6);
                        grid.getChildren().add(c);
                    }
                }
            for (int i = 0; i < grid.getChildren().size(); i++) {
                System.out.println(i + ": " + grid.getChildren().get(i));

            }


        });

        GridPane.setConstraints(p, col, row);
        grid.getChildren().add(p);
    }

    private Node getNode(int col, int row) {

        grid.getChildren().get(col*7 + row);

        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.getColumnConstraints().add(new ColumnConstraints(42));
        for (int i = 1; i < 26; i++) {
            if (i%2 != 0) {
                grid.getColumnConstraints().add(new ColumnConstraints(14));
            } else {
                grid.getColumnConstraints().add(new ColumnConstraints(30));
            }
        }
        grid.getColumnConstraints().add(new ColumnConstraints(34));
        grid.getRowConstraints().add(new RowConstraints(64));
        grid.getRowConstraints().add(new RowConstraints(15));
        grid.getRowConstraints().add(new RowConstraints(54));
        grid.getRowConstraints().add(new RowConstraints(15));
        grid.getRowConstraints().add(new RowConstraints(56));
        grid.getRowConstraints().add(new RowConstraints(55));
        grid.getRowConstraints().add(new RowConstraints(56));

        for (int i = 0; i < 28; i++)
            for (int j = 0; j < 7; j++)
                addPane(i, j);


        tabID.getChildren().add(grid);*/

        redID.setOnMouseClicked(event -> {

        });


        Player player = new Player(100);
        Roulette roulette = new Roulette();
        Stage stageRoulette = new Stage();
        FXMLLoader loadRoulette = new FXMLLoader(getClass().getResource("roulette.fxml"));
        Parent rootRoulette = null;
        try {
            rootRoulette = loadRoulette.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RouletteController controllerRoulette = loadRoulette.getController();
        controllerRoulette.init(roulette);
        Scene sceneRoulette = new Scene(rootRoulette);
        stageRoulette.setScene(sceneRoulette);
        stageRoulette.setTitle("Stats");
        stageRoulette.setX(300);
        //stageRoulette.show();

        betingID.setOnAction(event -> {
            //if (betID.getText().isEmpty()) {}
            //if (moneyID.getText().isEmpty()) {}

            double pay = Double.parseDouble(moneyID.getText());
            String t = betID.getText();
            roulette.spin();
            String i = Integer.toString(roulette.getActualNumber());
            if(t.equals(i)) {
                player.payment(pay);
            } else if(t.equals("Red") || t.equals("Black")) {
                String color = Roulette.color(Integer.parseInt(i));
                if(t.equals(color)) {
                    player.payment(pay);
                } else {
                    player.payment(-pay);
                }
            } else {
                player.payment(-pay);
            }
            numberID.setText(roulette.getActualNumber() + "");
            actualMoneyID.setText(player.getMoney() + "€");
        });
    }
}