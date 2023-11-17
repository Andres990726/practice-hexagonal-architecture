package co.edu.unicauca.asae.proyecto_parcial.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.DocenteFormateadoResultadosIntPort;
import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.GestionarDocenteGatewayInPort;
import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {

    private final GestionarDocenteGatewayInPort objDocenteGatewayInPort;
    private final DocenteFormateadoResultadosIntPort objDocenteFormateadoResultadosIntPort;

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayInPort objRegistrarDocenteGateway,
            DocenteFormateadoResultadosIntPort objDocenteFormateadoResultados) {
        this.objDocenteGatewayInPort = objRegistrarDocenteGateway;
        this.objDocenteFormateadoResultadosIntPort = objDocenteFormateadoResultados;

    }

    @Override
    public Docente crear(Docente objDocente) {
        Docente objDocenteCreado = null;
        if (this.objDocenteGatewayInPort.existeDocentePorCodigo(objDocente.getNumeroIdentificacion())) {
            this.objDocenteFormateadoResultadosIntPort
                    .retornarRespuestaErrorEntidadExiste(
                            "Error, se encuentra en el sistema un docente con esa identificación");
        } else if (this.objDocenteGatewayInPort.existeDocentePorCorreo(objDocente.getCorreo())) {
            this.objDocenteFormateadoResultadosIntPort.retornarRespuestaErrorCorreoExiste(
                    "Error, se encuents en el sistema un docente con el mismo correo");
        } else {
            objDocenteCreado = this.objDocenteGatewayInPort.guardar(objDocenteCreado);
        }
        return objDocenteCreado;
    }

    @Override
    public List<Docente> listar() {
        List<Docente> listaObtenida = objDocenteGatewayInPort.listar();
        return listaObtenida;
    }

}
