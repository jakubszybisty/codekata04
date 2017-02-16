package groovy.part2

import part2.service.DataImporter
import spock.lang.Specification

import java.nio.file.Path
import java.nio.file.Paths

/**
 * Created by Jakub on 15.02.2017.
 */
class DataImporterTest extends Specification {

    def "should return 20 teams"() {
        given:
        def fileName = "football.dat"
        def Path weatherData = Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI());
        DataImporter dataImporter = new DataImporter();

        when:
        def returnedData = dataImporter.importData(weatherData)

        then:
        returnedData.size() == 20
    }
}
