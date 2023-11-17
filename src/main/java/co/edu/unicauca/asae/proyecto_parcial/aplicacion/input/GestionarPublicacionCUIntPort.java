package co.edu.unicauca.asae.proyecto_parcial.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Publicacion;

public interface GestionarPublicacionCUIntPort {

    public Publicacion crear(Publicacion objPublicacion);

    public List<Publicacion> listar();

    public List<Publicacion> listarPorPatron(String patron);

}
