package pe.unac.rrhh.core.coprueba2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {

    @Id
    @SequenceGenerator(name = "persona_id_generator", sequenceName = "persona_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "persona_id_generator")
    private Long id;

    @Column(nullable = true)
    @NotEmpty(message = "Text cannot be empty")
    private String name;
    
    @Column(nullable = true)
    @NotEmpty(message = "Text cannot be empty")
    private String lastname;
}
