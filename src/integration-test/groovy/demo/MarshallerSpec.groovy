package demo

import grails.core.GrailsApplication
import grails.test.mixin.integration.Integration
import groovyx.net.http.RESTClient
import org.apache.commons.io.IOUtils
import org.springframework.http.HttpStatus
import spock.lang.Specification
import grails.converters.JSON


@Integration
class MarshallerSpec extends Specification {

    GrailsApplication grailsApplication

    void "test marshalling subclass"() {
        when:
        assert grailsApplication != null
        def sub = new PojoSubclass(grailsApplication: grailsApplication)
        
        then:
        new JSON(sub).toString() == '{"first":"one","second":"two","widget":null,"klazz":"demo.SomePojo"}'
    }
}
