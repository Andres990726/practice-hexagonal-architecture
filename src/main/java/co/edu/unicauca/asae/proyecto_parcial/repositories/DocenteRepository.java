package co.edu.unicauca.asae.proyecto_parcial.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_parcial.models.DocenteEntity;

public interface DocenteRepository extends CrudRepository<DocenteEntity, Integer>{
    DocenteEntity findByNumeroIdentificacion(String numeroIdentificacion);
}
