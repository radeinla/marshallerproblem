package demo

import grails.test.mixin.integration.Integration
import groovyx.net.http.RESTClient
import org.springframework.http.HttpStatus
import spock.lang.Specification

@Integration
class MarshallerSpec extends Specification {

    void "test marshaller"() {
        setup:
        def client = new RESTClient('http://localhost:8080/')

        when:
        def response = client.get(path: 'demo/index.json')

        then:
        response.status == HttpStatus.OK.value()
        response.contentType == 'application/json'
        response.data.first == null
        response.data.second == null
        response.data.widget == null

        when:
        response = client.get(path: 'demo/index.json',
                              query: [firstProperty: 'alpha', secondProperty: 'beta'])

        then:
        response.status == HttpStatus.OK.value()
        response.contentType == 'application/json'
        response.data.first == 'alpha'
        response.data.second == 'beta'
        response.data.widget == null
    }
}
