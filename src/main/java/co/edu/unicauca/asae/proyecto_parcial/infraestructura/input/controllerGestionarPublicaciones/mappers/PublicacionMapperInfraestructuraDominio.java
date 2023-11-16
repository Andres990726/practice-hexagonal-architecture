package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.DTOPeticion.PublicacionDTO;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.DTORespuesta.PublicacionDTORespuesta;

@Mapper(componentModel = "spring")
public interface PublicacionMapperInfraestructuraDominio {

    Publicacion mapearDePeticionAPublicacion(PublicacionDTO peticion);

    PublicacionDTORespuesta mapearDePublicacionARespuesta(Publicacion objPublicacion);

    List<PublicacionDTORespuesta> mapearDePublicacionesARespuesta(List<Publicacion> publicaciones);
}
