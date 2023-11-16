package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.DTORespuesta;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDTORespuesta {
    private int idTipo;
    private String nombre;
    private List<PublicacionDTORespuesta> publicaciones;
}
