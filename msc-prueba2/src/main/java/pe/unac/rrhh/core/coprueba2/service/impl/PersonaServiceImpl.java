package pe.unac.rrhh.core.coprueba2.service.impl;

import pe.unac.rrhh.core.coprueba2.domain.PersonaEntity;
import pe.unac.rrhh.core.coprueba2.repository.PersonaRepository;
import pe.unac.rrhh.core.coprueba2.model.PersonaRequest;
import pe.unac.rrhh.core.coprueba2.service.impl.mapper.PersonaDTOToPersonaEntityMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.unac.rrhh.core.coprueba2.service.PersonaService;
import pe.unac.rrhh.core.coprueba2.exception.ModelNotFoundException;
import pe.unac.rrhh.core.coprueba2.constant.Constant;


import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private PersonaDTOToPersonaEntityMapper personaDTOToPersonaEntityMapper = new PersonaDTOToPersonaEntityMapper();


    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<PersonaEntity> findAllPersonas() {

        List<PersonaEntity> listPersona = personaRepository.findAll();

        log.info("GET ALL Persona MESSAGE TEST" + "-" );
        return listPersona;
    }

    public Optional<PersonaEntity> findPersonaById(Long id) {

        Optional<PersonaEntity> optionalPersona = personaRepository.findById(id);

        log.info("GET Persona/ MESSAGE TEST" + "-"  );
        
        return optionalPersona;
    }

    public PersonaEntity savePersona(PersonaRequest personaRequest) {

        PersonaEntity personaEntity = personaRepository.save(personaDTOToPersonaEntityMapper.personaDTOToPersonaEntityMapper(personaRequest));

        log.info("POST Persona MESSAGE TEST" + "-"  );
        
        return personaEntity;
    }

    public PersonaEntity updatePersona(PersonaRequest personaRequest, Long id) {



        return personaRepository.findById(id).map(personaRequestObje -> {
            personaRequest.setId(id);
            PersonaEntity persona = personaRepository.save(personaDTOToPersonaEntityMapper.personaDTOToPersonaEntityMapper(personaRequest));
            log.info("UPDATE Persona MESSAGE TEST" + "-"  );
            
        return persona;

        })
        .orElseThrow(() -> new ModelNotFoundException(Constant.PERSONA_NOT_FOUND));
    }

    public void deletePersonaById(Long id) {

        personaRepository.findById(id).ifPresent(delete -> personaRepository.deleteById(id));

        log.info("DELETE Persona/ MESSAGE TEST" + "-"  );
        
    }
}