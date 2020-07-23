package pe.unac.rrhh.core.coprueba2.service;

import pe.unac.rrhh.core.coprueba2.domain.PersonaEntity;
import pe.unac.rrhh.core.coprueba2.model.PersonaRequest;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    public List<PersonaEntity> findAllPersonas();

    public Optional<PersonaEntity> findPersonaById(Long id);

    public PersonaEntity savePersona(PersonaRequest personaRequest);

    public PersonaEntity updatePersona(PersonaRequest personaRequest, Long id);

    public void deletePersonaById(Long id);
}
