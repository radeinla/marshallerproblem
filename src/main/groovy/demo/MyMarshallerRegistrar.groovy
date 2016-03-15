package demo

import grails.converters.JSON

import javax.annotation.PostConstruct

class MyMarshallerRegistrar {

    static MARSHALLER_NAME = 'foo'

    @PostConstruct
    void register() {
        JSON.createNamedConfig(MARSHALLER_NAME) {
            it.registerObjectMarshaller(SomePojo) { pojo ->
                [first: pojo.firstProperty, second: pojo.secondProperty, widget: pojo.widget, klazz: pojo.getClass().name]
            }
        }
    }
}
