package part1;

import org.junit.Test;
import part1.model.Weather;
import part1.service.DataResolver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataResolverTest {
    private static final String ID_1 = "1";
    private static final String ID_2 = "2";
    private static final String ID_3 = "3";

    private DataResolver dataResolver = new DataResolver();

    @Test
    public void shouldResolveData() {
        List<Weather> weathers = new ArrayList<>();
        weathers.add(new Weather(ID_1, 1, 10));
        weathers.add(new Weather(ID_2, 2, 20));
        weathers.add(new Weather(ID_3, 3, 30));

        String dayWithSmallestTemperatureSpread = dataResolver.findDayWithSmallestTemperatureSpread(weathers);
        assertEquals(ID_1, dayWithSmallestTemperatureSpread);
    }
}
