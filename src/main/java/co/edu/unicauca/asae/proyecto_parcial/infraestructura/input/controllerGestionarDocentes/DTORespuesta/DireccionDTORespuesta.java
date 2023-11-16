package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDTORespuesta {
    private int idPersona;
    private DocenteDTORespuesta objPersona;
    private String direccionResidencia;
    private String ciudad;
    private String pais;
}
