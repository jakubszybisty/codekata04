package part1;

import part1.model.Weather;
import part1.service.DataImporter;
import part1.service.DataResolver;

import java.util.List;

/**
 * Created by Jakub on 1/9/2017.
 */
public class KataRunner {

    private DataImporter dataImporter = new DataImporter();
    private DataResolver dataResolver = new DataResolver();

    public void run(String fileName) {
        List<Weather> data = dataImporter.importData(fileName);
        String result = dataResolver.findDayWithSmallestTemperatureSpread(data);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new KataRunner().run("weather.dat");
    }
}


