package demo

import grails.test.mixin.integration.Integration
import spock.lang.Specification
import grails.converters.JSON

@Integration
class MarshallerSpec extends Specification {

    void "test marshalling subclass"() {
        when:
        def sub = new PojoSubclass(firstProperty: "one", secondProperty: "two")

        def json = null
        JSON.use(MyMarshallerRegistrar.MARSHALLER_NAME) {
            json = new JSON(sub).toString()
        }

        then:
        json == '{"first":"one","second":"two","widget":null,"klazz":"demo.PojoSubclass"}'
    }

    void "test marshalling parent pojo"() {
        when:
        def o = new OtherPogo(firstProperty: "one", secondProperty: "two")


        def json = null
        JSON.use(MyMarshallerRegistrar.MARSHALLER_NAME) {
            json = new JSON(o).toString()
        }

        then:
        json == '{"first":"one","second":"two","widget":null,"klazz":"demo.OtherPogo"}'
    }
}
