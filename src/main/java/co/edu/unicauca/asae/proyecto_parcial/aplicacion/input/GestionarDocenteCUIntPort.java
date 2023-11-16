package co.edu.unicauca.asae.proyecto_parcial.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {

    public Docente crear(Docente objDocente);

    public List<Docente> listar();
}
