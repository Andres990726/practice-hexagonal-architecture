package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.GestionarPublicacionGatewayInPort;
import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.PublicacionEntity;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories.PublicacionRepository;

@Service
public class GestionarPublicacionGatewayImplAdapter implements GestionarPublicacionGatewayInPort {

    private final PublicacionRepository objPublicacionRepository;
    private final ModelMapper publicacionModelMapper;

    public GestionarPublicacionGatewayImplAdapter(PublicacionRepository objPublicacionRepository,
            ModelMapper publicacionModelMapper) {
        this.objPublicacionRepository = objPublicacionRepository;
        this.publicacionModelMapper = publicacionModelMapper;
    }

    @Override
    public boolean existePublicacionPorTitulo(String titulo) {
        return this.objPublicacionRepository.existePublicacionPorTitulo(titulo) == 1;
    }

    @Override
    public Publicacion guardar(Publicacion objPublicacion) {
        PublicacionEntity objPublicacionEntity = this.publicacionModelMapper.map(objPublicacion,
                PublicacionEntity.class);
        PublicacionEntity objPublicacionEntityRegistrado = this.objPublicacionRepository.save(objPublicacionEntity);
        Publicacion objPublicacionRespuesta = this.publicacionModelMapper.map(objPublicacionEntityRegistrado,
                Publicacion.class);
        return objPublicacionRespuesta;
    }

    @Override
    public List<Publicacion> listar() {
        Iterable<PublicacionEntity> lista = this.objPublicacionRepository.findAll();
        List<Publicacion> listaObtenida = this.publicacionModelMapper.map(lista, new TypeToken<List<Publicacion>>() {
        }.getType());
        return listaObtenida;
    }

}
