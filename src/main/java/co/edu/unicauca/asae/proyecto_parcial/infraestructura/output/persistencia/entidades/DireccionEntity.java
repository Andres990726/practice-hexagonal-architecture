package co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Direcciones")
@Getter
@Setter
@NoArgsConstructor
public class DireccionEntity implements Serializable {

    @Id
    @Column(name = "idPersona")
    private int idPersona;
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPersona")
    private DocenteEntity objPersona;
    @Column(nullable = false, length = 30)
    private String direccionResidencia;
    @Column(nullable = false, length = 30)
    private String ciudad;
    @Column(nullable = false, length = 30)
    private String pais;

}
