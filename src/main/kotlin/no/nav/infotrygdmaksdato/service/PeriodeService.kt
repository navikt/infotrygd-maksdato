package no.nav.infotrygdmaksdato.service

import no.nav.infotrygdmaksdato.model.PeriodeDTO
import no.nav.infotrygdmaksdato.repository.PeriodeRepository
import org.springframework.stereotype.Service

@Service
class PeriodeService (val periodeRepository: PeriodeRepository) {

    fun hentPerioder(fnr: String) : List<PeriodeDTO> {
        return periodeRepository.hentPerioder(fnr)
    }

    override fun toString(): String {
        return javaClass.simpleName + "[periodeRepository = " + periodeRepository + "]"
    }
}