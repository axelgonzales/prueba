package pe.unac.rrhh.core.coprueba2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.unac.rrhh.core.coprueba2.constant.Constant;
import pe.unac.rrhh.core.coprueba2.domain.PersonaEntity;
import pe.unac.rrhh.core.coprueba2.exception.ExceptionResponse;
import pe.unac.rrhh.core.coprueba2.model.PersonaRequest;
import pe.unac.rrhh.core.coprueba2.model.PersonaResponse;
import pe.unac.rrhh.core.coprueba2.service.PersonaService;

@RestController
@RequestMapping("v1/persona")
@Api(value = "PersonaController", produces = "application/json", tags = { "Controlador Persona" })
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<PersonaEntity> getAllPersonas() {
        return personaService.findAllPersonas();
    }

    @ApiOperation(value = "Obtiene Persona por ID", tags = { "Controlador Persona" })
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Persona encontrada", response = PersonaEntity.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<PersonaEntity> getPersonaById(@PathVariable Long id) {
        return personaService.findPersonaById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Registra Persona", tags = { "Controlador Persona" })
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Persona registrada", response = PersonaRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<PersonaResponse> createPersona(@RequestBody @Validated PersonaRequest personaRequest) {
        personaService.savePersona(personaRequest);
        return new ResponseEntity<>(new PersonaResponse(Constant.REG_INS_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Actualiza Persona", tags = { "Controlador Persona" })
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Persona actualizada", response = PersonaRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<PersonaResponse> updatePersona(@PathVariable Long id, @RequestBody PersonaRequest personaRequest) throws Exception {
        personaService.updatePersona(personaRequest, id);
        return new ResponseEntity<>(new PersonaResponse(Constant.REG_ACT_ACCEPTED), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Elimina Persona", tags = { "Controlador Persona" })
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Persona eliminada", response = PersonaRequest.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Error en el servidor", response = ExceptionResponse.class)})
    public ResponseEntity<PersonaResponse> deletePersona(@PathVariable Long id) {
        personaService.deletePersonaById(id);
        return new ResponseEntity<>(new PersonaResponse(Constant.REG_ELI_OK), HttpStatus.ACCEPTED);
    }
}
