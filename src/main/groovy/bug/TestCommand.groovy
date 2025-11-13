package bug

import grails.validation.Validateable

class TestCommand implements Validateable {
    
    String name
    
    static constraints = {
        name nullable: false
    }
    
}
