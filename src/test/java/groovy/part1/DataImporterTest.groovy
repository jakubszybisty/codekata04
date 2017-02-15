package groovy.part1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by jszybisty on 2/15/2017.
 */
class DataImporterTest extends Specification {

    @Unroll
    def "it should return 1"() {
        given:
        List<Integer> list = new ArrayList<>()
        when:
        list.add(1)
        then:
        1 == list.get(0)
    }
}
