package no.nav.infotrygdmaksdato.domene

import java.time.LocalDate

class Periode (private val maksDato: LocalDate,
               private val aktivSykemelding: Boolean,
               private val fomDato: LocalDate,
               private val tomDato: LocalDate,
               private val antallDagerTilgode: Int
    ) {
}