package co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_parcial.aplicacion.input.GestionarPublicacionCUIntPort;
import co.edu.unicauca.asae.proyecto_parcial.dominio.modelos.Publicacion;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.DTOPeticion.PublicacionDTO;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.DTORespuesta.PublicacionDTORespuesta;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.input.controllerGestionarPublicaciones.mappers.PublicacionMapperInfraestructuraDominio;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class PublicacionRestController {

    private final GestionarPublicacionCUIntPort objGestionarPublicacionCUIntPort;
    private final PublicacionMapperInfraestructuraDominio objMapeador;

    @PostMapping("/publicaciones/{id}")
    public ResponseEntity<PublicacionDTORespuesta> create(@PathVariable int id,
            @Valid @RequestBody PublicacionDTO objPublicacion) {

        Publicacion objPublicacionCrear = objMapeador.mapearDePeticionAPublicacion(objPublicacion);
        Publicacion objPublicacionCreada = objGestionarPublicacionCUIntPort.crear(id, objPublicacionCrear);
        ResponseEntity<PublicacionDTORespuesta> objRespuesta = new ResponseEntity<PublicacionDTORespuesta>(
                objMapeador.mapearDePublicacionARespuesta(objPublicacionCreada), HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/publicaciones")
    public ResponseEntity<List<PublicacionDTORespuesta>> listar() {
        ResponseEntity<List<PublicacionDTORespuesta>> objRespuesta = new ResponseEntity<List<PublicacionDTORespuesta>>(
                objMapeador.mapearDePublicacionesARespuesta(this.objGestionarPublicacionCUIntPort.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/publicaciones/titulos")
    public ResponseEntity<List<PublicacionDTORespuesta>> listarPorPatron(@RequestParam String patron) {
        ResponseEntity<List<PublicacionDTORespuesta>> objRespuesta = new ResponseEntity<List<PublicacionDTORespuesta>>(
                objMapeador
                        .mapearDePublicacionesARespuesta(this.objGestionarPublicacionCUIntPort.listarPorPatron(patron)),
                HttpStatus.OK);
        return objRespuesta;
    }
}
