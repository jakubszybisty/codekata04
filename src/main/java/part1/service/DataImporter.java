package part1.service;


import part1.model.Weather;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataImporter {

    public List<Weather> importData(Path weatherData) {
        try {
            return Files.readAllLines(weatherData).stream()
                    .map(line -> line.trim().split("(\\s)+"))
                    .filter(row -> row[0].matches("\\d+"))
                    .map(this::parseWeather)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Weather parseWeather(String[] row) {
        Weather weather = new Weather();
        weather.setDayNumber(cleanValue(row[0]));
        weather.setMinTemperature(cleanValue(row[2]));
        weather.setMaxTemperature(cleanValue(row[1]));
        return weather;
    }

    private int cleanValue(String s) {
        return Integer.parseInt(s.replaceAll("[*]", ""));
    }
}
