package no.nav.infotrygdmaksdato.model

class PeriodeDTO (var sykemeldtFom: Int,
                  var sykemeldtTom: Int,
                  var sluttDato: Int,
                  var maksDato: Int) {

    override fun toString(): String {
        return javaClass.simpleName + "[fom = " + sykemeldtFom + ", tom = " + sykemeldtTom + "]"
    }
}