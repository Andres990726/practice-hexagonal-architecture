package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTO {
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String correo;
    private String vinculacion;
    private String departamento;
    private String direccionResidencia;
    private String ciudad;
    private String pais;
}
