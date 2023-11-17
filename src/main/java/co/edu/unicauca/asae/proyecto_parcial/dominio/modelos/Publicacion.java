package co.edu.unicauca.asae.proyecto_parcial.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {
    private int idPublicacion;
    private Tipo objTipo;
    private String titulo;
    private String area;
}
