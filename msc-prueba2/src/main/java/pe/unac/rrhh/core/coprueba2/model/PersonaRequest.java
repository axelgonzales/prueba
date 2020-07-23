package pe.unac.rrhh.core.coprueba2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaRequest {
    private Long id;
    private String name;
    private String lastname;
}
