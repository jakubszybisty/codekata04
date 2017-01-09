package part2;

import org.junit.Test;
import part2.model.FootballTeam;
import part2.service.DataResolver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jakub on 1/9/2017.
 */
public class DataResolverTest {
    private static final String NAME_1 = "name1";
    private static final String NAME_2 = "name2";
    private static final String NAME_3 = "name3";

    private DataResolver dataResolver = new DataResolver();

    @Test
    public void shouldResolveData() {
        List<FootballTeam> footballTeams = new ArrayList<>();
        footballTeams.add(new FootballTeam(NAME_1, 1, 10));
        footballTeams.add(new FootballTeam(NAME_2, 2, 20));
        footballTeams.add(new FootballTeam(NAME_3, 3, 30));

        String teamWithSmallestDifferenceInGoals = dataResolver.findTeamWithSmallestDifferenceBetweenGoals(footballTeams);
        assertEquals(NAME_1, teamWithSmallestDifferenceInGoals);
    }
}
