package part2;

import org.junit.Test;
import part2.model.FootballTeam;
import part2.service.DataImporter;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataImporterTest {

    private static final int NUMBER_OF_TEAMS = 20;
    private static final String filePath = "football.dat";
    private DataImporter dataImporter = new DataImporter();

    @Test
    public void shouldImportData() {
        List<FootballTeam> data = dataImporter.importData(filePath);
        FootballTeam leicester = new FootballTeam();
        leicester.setName("Leicester");
        leicester.setGoalsScored(30);
        leicester.setGoalsLost(64);
        assertEquals(NUMBER_OF_TEAMS, data.size());
        assertEquals(leicester, data.get(19));
    }

}
