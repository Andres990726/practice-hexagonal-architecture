package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.TipoEntity;

public interface TipoRepository extends CrudRepository<TipoEntity, Integer> {

}
