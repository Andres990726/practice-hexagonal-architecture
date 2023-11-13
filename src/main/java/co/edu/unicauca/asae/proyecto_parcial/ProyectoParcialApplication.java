package co.edu.unicauca.asae.proyecto_parcial;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.DireccionEntity;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.PublicacionEntity;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.entidades.TipoEntity;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories.DireccionRepository;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories.DocenteRepository;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories.PublicacionRepository;
import co.edu.unicauca.asae.proyecto_parcial.infraestructura.output.persistencia.repositories.TipoRepository;

@SpringBootApplication
@Transactional
public class ProyectoParcialApplication implements CommandLineRunner {

	@Autowired
	private DireccionRepository servicioBDDirecciones;

	@Autowired
	private DocenteRepository servicioBDDocentes;

	@Autowired
	private PublicacionRepository servicioBDPublicaciones;

	@Autowired
	private TipoRepository servicioBDTipos;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoParcialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		crearDocente();
		crearAsociarPublicaciones();
		consultarDocentes();
		consultarDirecciones();
		listarPublicaciones();
	}
	
private void crearDocente(){
	DocenteEntity docente = new DocenteEntity();
	docente.setTipoIdentificacion("cedula");
	docente.setNumeroIdentificacion("19012");
	docente.setNombres("Marcela");
	docente.setApellidos("Reyes");
	docente.setCorreo("marce@unicauca.edu.co");
	docente.setDepartamento("fisica");
	docente.setVinculacion("ocasional");
	DireccionEntity direccion = new DireccionEntity();
	direccion.setCiudad("popayan");
	direccion.setPais("colombia");
	direccion.setDireccionResidencia("calle 32");
	direccion.setObjPersona(docente);
	docente.setObjDireccion(direccion);
	servicioBDDocentes.save(docente);

	servicioBDDirecciones.save(direccion);


}

	private void consultarDocentes(){
		Iterable<DocenteEntity> listaDocentes = this.servicioBDDocentes.findAll();
		for (DocenteEntity docente : listaDocentes){
			System.out.println("Id: " + docente.getIdPersona());
			System.out.println("Tipo de identificación: " + docente.getTipoIdentificacion());
			System.out.println("Número de identificación: " + docente.getNumeroIdentificacion());
			System.out.println("Nombres: " + docente.getNombres());
			System.out.println("Apellidos: " + docente.getApellidos());
			System.out.println("Correo: " + docente.getCorreo());
			System.out.println("Departamento: " + docente.getDepartamento());
			System.out.println("Vinculación: " + docente.getVinculacion());
			System.out.println("direccion: " + docente.getObjDireccion().getDireccionResidencia());
			for(PublicacionEntity publicacion: docente.getPublicaciones()){
			System.out.println("--------------------Publicacion docente-----------------");
			System.out.println("id: "+publicacion.getIdPublicacion());
			System.out.println("Titulo: "+publicacion.getTitulo());
			System.out.println("Area: "+publicacion.getArea());
			System.out.println("Tipo: "+publicacion.getObjTipo().getNombre());
			}
			
		}
	}

	private void consultarDirecciones(){
		Iterable<DireccionEntity> listaDirecciones = this.servicioBDDirecciones.findAll();
		for (DireccionEntity direccion : listaDirecciones) {
			System.out.println("Direccion: "+ direccion.getDireccionResidencia());
			System.out.println("Ciudad: "+ direccion.getCiudad());
			System.out.println("Pais: "+ direccion.getPais());
			System.out.println("Docente: "+ direccion.getObjPersona().getNombres() + " "+ direccion.getObjPersona().getApellidos());
		}
	}

	private void listarPublicaciones(){
		Iterable<PublicacionEntity> listaPublicaciones = this.servicioBDPublicaciones.findAll();
		for(PublicacionEntity publicacion: listaPublicaciones){
			System.out.println("id: "+publicacion.getIdPublicacion());
			System.out.println("Titulo: "+publicacion.getTitulo());
			System.out.println("Area: "+publicacion.getArea());
			System.out.println("Tipo: "+publicacion.getObjTipo().getNombre());
		}
	}

	private void crearAsociarPublicaciones(){
		TipoEntity tipo = new TipoEntity();
		tipo.setNombre("cientifica");
		TipoEntity objTipoRecibido = servicioBDTipos.save(tipo);

		PublicacionEntity publicacion1 = new PublicacionEntity();
		publicacion1.setArea("matematicas");
		publicacion1.setObjTipo(objTipoRecibido);
		publicacion1.setTitulo("calculo vectorial");
		PublicacionEntity objPublicacionAgregado = servicioBDPublicaciones.save(publicacion1);

		DocenteEntity docente = new DocenteEntity();
		docente.setTipoIdentificacion("cedula");
		docente.setNumeroIdentificacion("22345");
		docente.setNombres("Carla");
		docente.setApellidos("ramirez");
		docente.setCorreo("carla@unicauca.edu.co");
		docente.setDepartamento("matematica");
		docente.setVinculacion("planta");
		docente.agregarPublicacion(objPublicacionAgregado);
		DireccionEntity direccion = new DireccionEntity();
		direccion.setCiudad("popayan");
		direccion.setPais("colombia");
		direccion.setDireccionResidencia("carrera 34-56");
		direccion.setObjPersona(docente);
		docente.setObjDireccion(direccion);
		servicioBDDocentes.save(docente);
		servicioBDDirecciones.save(direccion);
	}
}
