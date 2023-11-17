package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.DTOPeticion;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO {
    private int idPublicacion;
    private TipoDTO objTipo;
    @NotNull(message = "{publicacion.titulo.emply}")
    @Size(min = 5, max = 100, message = "{publicacion.titulo.size}")
    private String titulo;
    @NotNull(message = "{publicacion.area.emply}")
    @Size(min = 4, max = 20, message = "{publicacion.area.size}")
    private String area;
    private List<DocenteDTO> docentes;
}
