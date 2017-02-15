package part2;

import part2.model.FootballTeam;
import part2.service.DataImporter;
import part2.service.DataResolver;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Jakub on 1/9/2017.
 */
public class KataRunner {
    private static final String fileName = "football.dat";
    private DataImporter dataImporter = new DataImporter();
    private DataResolver dataResolver = new DataResolver();

    public void run(String fileName) throws URISyntaxException {
        Path dataFile = Paths.get(part1.KataRunner.class.getResource(fileName).toURI());
        List<FootballTeam> data = dataImporter.importData(dataFile);
        String result = dataResolver.findTeamWithSmallestDifferenceBetweenGoals(data);
        System.out.println(result);
    }

    public static void main(String[] args) throws URISyntaxException {
        new KataRunner().run("src/data/football.dat");
    }
}
