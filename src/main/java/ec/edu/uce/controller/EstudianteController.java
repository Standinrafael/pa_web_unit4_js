package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	// Retornar un string con el nombre de la vista
	@GetMapping("/buscar/{idEstudiante}")
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {

		Estudiante estu = this.estudianteService.buscar(idEstudiante);
//		 Estudiante estu=new Estudiante();
//		estu.setId(idEstudiante);
//		estu.setApellido("Jorge");
//		estu.setApellido("Sanchez");

		modelo.addAttribute("estu", estu);
		return "estudiante";
	}
	
	@GetMapping("/buscar/todos")
	public String buscarEstudianteTodos(Model modelo) {
		List<Estudiante> listaEstudiantes= this.estudianteService.buscarTodos();
		
		modelo.addAttribute("estudiantes",listaEstudiantes);
		return "lista";
	}
	
	//PRESENTAR LA PAGINA DE INGRESO DE DATOS
	@GetMapping("/estudianteNuevo")
	public String obtenerPaginaIngresoDatos() {
		
		return "estudianteNuevo";
	}
	
	
	//Recibe el objeto a ingresar
	@PostMapping("/insertar")
	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo) {
		this.estudianteService.insertar(estudiante);
		
		
		return "lista";
	}
}
