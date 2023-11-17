package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTO {
    private int idPersona;
    private String tipoIdentificacion;
    @NotNull(message = "{docente.codigo.emply}")
    @Size(min = 5, max = 10, message = "{docente.codigo.size}")
    private String numeroIdentificacion;
    @NotNull(message = "{docente.nombre.emply}")
    @Size(min = 5, max = 45, message = "{docente.nombre.size}")
    private String nombres;
    @NotNull(message = "{docente.apellido.emply}")
    @Size(min = 5, max = 45, message = "{docente.apellido.size}")
    private String apellidos;

    public PersonaDTO(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}
