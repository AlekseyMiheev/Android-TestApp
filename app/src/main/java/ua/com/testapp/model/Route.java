package ua.com.testapp.model;

/**
 * Created by Aleksey on 27.06.2017.
 */

public class Route {

    private int number;
    private String firstStation;
    private String lastStation;

    public Route() {
        number = 100;
        firstStation = "first";
        lastStation = "last";
    }

    public Route(int number, String firstStation, String lastStation) {
        this.number = number;
        this.firstStation = firstStation;
        this.lastStation = lastStation;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }

    @Override
    public String toString() {
        return "*" + number +
                "*" + firstStation +
                "*" + lastStation + "*";
    }
}
