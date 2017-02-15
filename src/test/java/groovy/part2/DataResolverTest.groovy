package groovy.part2

import part2.model.FootballTeam
import part2.service.DataResolver
import spock.lang.Specification


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
}
