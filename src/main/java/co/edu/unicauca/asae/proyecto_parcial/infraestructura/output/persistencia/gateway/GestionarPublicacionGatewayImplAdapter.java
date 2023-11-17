package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.GestionarPublicacionGatewayInPort;
import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.PublicacionEntity;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories.DocenteRepository;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories.PublicacionRepository;

@Service
public class GestionarPublicacionGatewayImplAdapter implements GestionarPublicacionGatewayInPort {

    private final PublicacionRepository objPublicacionRepository;
    private final DocenteRepository objDocenteRepository;
    private final ModelMapper publicacionModelMapper;

    public GestionarPublicacionGatewayImplAdapter(PublicacionRepository objPublicacionRepository,
            DocenteRepository objDocenteRepository,
            @Qualifier("publicacionMapper") ModelMapper publicacionModelMapper) {
        this.objPublicacionRepository = objPublicacionRepository;
        this.objDocenteRepository = objDocenteRepository;
        this.publicacionModelMapper = publicacionModelMapper;
    }

    @Override
    public boolean existePublicacionPorTitulo(String titulo) {
        return this.objPublicacionRepository.existePublicacionPorTitulo(titulo) == 1;
    }

    @Override
    public Publicacion guardar(int id, Publicacion objPublicacion) {
        System.out.println(id);
        PublicacionEntity objPublicacionEntity = this.publicacionModelMapper.map(objPublicacion,
                PublicacionEntity.class);
        PublicacionEntity objPublicacionEntityRegistrado = this.objPublicacionRepository.save(objPublicacionEntity);
        DocenteEntity objDocenteEntity = this.objDocenteRepository.findById(id).get();
        objDocenteEntity.agregarPublicacion(objPublicacionEntityRegistrado);
        this.objDocenteRepository.save(objDocenteEntity);
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

    @Override
    public List<Publicacion> listarPorPatron(String patron) {
        Iterable<PublicacionEntity> lista = this.objPublicacionRepository
                .findByTituloContainingIgnoreCaseOrderByIdPublicacionDesc(patron);
        List<Publicacion> listaObtenida = this.publicacionModelMapper.map(lista, new TypeToken<List<Publicacion>>() {
        }.getType());
        return listaObtenida;
    }

}
