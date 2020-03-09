package no.nav.infotrygdmaksdato.domene

import java.time.LocalDate

class Periode ( val maksDato: LocalDate,
                val aktivSykemelding: Boolean,
                val fomDato: LocalDate,
                val tomDato: LocalDate,
                val antallDagerTilgode: Int
    ) {
}