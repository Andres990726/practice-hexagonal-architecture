package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Publicaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacion;
    @ManyToOne
    @JoinColumn(name = "idTipo")
    private TipoEntity objTipo;
    @Column(nullable = false, length = 30)
    private String titulo;
    @Column(nullable = false, length = 30)
    private String area;
    @ManyToMany(mappedBy = "publicaciones", fetch = FetchType.LAZY)
    private List<DocenteEntity> docentes;
}
