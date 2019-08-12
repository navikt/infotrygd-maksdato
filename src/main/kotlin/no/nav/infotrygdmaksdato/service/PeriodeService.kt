package no.nav.infotrygdmaksdato.service

import no.nav.infotrygdmaksdato.model.PeriodeEntity
import no.nav.infotrygdmaksdato.repository.PeriodeJpaRepository
import org.springframework.stereotype.Service

@Service
class PeriodeService (val periodeRepository: PeriodeJpaRepository) {

    fun hentPerioder(fnr: String) : List<PeriodeEntity> {
        return periodeRepository.findByFnr(fnr)
    }

    override fun toString(): String {
        return javaClass.simpleName + "[periodeRepository = " + periodeRepository + "]"
    }
}