package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.PublicacionFormateadoResultadosIntPort;

@Service
public class PublicacionFormateadorResultadosImplAdapter implements PublicacionFormateadoResultadosIntPort {

    @Override
    public void retornarRespuestaErrorTituloExiste(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retornarRespuestaErrorTituloExiste'");
    }

}
