package pe.unac.rrhh.core.coprueba2.repository;

import pe.unac.rrhh.core.coprueba2.domain.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
