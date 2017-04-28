import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;

public class Player {

    private DoubleProperty money = new SimpleDoubleProperty();
    private String name;
    private ArrayList<Double> listMoney = new ArrayList<>();

    public Player(double m) {
        super();

        money.set(m);
        name = "Player";

        listMoney.add(money.get());
    }

    public Player(String s, double m) {
        super();

        name = s;
        money.setValue(m);

        listMoney.add(money.get());
    }

    /**
     * Problem with double and decimal
     *
     * @param value
     * @return
     */
    private static double round(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public DoubleProperty getMoneyProperty() {
        return money;
    }

    public double getMoney() {
        return money.get();
    }

    public String getName() {
        return name;
    }

    public void payment(double m) {
        Platform.runLater(() -> money.set(round(money.get() + m)));
        listMoney.add(money.get());
    }

}
