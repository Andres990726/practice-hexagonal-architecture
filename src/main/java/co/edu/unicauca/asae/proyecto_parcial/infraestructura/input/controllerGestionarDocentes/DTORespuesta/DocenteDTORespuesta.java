package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTORespuesta;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.DTORespuesta.PublicacionDTORespuesta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocenteDTORespuesta extends PersonaDTORespuesta {
    private String correo;
    private String vinculacion;
    private String departamento;
    private DireccionDTORespuesta objDireccion;
    private List<PublicacionDTORespuesta> publicaciones;

    public DocenteDTORespuesta() {
        super();
        publicaciones = new ArrayList<PublicacionDTORespuesta>();
    }

    public DocenteDTORespuesta(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos,
            String correo, String vinculacion, String departamento, DireccionDTORespuesta objDireccion) {
        super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
        this.objDireccion = objDireccion;
        publicaciones = new ArrayList<PublicacionDTORespuesta>();
    }

    public void agregarPublicacion(PublicacionDTORespuesta publicacion) {
        this.publicaciones.add(publicacion);
    }
}
