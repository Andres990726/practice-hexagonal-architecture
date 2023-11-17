package co.edu.unicauca.asae.proyecto_parcial.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.input.GestionarPublicacionCUIntPort;
import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.GestionarPublicacionGatewayInPort;
import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.PublicacionFormateadoResultadosIntPort;
import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Publicacion;

public class GestionarPublicacionCUAdapter implements GestionarPublicacionCUIntPort {

    private final GestionarPublicacionGatewayInPort objGestionarPublicacionGateway;
    private final PublicacionFormateadoResultadosIntPort objPublicacionFormateadoResultados;

    public GestionarPublicacionCUAdapter(GestionarPublicacionGatewayInPort objRegistrarPublicacionGateway,
            PublicacionFormateadoResultadosIntPort objFormateadoResultados) {
        this.objGestionarPublicacionGateway = objRegistrarPublicacionGateway;
        this.objPublicacionFormateadoResultados = objFormateadoResultados;
    }

    @Override
    public Publicacion crear(int id, Publicacion objPublicacion) {
        Publicacion objPublicacionCreado = null;
        if (this.objGestionarPublicacionGateway.existePublicacionPorTitulo(objPublicacion.getTitulo())) {
            this.objPublicacionFormateadoResultados
                    .retornarRespuestaErrorTituloExiste(
                            "Error, se encuentra en el sistema una publicación con ese titulo");
        } else {
            objPublicacionCreado = this.objGestionarPublicacionGateway.guardar(id, objPublicacion);
        }
        return objPublicacionCreado;
    }

    @Override
    public List<Publicacion> listar() {
        List<Publicacion> listaObtenida = objGestionarPublicacionGateway.listar();
        return listaObtenida;
    }

    @Override
    public List<Publicacion> listarPorPatron(String patron) {
        List<Publicacion> listaObtenida = objGestionarPublicacionGateway.listarPorPatron(patron);
        return listaObtenida;
    }

}
