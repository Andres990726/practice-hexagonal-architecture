package co.edu.unicauca.asae.proyecto_parcial.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Direcciones")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DireccionEntity implements Serializable{

    @Id
    private int idPersona;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @MapsId("idPersona")
    @JoinColumn(name = "idPersona")
    private DocenteEntity objPersona;
    @Column(nullable = false, length = 30)
    private String direccionResidencia;
    @Column(nullable = false, length = 30)
    private String ciudad;
    @Column(nullable = false, length = 30)
    private String pais;
}
