package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.PublicacionEntity;

public interface PublicacionRepository extends CrudRepository<PublicacionEntity, Integer> {

}