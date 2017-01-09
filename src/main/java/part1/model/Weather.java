package part1.model;

/**
 * Created by Jakub on 1/9/2017.
 */
public class Weather {

    private String dayNumber;

    private int maxTemperature;

    private int minTemperature;

    public Weather() {

    }

    public Weather(String dayNumber, int minTemperature, int maxTemperature) {
        this.dayNumber = dayNumber;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public String getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(String dayNumber) {
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

        if (maxTemperature != weather.maxTemperature) return false;
        if (minTemperature != weather.minTemperature) return false;
        return dayNumber != null ? dayNumber.equals(weather.dayNumber) : weather.dayNumber == null;

    }

    @Override
    public int hashCode() {
        int result = dayNumber != null ? dayNumber.hashCode() : 0;
        result = 31 * result + maxTemperature;
        result = 31 * result + minTemperature;
        return result;
    }
}
