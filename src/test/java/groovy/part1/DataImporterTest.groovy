package groovy.part1

import part1.service.DataImporter
import spock.lang.Specification

import java.nio.file.Path
import java.nio.file.Paths

/**
 * Created by jszybisty on 2/15/2017.
 */
class DataImporterTest extends Specification {

    def "should return 30 days"() {
        given:
        def fileName = "weather.dat"
        def Path weatherData = Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI());
        def dataImporter = new DataImporter();

        when:
        def weathers = dataImporter.importData(weatherData)

        then:
        weathers.size() == 30
    }
}
