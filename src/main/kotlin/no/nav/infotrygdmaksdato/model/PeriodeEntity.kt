package no.nav.infotrygdmaksdato.model

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "IS_PERIODE_10")
data class PeriodeEntity(
        @AttributeOverrides(
                AttributeOverride(name = "personKey", column = Column(name = "IS01_PERSONKEY")),
                AttributeOverride(name = "arbuforSeq", column = Column(name = "IS10_ARBUFOER_SEQ")))
        @EmbeddedId
        val key: PeriodeKey,

        @Column(name = "is10_arbufoer")
        @Convert(converter = NavLocalDateConverter::class)
        val sykemeldtFra: LocalDate,

        @Column(name = "is10_arbufoer_tom")
        @Convert(converter = NavLocalDateConverter::class)
        val sykemeldtTilOgMed: LocalDate,

        @Column(name = "is10_stoenads_type")
        val stonadstype: String, // todo: enum

        @Column(name = "is10_frisk ")
        val frisk: String, // todo: enum

        @Column(name = "F_NR")
        val fnr: String
) {
    @Embeddable
    data class PeriodeKey(val personKey: Long, val arbuforSeq: Long) : Serializable
}