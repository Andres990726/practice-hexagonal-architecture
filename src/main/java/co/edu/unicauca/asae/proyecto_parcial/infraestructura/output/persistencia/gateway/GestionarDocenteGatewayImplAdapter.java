package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.GestionarDocenteGatewayInPort;
import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories.DocenteRepository;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayInPort {

    private final DocenteRepository objDocenteRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocenteRepository objDocenteRepository, ModelMapper docenteModelMapper) {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docenteModelMapper;
    }

    @Override
    public boolean existeDocentePorCodigo(String codigo) {
        return this.objDocenteRepository.existeDocentePorIdentificacion(codigo) == 1;
    }

    @Override
    public boolean existeDocentePorCorreo(String correo) {
        return this.objDocenteRepository.existeDocentePorCorreo(correo) == 1;
    }

    @Override
    public Docente guardar(Docente objDocente) {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);
        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        return objDocenteRespuesta;
    }

    @Override
    public List<Docente> listar() {
        Iterable<DocenteEntity> lista = this.objDocenteRepository.findAll();
        List<Docente> listaObtenida = this.docenteModelMapper.map(lista, new TypeToken<List<Docente>>() {
        }.getType());
        return listaObtenida;
    }

}
