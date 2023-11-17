package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.PublicacionEntity;

@Configuration
public class PublicacionMapper {
    @Bean
    @Qualifier("publicacionMapper")
    public ModelMapper crearModelMapper() {
        ModelMapper objMapper = new ModelMapper();
        TypeMap<PublicacionEntity, Publicacion> mapa = objMapper.emptyTypeMap(PublicacionEntity.class,
                Publicacion.class);
        mapa.addMappings(m -> m.skip(Publicacion::setObjTipo)).implicitMappings();
        return objMapper;
    }
}
