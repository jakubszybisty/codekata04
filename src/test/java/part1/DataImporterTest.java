package part1;

import org.junit.Test;
import part1.model.Weather;
import part1.service.DataImporter;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataImporterTest {

    private static final int NUMBER_OF_DAYS = 30;
    private static final String filePath = "weather.dat";
    private DataImporter dataImporter = new DataImporter();

    @Test
    public void shouldImportData() {
        List<Weather> data = dataImporter.importData(filePath);
        Weather weather = new Weather();
        weather.setDayNumber(30);
        weather.setMaxTemperature(90);
        weather.setMinTemperature(45);
        assertEquals(NUMBER_OF_DAYS, data.size());
        assertEquals(weather, data.get(29));
    }
}
