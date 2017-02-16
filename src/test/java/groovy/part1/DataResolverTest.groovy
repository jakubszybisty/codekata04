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
        def dataResolver = new DataResolver();

        when:
        def day = dataResolver.findDayWithSmallestTemperatureSpread(weatherList)

        then:
        day == day3.dayNumber
    }

    def "shouldFindDayWithSmallestTemperatureDifferenceFromCustomList"() {
        given:
        def dataResolver = new DataResolver();

        expect:
        day == dataResolver.findDayWithSmallestTemperatureSpread(weathers)

        where:
        weathers | day
        [new Weather(1, 2, 5), new Weather(2, 2, 3), new Weather(3, 0, 7)]                          | weathers[1].dayNumber
        [new Weather(1, 88, 35), new Weather(2, 2, 2), new Weather(2, -1, -2)]                      | weathers[1].dayNumber
        [new Weather(1, 42, 0), new Weather(2, 6346, 5113), new Weather(3, -123123132, 525527)]     | weathers[0].dayNumber
        [new Weather(1, 23, 55), new Weather(2, 23, 33), new Weather(3, 0, 7777)]                   | weathers[1].dayNumber
        [new Weather(1, 534543, 69696), new Weather(2, 266, 6343), new Weather(3, 66, 33)]          | weathers[2].dayNumber
    }
}
