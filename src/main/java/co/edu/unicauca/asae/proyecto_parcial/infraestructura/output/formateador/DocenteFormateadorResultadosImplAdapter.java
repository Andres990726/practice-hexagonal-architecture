package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.DocenteFormateadoResultadosIntPort;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;

@Service
public class DocenteFormateadorResultadosImplAdapter implements DocenteFormateadoResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorCorreoExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

}
