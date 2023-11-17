package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.PublicacionEntity;

public interface PublicacionRepository extends CrudRepository<PublicacionEntity, Integer> {

    @Query("SELECT count(*) FROM PublicacionEntity p  WHERE LOWER(p.titulo) = LOWER(:titulo)")
    Integer existePublicacionPorTitulo(String titulo);

    List<PublicacionEntity> findByTituloContainingIgnoreCaseOrderByIdPublicacionDesc(String patron);
}
