package no.nav.infotrygdmaksdato.domene

import java.time.LocalDate

class Periode ( val versjon: String,
                val maksDato: LocalDate,
                val infotrygdMaksDato: LocalDate,
                val aktivSykemelding: Boolean,
                val fomDato: LocalDate,
                val tomDato: LocalDate,
                val antallDagerTilgode: Int
    ) {
}