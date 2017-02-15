package part1;

import part1.model.Weather;
import part1.service.DataImporter;
import part1.service.DataResolver;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Jakub on 1/9/2017.
 */
public class KataRunner {
    private static final String fileName = "weather.dat";
    private DataImporter dataImporter = new DataImporter();
    private DataResolver dataResolver = new DataResolver();

    public void run() throws URISyntaxException {
        Path dataFile = Paths.get(KataRunner.class.getResource(fileName).toURI());
        List<Weather> data = dataImporter.importData(dataFile);
        int result = dataResolver.findDayWithSmallestTemperatureSpread(data);
        System.out.println(result);
    }

    public static void main(String[] args) throws URISyntaxException {
        new KataRunner().run();
    }
}


