package no.nav.infotrygdmaksdato.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TablesController {
    @GetMapping("/tables")
    fun tables(): Map<String, List<String>> {
        return mapOf(
                "is_periode_10" to listOf(
                        "is10_arbufoer",
                        "is10_arbufoer_tom",
                        "is10_regdat_frisk",
                        "is10_max",
                        "is10_ant_stoenadsdager",
                        "f_nr",
                        "is10_stoenads_type",
                        "is10_frisk"
                )
        )
    }
}