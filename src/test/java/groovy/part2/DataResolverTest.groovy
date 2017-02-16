package groovy.part2

import part2.model.FootballTeam
import part2.service.DataResolver
import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by Jakub on 15.02.2017.
 */
class DataResolverTest extends Specification {

    def "shouldFindTeamWithSmallestDifferenceInGoals"() {
        given:
        def arsenal = new FootballTeam('Arsenal', 10, 100)
        def barcelona = new FootballTeam('Barcelona', 20, 90)
        def liverpool = new FootballTeam('Liverpool', 30, 80)
        def footballTeams = [arsenal, barcelona, liverpool]
        DataResolver dataResolver = new DataResolver();

        when:
        def teamName = dataResolver.findTeamWithSmallestDifferenceBetweenGoals(footballTeams)

        then:
        teamName == liverpool.name
    }

    @Unroll
    def "shouldFindDayWithSmallestTemperatureDifferenceFromCustomList"(List<FootballTeam> teams, String name) {
        given:
        def dataResolver = new DataResolver();

        when:
        def result = dataResolver.findTeamWithSmallestDifferenceBetweenGoals(teams)

        then:
        name == result

        where:

        teams                                                                                                                                        | name
        [new FootballTeam('Barcelona', 20, 23), new FootballTeam('Real', 0, 12142), new FootballTeam('Arsenal', -2, 66)]                             | 'Barcelona'
        [new FootballTeam('Barcelona', 200, 900), new FootballTeam('Arsenal', -10, 10), new FootballTeam('Porto', 1, 525230)]                        | 'Arsenal'
        [new FootballTeam('FC Basil', -4151512, 0), new FootballTeam('Barcelona', 33, 36), new FootballTeam('Real', 1, 2)]                           | 'Real'
        [new FootballTeam('Legia', 747, 747), new FootballTeam('Borrusia', 2352, 9320), new FootballTeam('Bayer', 5685, -98650)]                     | 'Legia'
        [new FootballTeam('Resovia', 0, 0), new FootballTeam('Lech Poznan', 1, 2), new FootballTeam('Stal Rzesozw', 444, 92520)]                     | 'Resovia'
    }
}
