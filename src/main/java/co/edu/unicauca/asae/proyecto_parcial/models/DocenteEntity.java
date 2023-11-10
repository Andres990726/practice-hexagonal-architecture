package co.edu.unicauca.asae.proyecto_parcial.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Docentes")
@Getter
@Setter
public class DocenteEntity extends PersonaEntity {
    @Column(nullable = false, length = 30)
    private String correo;
    @Column(nullable = false, length = 30)
    private String vinculacion;
    @Column(nullable = false, length = 30)
    private String departamento;

    @ManyToMany
    @JoinTable(name = "Docentes_Publicaciones", joinColumns = @JoinColumn(name = "idPersona"), inverseJoinColumns = @JoinColumn(name = "idPublicaciones"))
    private List<PublicacionEntity> publicaciones;

    public DocenteEntity() {
        super();
        publicaciones = new ArrayList<PublicacionEntity>();
    }

    public DocenteEntity(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos,
            String correo, String vinculacion, String departamento) {
        super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
        publicaciones = new ArrayList<PublicacionEntity>();
    }

    public void agregarPublicacion(PublicacionEntity publicacion) {
        this.publicaciones.add(publicacion);
    }
}
