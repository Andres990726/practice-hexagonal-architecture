package co.edu.unicauca.asae.proyecto_parcial.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Publicacion;

public interface GestionarPublicacionGatewayInPort {
    public boolean existePublicacionPorTitulo(String titulo);

    public Publicacion guardar(int id, Publicacion objPublicacion);

    public List<Publicacion> listar();

    public List<Publicacion> listarPorPatron(String patron);
}
