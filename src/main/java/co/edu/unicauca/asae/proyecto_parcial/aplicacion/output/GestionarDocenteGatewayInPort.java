package co.edu.unicauca.asae.proyecto_parcial.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Docente;

public interface GestionarDocenteGatewayInPort {

    public boolean existeDocentePorCodigo(String codigo);

    public boolean existeDocentePorCorreo(String correo);

    public Docente guardar(Docente objDocente);

    public List<Docente> listar();
}
