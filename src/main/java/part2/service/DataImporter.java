package part2.service;

import part2.model.FootballTeam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataImporter {
    private static final String FILE_REGEX = "\\s+";
    private String line;
    private List<FootballTeam> footballTeams = new ArrayList<>();

    public List<FootballTeam> importData(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(classLoader.getResource(fileName).getFile())));
            String firstLine = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(FILE_REGEX);
                if (data[1].length() > 13) {
                    continue;
                }
                addNewFootballTeam(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return footballTeams;
    }

    private void addNewFootballTeam(String[] data) {
        String teamName = data[2];
        FootballTeam footballTeam = new FootballTeam();
        footballTeam.setName(teamName);
        footballTeam.setGoalsScored(Integer.parseInt(data[7]));
        footballTeam.setGoalsLost(Integer.parseInt(data[9]));
        footballTeams.add(footballTeam);
    }
}


