package part1;

import org.junit.Test;
import part1.model.Weather;
import part1.service.DataImporter;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataImporterTest {

    private static final int NUMBER_OF_DAYS = 30;
    private static final String fileName = "weather.dat";
    private DataImporter dataImporter = new DataImporter();

    @Test
    public void shouldImportData() throws URISyntaxException {
        Path weatherData = Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI());
        List<Weather> data = dataImporter.importData(weatherData);
        Weather weather = new Weather();
        weather.setDayNumber(30);
        weather.setMaxTemperature(90);
        weather.setMinTemperature(45);
        assertEquals(NUMBER_OF_DAYS, data.size());
        assertEquals(weather, data.get(29));
    }
}
