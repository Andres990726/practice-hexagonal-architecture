package co.edu.unicauca.asae.proyecto_parcial.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    private int idPersona;
    private Docente objPersona;
    private String direccionResidencia;
    private String ciudad;
    private String pais;
}
