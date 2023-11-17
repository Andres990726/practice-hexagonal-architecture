package co.edu.unicauca.asae.proyecto_parcial.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {
    private int idPublicacion;
    private Tipo objTipo;
    private String titulo;
    private String area;
    private List<Docente> docentes;
}
