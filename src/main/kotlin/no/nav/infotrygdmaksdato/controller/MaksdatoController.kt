package no.nav.infotrygdmaksdato.controller

import no.nav.helse.Grunnlagsdata
import no.nav.helse.MaksdatoResult
import no.nav.helse.Tidsperiode
import no.nav.helse.maksdato
import no.nav.helse.Yrkesstatus.*
import java.time.LocalDate
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
    fun hentMaksdato(@RequestParam(name = "fnr", required = true) fnr : String) : MaksdatoResult {
        //Hente perioder fra Oracle...
        var tidsperiode = Tidsperiode(LocalDate.parse("2019-03-01"), LocalDate.parse("2019-03-30"))
        var perioder = mutableListOf<Tidsperiode>()
        perioder.add(tidsperiode)
        //


        // Finne Arbkat
        //IS10-ARBKAT
        //ARBEIDSTAKER = 01,
        //SELVSTENDIG_NÆRINGSDRIVENDE = 02
        //FRILANSER = 19
        //IKKE_I_ARBEID = 06


        //Finne alder fra fnr


        var grunnlagsdata = Grunnlagsdata(LocalDate.now(), LocalDate.now().plusDays(14), 40, ARBEIDSTAKER, perioder)
        var maksdato = maksdato(grunnlagsdata)

        return maksdato
    }
}