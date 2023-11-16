package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.DocenteFormateadoResultadosIntPort;

@Service
public class DocenteFormateadorResultadosImplAdapter implements DocenteFormateadoResultadosIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retornarRespuestaErrorEntidadExiste'");
    }

    @Override
    public void retornarRespuestaErrorCorreoExiste(String mensaje) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retornarRespuestaErrorCorreoExiste'");
    }

}
