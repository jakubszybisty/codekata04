package part1.service;

import part1.model.Weather;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataResolver {

    public String findDayWithSmallestTemperatureSpread(List<Weather> data) {
        Map<String, Integer> dayAndTemperatureSpread = new HashMap<>();
        data.forEach(d -> dayAndTemperatureSpread.put(d.getDayNumber(), findDifference(d)));
        Map.Entry<String, Integer> dayWithBiggestTemperatureSpread = dayAndTemperatureSpread.entrySet().stream().min(Map.Entry.comparingByValue(Integer::compareTo)).get();
        return dayWithBiggestTemperatureSpread.getKey();
    }

    private int findDifference(Weather weather) {
        return weather.getMaxTemperature() > weather.getMinTemperature() ? weather.getMaxTemperature() - weather.getMinTemperature() : weather.getMinTemperature() - weather.getMaxTemperature();
    }
}
