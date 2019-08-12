package no.nav.infotrygdmaksdato.repository

import no.nav.infotrygdmaksdato.model.PeriodeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PeriodeJpaRepository : JpaRepository<PeriodeEntity, PeriodeEntity.PeriodeKey> {
    fun findByFnr(fnr: String): List<PeriodeEntity>
}