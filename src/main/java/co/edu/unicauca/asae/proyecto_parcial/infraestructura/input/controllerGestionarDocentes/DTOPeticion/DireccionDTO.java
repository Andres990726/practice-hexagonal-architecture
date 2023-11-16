package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTOPeticion;

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
    private String direccionResidencia;
    private String ciudad;
    private String pais;
}
