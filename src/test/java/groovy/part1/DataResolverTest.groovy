package groovy.part1

import part1.model.Weather
import part1.service.DataResolver
import spock.lang.Specification

/**
 * Created by Jakub on 15.02.2017.
 */
class DataResolverTest extends Specification {

    def "shouldFindDayWithSmallestTemperatureDifference"() {
        given:
        def day1 = new Weather(1, 10, 100)
        def day2 = new Weather(2, 20, 90)
        def day3 = new Weather(3, 30, 80)
        def weatherList = [day1, day2, day3]
        DataResolver dataResolver = new DataResolver();

        when:
        def day = dataResolver.findDayWithSmallestTemperatureSpread(weatherList)

        then:
        day == day3.dayNumber
    }
}
