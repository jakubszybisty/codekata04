package part1.service;


import org.apache.commons.lang3.StringUtils;
import part1.model.Weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataImporter {
    private static final String C_PATH = "C:\\";
    private static final String FILE_REGEX = "\\s+";
    private String line;
    private List<Weather> weatherData = new ArrayList<>();
    public List<Weather> importData(String fileName) {
        int counter = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(C_PATH + fileName));
            while ((line = bufferedReader.readLine()) != null) {
                if (counter >= 3) {
                    String[] data = line.split(FILE_REGEX);
                    addNewWeatherRow(data);
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherData;
    }

    private void addNewWeatherRow(String[] line) {
        checkForTraps(line);
        String numberOfDay = line[1];
        String maxTemperature = line[2];
        String minTemperature = line[3];
        if (StringUtils.isNumeric(numberOfDay) && StringUtils.isNumeric(maxTemperature) && StringUtils.isNumeric(minTemperature)) {
            Weather weather = new Weather();
            weather.setDayNumber(numberOfDay);
            weather.setMaxTemperature(Integer.parseInt(maxTemperature));
            weather.setMinTemperature(Integer.parseInt(minTemperature));
            weatherData.add(weather);
        }
    }

    private void checkForTraps(String[] line) {
        if (line[2].length() == 3) {
            line[2] = line[2].substring(0, 2);
        }
        if (line[3].length() == 3) {
            line[3] = line[3].substring(0, 2);
        }
    }
}
