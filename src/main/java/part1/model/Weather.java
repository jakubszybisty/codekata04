package part1.model;

/**
 * Created by Jakub on 1/9/2017.
 */
public class Weather {

    private int dayNumber;

    private int maxTemperature;

    private int minTemperature;

    public Weather() {

    }

    public Weather(int dayNumber, int minTemperature, int maxTemperature) {
        this.dayNumber = dayNumber;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (dayNumber != weather.dayNumber) return false;
        if (maxTemperature != weather.maxTemperature) return false;
        return minTemperature == weather.minTemperature;

    }

    @Override
    public int hashCode() {
        int result = dayNumber;
        result = 31 * result + maxTemperature;
        result = 31 * result + minTemperature;
        return result;
    }
}
