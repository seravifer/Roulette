package component;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class GridTable extends GridPane {

    private GridPane gridPane;

    public GridTable() {
        gridPane = new GridPane();

        makeTable();
    }

    private void makeTable() {
        gridPane.getColumnConstraints().add(new ColumnConstraints(42));
        for (int i = 1; i < 26; i++) {
            if (i%2 != 0) {
                gridPane.getColumnConstraints().add(new ColumnConstraints(14));
            } else {
                gridPane.getColumnConstraints().add(new ColumnConstraints(30));
            }
        }
        gridPane.getColumnConstraints().add(new ColumnConstraints(34));
        gridPane.getRowConstraints().add(new RowConstraints(64));
        gridPane.getRowConstraints().add(new RowConstraints(15));
        gridPane.getRowConstraints().add(new RowConstraints(54));
        gridPane.getRowConstraints().add(new RowConstraints(15));
        gridPane.getRowConstraints().add(new RowConstraints(58));
        gridPane.getRowConstraints().add(new RowConstraints(55));
        gridPane.getRowConstraints().add(new RowConstraints(60));
        gridPane.setGridLinesVisible(true);
        System.out.println(gridPane.isGridLinesVisible());
    }

}
