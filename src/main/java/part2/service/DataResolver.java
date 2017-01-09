package part2.service;

import part2.model.FootballTeam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataResolver {
    public String findTeamWithSmallestDifferenceBetweenGoals(List<FootballTeam> data) {
        Map<String, Integer> nameAndDifference = new HashMap<>();
        data.forEach(d -> nameAndDifference.put(d.getName(), findDifference(d)));
        Map.Entry<String, Integer> teamWithSmallestDifference = nameAndDifference.entrySet().stream().min(Map.Entry.comparingByValue(Integer::compareTo)).get();
        return teamWithSmallestDifference.getKey();
    }

    private int findDifference(FootballTeam team) {
        return team.getGoalsScored() > team.getGoalsLost() ? team.getGoalsScored() - team.getGoalsLost() : team.getGoalsLost() - team.getGoalsScored();
    }

}
