package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDTO {
    private int idPersona;
    private DocenteDTO objPersona;
    @NotNull(message = "{direccion.residencia.emply}")
    @Size(min = 5, max = 80, message = "{direccion.residencia.size}")
    private String direccionResidencia;
    @NotNull(message = "{direccion.ciudad.emply}")
    @Size(min = 5, max = 35, message = "{direccion.ciudad.size}")
    private String ciudad;
    @NotNull(message = "{direccion.pais.emply}")
    @Size(min = 5, max = 20, message = "{direccion.pais.size}")
    private String pais;
}
