package no.nav.infotrygdmaksdato.controller

import no.nav.infotrygdmaksdato.service.PeriodeService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MaksdatoController (val periodeService: PeriodeService){

    internal var logger = LoggerFactory.getLogger(StatusController::class.java)

    @RequestMapping(method = [RequestMethod.GET], value = ["/v1/hentMaksdato"])
    fun hentMaksdato(@RequestParam(name = "fnr", required = true) fnr : String) : String {
        this.logger.info("henter maksdato")
        this.logger.info(fnr)

        var liste = periodeService.hentPerioder(fnr)

        this.logger.info(liste.toString())

        return "Ok"
    }
}