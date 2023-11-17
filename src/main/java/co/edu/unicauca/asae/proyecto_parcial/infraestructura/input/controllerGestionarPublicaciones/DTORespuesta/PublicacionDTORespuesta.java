package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTORespuesta {
    private int idPublicacion;
    private TipoDTORespuesta objTipo;
    private String titulo;
    private String area;
    private List<DocenteDTORespuesta> docentes;
}
