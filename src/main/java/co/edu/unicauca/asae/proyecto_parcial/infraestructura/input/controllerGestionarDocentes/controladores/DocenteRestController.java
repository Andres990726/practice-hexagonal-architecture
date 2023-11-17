package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Docente;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTO;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class DocenteRestController {

    private final GestionarDocenteCUIntPort objGestionarDocenteCUIntPort;
    private final DocenteMapperInfraestructuraDominio objMapeador;

    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTORespuesta> create(@Valid @RequestBody DocenteDTO objDocente) {

        Docente objDocenteCrear = objMapeador.mapearDePeticionADocente(objDocente);
        Docente objDocenteCreado = objGestionarDocenteCUIntPort.crear(objDocenteCrear);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapeador.mapearDeDocenteARespuesta(objDocenteCreado), HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTORespuesta>> listar() {
        ResponseEntity<List<DocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<DocenteDTORespuesta>>(
                objMapeador.mapearDeDocentesARespuesta(this.objGestionarDocenteCUIntPort.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }
}
