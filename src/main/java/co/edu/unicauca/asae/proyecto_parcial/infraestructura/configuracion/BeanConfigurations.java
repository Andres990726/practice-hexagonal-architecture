package co.edu.unicauca.asae.proyecto_parcial.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.DocenteFormateadoResultadosIntPort;
import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.GestionarDocenteGatewayInPort;
import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.GestionarPublicacionGatewayInPort;
import co.edu.unicauca.asae.proyecto_parcial.aplicacion.output.PublicacionFormateadoResultadosIntPort;
import co.edu.unicauca.asae.proyecto_parcial.dominio.casosDeUso.GestionarDocenteCUAdapter;
import co.edu.unicauca.asae.proyecto_parcial.dominio.casosDeUso.GestionarPublicacionCUAdapter;

@Configuration
public class BeanConfigurations {

    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
            GestionarDocenteGatewayInPort objDocenteGateway,
            DocenteFormateadoResultadosIntPort objDocenteFormateadoResultados) {
        GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objDocenteGateway,
                objDocenteFormateadoResultados);
        return objGestionarDocenteCU;
    }

    @Bean
    public GestionarPublicacionCUAdapter crearGestionarPublicacionCUInt(
            GestionarPublicacionGatewayInPort objPublicacionGateway,
            PublicacionFormateadoResultadosIntPort objPublicacionFormateadoResultados) {
        GestionarPublicacionCUAdapter objGestionarPublicacionCU = new GestionarPublicacionCUAdapter(
                objPublicacionGateway, objPublicacionFormateadoResultados);
        return objGestionarPublicacionCU;

    }
}
