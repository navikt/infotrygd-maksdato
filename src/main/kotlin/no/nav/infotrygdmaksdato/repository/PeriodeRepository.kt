package no.nav.infotrygdmaksdato.repository

import no.nav.infotrygdmaksdato.model.PeriodeDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.util.stream.Collectors

@Repository
class PeriodeRepository {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    fun PeriodeRepository(jdbcTemplate: JdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate
    }

    fun hentPerioder(fnr: String): List<PeriodeDTO> {

        var sql = "select "

        sql += "   is10_arbufoer "           // sykmeldtfom
        sql += " , is10_arbufoer_tom "       // sykmeldttom
        sql += " , is10_slutt "              // friskmeldt dato
        sql += " , is10_max "                // maksdato
        sql += " from is_periode_10 "
        sql += " where f_nr = '$fnr'"
        sql += " and is10_stoenads_type = '  '"
        sql += " and is10_frisk != 'H'"
        sql += "  order by is10_arbufoer desc"

        val periodeDTOList = jdbcTemplate.query(sql, arrayOf()
        ) { rs, rowNum ->
            PeriodeDTO(
                    rs.getInt("is10_arbufoer"),
                    rs.getInt("is10_arbufoer_tom"),
                    rs.getInt("is10_slutt"),
                    rs.getInt("is10_max")
            )
        }.stream().collect(Collectors.toList())

        return periodeDTOList
    }
}