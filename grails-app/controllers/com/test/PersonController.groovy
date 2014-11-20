package com.test

import org.springframework.security.access.annotation.Secured

/*@Secured(value =["hasRole('ROLE_ADMIN')"])*/
class PersonController {
    static scaffold = true
}
