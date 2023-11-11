package co.edu.unicauca.asae.proyecto_parcial.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    private int idPersona;
    private Docente objPersona;
    private String direccionResidencia;
    private String ciudad;
    private String pais;
}
