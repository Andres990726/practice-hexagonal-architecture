package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.PublicacionFormateadoResultadosIntPort;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;

@Service
public class PublicacionFomateadorResultadosImplAdapter implements PublicacionFormateadoResultadosIntPort {

    @Override
    public void retornarRespuestaErrorTituloExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

}
