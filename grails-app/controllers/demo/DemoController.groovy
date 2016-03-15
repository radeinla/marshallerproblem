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

    def generateJson() {
        def generatedJson
        JSON.use(MyMarshallerRegistrar.MARSHALLER_NAME) {
            def pojo = new SomePojo()
            bindData pojo, params
            generatedJson = new JSON(pojo).toString()
        }

        render text: "Generated JSON: ${generatedJson}", contentType: 'text/plain'
    }
}

