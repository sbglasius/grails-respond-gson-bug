package grails.render.errors.bug

import bug.TestCommand
import org.springframework.http.HttpStatus

class TestController {

    def get(TestCommand command) { 
        if(command.hasErrors()) {
            respond(command.errors, status: HttpStatus.UNPROCESSABLE_ENTITY)
        } else {
            respond(command)
        }
    }
    
}
