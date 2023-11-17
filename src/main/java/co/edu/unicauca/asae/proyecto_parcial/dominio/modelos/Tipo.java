package co.edu.unicauca.asae.proyecto_parcial.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tipo {
    private int idTipo;
    private String nombre;
    private List<Publicacion> publicaciones;
}
