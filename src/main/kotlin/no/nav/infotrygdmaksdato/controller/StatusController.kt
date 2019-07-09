package no.nav.infotrygdmaksdato.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class StatusController {
    internal var logger = LoggerFactory.getLogger(StatusController::class.java)

        @RequestMapping(method = [RequestMethod.GET], value = ["/isAlive"])
        fun isAlive() : String {
            this.logger.info("isAlive")
            return "Ok"
        }
}