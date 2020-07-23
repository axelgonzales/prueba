package pe.unac.rrhh.core.coprueba2.service.impl.mapper;

import org.modelmapper.ModelMapper;
import pe.unac.rrhh.core.coprueba2.domain.PersonaEntity;
import pe.unac.rrhh.core.coprueba2.model.PersonaRequest;

public class PersonaDTOToPersonaEntityMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public PersonaEntity personaDTOToPersonaEntityMapper(PersonaRequest personaRequest) {
        return modelMapper.map(personaRequest, PersonaEntity.class);
    }
}