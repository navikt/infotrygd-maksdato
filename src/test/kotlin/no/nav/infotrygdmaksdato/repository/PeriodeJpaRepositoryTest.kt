package no.nav.infotrygdmaksdato.repository

import no.nav.infotrygdmaksdato.model.PeriodeEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@TestPropertySource(properties = [
    "spring.jpa.hibernate.ddl-auto=none", // todo: validate
    "spring.datasource.initialization-mode=always",
//    "spring.datasource.schema=classpath:schema-h2.sql",
//    "spring.datasource.data=classpath:data-h2.sql",
    "spring.datasource.platform=h2",
    "spring.datasource.url=jdbc:h2:mem:testdb:MODE=Oracle",
    "spring.jpa.properties.hibernate.default_schema=INFOTRYGD_Q0",
    "spring.jpa.database-platform=org.hibernate.dialect.Oracle10gDialect"
])
class PeriodeJpaRepositoryTest {

    @Autowired
    lateinit var repository: PeriodeJpaRepository

    @Test
    fun findById() {
        val key = PeriodeEntity.PeriodeKey(31280010912345, 79899795)
        val periode = repository.findById(key).get()

        assertThat(periode.key).isEqualTo(key)
        System.err.println(periode)
    }

    @Test
    fun findByFnr() {
        val perioder = repository.findByFnr(31280010912345)
        assertThat(perioder).hasSize(2)
        System.err.println(perioder)
    }
}