import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

import java.util.*;

public class Roulette {

    // Number of occurrences of each number (0 - 37).
    private Map<Integer, Integer> numbers = new HashMap<>();

    // List of apparitions in order.
    private ListProperty<Integer> listNumbers = new SimpleListProperty<>();
    public List<Integer> arrayNumbers = new ArrayList<>();

    // Matches
    private IntegerProperty numMatches = new SimpleIntegerProperty(0);

    // Types of numbers
    private IntegerProperty green = new SimpleIntegerProperty(0);
    private IntegerProperty red = new SimpleIntegerProperty(0);
    private IntegerProperty black = new SimpleIntegerProperty(0);
    private int even, odd = 0;
    private int fColum, sColum, tColum = 0;
    private int fRow, sRow, tRow = 0;

    private Random randomNumber;

    private int actualNumber;


    public Roulette() {
        randomNumber = new Random();
        for (int i = 0; i < 37; i++) numbers.put(i, 0);
        listNumbers.set(FXCollections.observableArrayList(arrayNumbers));
    }

    /**
     * Returns the color of the number.
     *
     * @param i number (0 - 37)
     * @return color
     */
    public static String color(int i) {
        if (i == 0) return "Green";
        else if (((i - 1) / 3) % 2 == 0) return "Red";
        else return "Black";
    }

    public int getActualNumber() {
        return actualNumber;
    }

    public int getNumMatches() {
        return numMatches.get();
    }

    public IntegerProperty numMatchesProperty() {
        return numMatches;
    }

    public IntegerProperty greenProperty() {
        return green;
    }

    public IntegerProperty redProperty() {
        return red;
    }

    public IntegerProperty blackProperty() {
        return black;
    }

    public ListProperty<Integer> getLastNumbers() {
        return listNumbers;
    }

    public void spin() {
        actualNumber = randomNumber.nextInt(37);
        savStats(actualNumber);
    }

    private void savStats(int i) {
        Platform.runLater(() -> {
            numMatches.set(numMatches.get() + 1);

            if (i == 0) green.set(green.get() + 1);
            else if (((i - 1) / 3) % 2 == 0) red.set(red.get() + 1);
            else black.set(black.get() + 1);

            if (i != 0) {
                if (i % 2 == 0) even++;
                else odd++;

                if (i < 13) fColum++;
                else if (i < 25 && i > 0) sColum++;
                else tColum++;
            }
            arrayNumbers.add(i);
            if (arrayNumbers.size() < 10) {
                listNumbers.set(FXCollections.observableArrayList(arrayNumbers));
            } else {
                listNumbers.set(FXCollections.observableArrayList(arrayNumbers.subList(arrayNumbers.size() - 10, arrayNumbers.size())));
            }
            numbers.put(i, numbers.get(i) + 1);
        });
    }


}
