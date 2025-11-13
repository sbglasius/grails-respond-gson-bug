package grails.render.errors.bug

import com.agorapulse.gru.Gru
import com.agorapulse.gru.grails.Grails
import grails.testing.web.controllers.ControllerUnitTest
import grails.web.http.HttpHeaders
import grails.web.mime.MimeType
import spock.lang.AutoCleanup
import spock.lang.Specification

class TestControllerSpec extends Specification implements ControllerUnitTest<TestController> {

    @AutoCleanup
    Gru gru = Gru.create(Grails.create(this)).prepare {
        include UrlMappings
    }

    void "get test json"() {
        when:
        gru.test {
            get('/test/') {
                header(HttpHeaders.ACCEPT, MimeType.JSON.name)
            }
            expect {
                status UNPROCESSABLE_ENTITY
                json 'output.json'
            }
        }
        then:
        gru.verify()
    }
}
