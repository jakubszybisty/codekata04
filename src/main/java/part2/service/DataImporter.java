package part2.service;

import part2.model.FootballTeam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataImporter {

    public List<FootballTeam> importData(Path soccerData) {
        try {
            return Files.readAllLines(soccerData).stream()
                    .map(line -> line.trim().split("(\\s)+"))
                    .filter(row -> row[0].matches("\\d+\\."))
                    .map(this::parseFootballTeam)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private FootballTeam parseFootballTeam(String[] row) {
        FootballTeam footballTeam = new FootballTeam();
        footballTeam.setName(row[1]);
        footballTeam.setGoalsScored(Integer.parseInt(row[6]));
        footballTeam.setGoalsLost(Integer.parseInt(row[8]));
        return footballTeam;
    }
}


