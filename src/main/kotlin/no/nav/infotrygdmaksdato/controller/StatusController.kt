package no.nav.infotrygdmaksdato.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class StatusController {

        @RequestMapping(method = [RequestMethod.GET], value = ["/isAlive"])
        fun isAlive() : String {
            return "Ok"
        }
}