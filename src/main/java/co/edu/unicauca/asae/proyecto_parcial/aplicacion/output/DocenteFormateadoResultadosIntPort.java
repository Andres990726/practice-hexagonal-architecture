package co.edu.unicauca.asae.proyecto_parcial.aplicacion.output;

public interface DocenteFormateadoResultadosIntPort {

    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorCorreoExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);

}
