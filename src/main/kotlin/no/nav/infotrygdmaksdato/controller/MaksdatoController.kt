package no.nav.infotrygdmaksdato.controller

import no.nav.infotrygdmaksdato.domene.Periode
import java.time.LocalDate
import no.nav.infotrygdmaksdato.service.PeriodeService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.format.DateTimeFormatter

@RestController
class MaksdatoController (val periodeService: PeriodeService){

    internal var logger = LoggerFactory.getLogger(StatusController::class.java)

    @RequestMapping(method = [RequestMethod.GET], value = ["/v1/hentMaksdato"])
    fun hentMaksdato(@RequestParam(name = "fnr", required = true) fnr : String) : Periode {
        //Hente perioder fra Oracle...

        var sisteSykemelding = periodeService.hentPerioder(fnr).first()
        this.logger.info(sisteSykemelding.toString())

        var formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        var infotrygdMaksDato = LocalDate.parse(sisteSykemelding.maksDato.toString(), formatter)
        var fomDato = LocalDate.parse(sisteSykemelding.sykemeldtFom.toString(), formatter)
        var tomDato = LocalDate.parse(sisteSykemelding.sykemeldtTom.toString(), formatter)
        var aktivSykemelding = if (tomDato > LocalDate.now()) false else true
        var antallDagerIgjen = 0
        if (aktivSykemelding) {
            antallDagerIgjen = LocalDate.now().datesUntil(infotrygdMaksDato).count().toInt()
        } else {
            antallDagerIgjen = tomDato.datesUntil(infotrygdMaksDato).count().toInt()
        }
        if (tomDato.datesUntil(LocalDate.now()).count() > (26*7)) {
            antallDagerIgjen = sisteSykemelding.maksAntallDager
        }
        var maksDato = LocalDate.now().plusDays(antallDagerIgjen.toLong())

        var resp = Periode(
                versjon = "alpha",
                maksDato = maksDato,
                infotrygdMaksDato = infotrygdMaksDato,
                aktivSykemelding = aktivSykemelding,
                fomDato = fomDato,
                tomDato = tomDato,
                antallDagerTilgode = antallDagerIgjen
        )

        logger.info(resp.toString())

//
//        var tidsperiode = Tidsperiode(LocalDate.parse("2019-03-01"), LocalDate.parse("2019-03-30"))
//        var perioder = mutableListOf<Tidsperiode>()
//        perioder.add(tidsperiode)
//        //


        // Finne Arbkat
        //IS10-ARBKAT
        //ARBEIDSTAKER = 01,
        //SELVSTENDIG_NÆRINGSDRIVENDE = 02
        //FRILANSER = 19
        //IKKE_I_ARBEID = 06


        //Finne alder fra fnr


//        var grunnlagsdata = Grunnlagsdata(LocalDate.now(), LocalDate.now().plusDays(14), 40, ARBEIDSTAKER, perioder)
//        var maksdato = maksdato(grunnlagsdata)

        return resp
    }
}