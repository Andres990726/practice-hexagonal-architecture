package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTO {
    private int idTipo;
    private String titulo;
    private String area;
    private String numeroIdentificacion;
}
