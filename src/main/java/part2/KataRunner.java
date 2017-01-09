package part2;

import part2.model.FootballTeam;
import part2.service.DataImporter;
import part2.service.DataResolver;

import java.util.List;

/**
 * Created by Jakub on 1/9/2017.
 */
public class KataRunner {
    private DataImporter dataImporter = new DataImporter();
    private DataResolver dataResolver = new DataResolver();

    public void run(String fileName) {
        List<FootballTeam> data = dataImporter.importData(fileName);
        String result = dataResolver.findTeamWithSmallestDifferenceBetweenGoals(data);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new KataRunner().run("football.dat");
    }
}
