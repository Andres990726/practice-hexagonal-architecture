package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.DocenteEntity;

@Configuration
public class DocenteMapper {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        TypeMap<DocenteEntity, Docente> mapa = objMapper.emptyTypeMap(DocenteEntity.class, Docente.class);
        mapa.addMappings(m -> m.skip(Docente::setObjDireccion)).implicitMappings();
        mapa.addMappings(m -> m.skip(Docente::setPublicaciones)).implicitMappings();
        return objMapper;
    }
}
