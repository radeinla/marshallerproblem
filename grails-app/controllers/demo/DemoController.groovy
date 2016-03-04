package demo

import grails.converters.JSON

class DemoController {

    def index() {
        JSON.use(MyMarshallerRegistrar.MARSHALLER_NAME) {
            def pojo = new SomePojo()
            bindData pojo, params
            render pojo as JSON
        }
    }
}
