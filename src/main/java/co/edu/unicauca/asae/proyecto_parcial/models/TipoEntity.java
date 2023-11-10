package co.edu.unicauca.asae.proyecto_parcial.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tipos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipo;
    @Column(nullable = false, length = 30)
    private String nombre;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "objTipo")
    private List<PublicacionEntity> publicaciones;
}
