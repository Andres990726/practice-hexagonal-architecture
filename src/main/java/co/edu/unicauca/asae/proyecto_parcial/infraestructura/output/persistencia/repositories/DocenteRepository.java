package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepository extends CrudRepository<DocenteEntity, Integer> {
    DocenteEntity findByNumeroIdentificacion(String numeroIdentificacion);
}
