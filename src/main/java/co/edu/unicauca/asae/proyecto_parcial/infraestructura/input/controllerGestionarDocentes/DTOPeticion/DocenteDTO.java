package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.DTOPeticion.PublicacionDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocenteDTO extends PersonaDTO {
    @NotNull(message = "{docente.correo.emply}")
    private String correo;
    @NotNull(message = "{docente.vinculacion.emply}")
    private String vinculacion;
    @NotNull(message = "{docente.departamento.emply}")
    private String departamento;
    private DireccionDTO objDireccion;
    private List<PublicacionDTO> publicaciones;

    public DocenteDTO() {
        super();
        publicaciones = new ArrayList<PublicacionDTO>();
    }

    public DocenteDTO(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos,
            String correo, String vinculacion, String departamento, DireccionDTO objDireccion) {
        super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
        this.objDireccion = objDireccion;
        publicaciones = new ArrayList<PublicacionDTO>();
    }

    public void agregarPublicacion(PublicacionDTO publicacion) {
        this.publicaciones.add(publicacion);
    }
}
