package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTO;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {

    Docente mapearDePeticionADocente(DocenteDTO peticion);

    DocenteDTORespuesta mapearDeDocenteARespuesta(Docente objDocente);

    List<DocenteDTORespuesta> mapearDeDocentesARespuesta(List<Docente> docentes);
}
