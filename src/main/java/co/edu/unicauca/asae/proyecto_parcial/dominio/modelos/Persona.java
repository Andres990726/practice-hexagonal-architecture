package co.edu.unicauca.asae.proyecto_parcial.dominio.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Persona {
    private int idPersona;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;

    public Persona(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}
