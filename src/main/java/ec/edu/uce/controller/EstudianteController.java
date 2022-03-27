package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes/")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	// Retornar un string con el nombre de la vista
	@GetMapping("buscar/{idEstudiante}")
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {

		Estudiante estu = this.estudianteService.buscar(idEstudiante);
//		 Estudiante estu=new Estudiante();
//		estu.setId(idEstudiante);
//		estu.setApellido("Jorge");
//		estu.setApellido("Sanchez");

		modelo.addAttribute("estu", estu);
		return "estudiante";
	}

	@GetMapping("todos")
	public String buscarEstudianteTodos(Model modelo) {
		List<Estudiante> listaEstudiantes = this.estudianteService.buscarTodos();

		modelo.addAttribute("estudiantes", listaEstudiantes);
		return "lista";
	}

	// PRESENTAR LA PAGINA DE INGRESO DE DATOS
	@GetMapping("estudianteNuevo")
	public String obtenerPaginaIngresoDatos(Estudiante estudiante) {

		return "estudianteNuevo";
	}

	// Recibe el objeto a ingresar
	@PostMapping("insertar")
	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
		this.estudianteService.insertar(estudiante);
		redirectAttrs.addFlashAttribute("mensaje", "Estudiante Guardado");
		return "redirect:todos";
	}

	// El modelo porque necesito enviarle al HTML
	@GetMapping("estudianteActualiza/{idEstudiante}")
	public String obtenerPaginaActualizarDatos(@PathVariable("idEstudiante") Integer idEstudiante,
			Estudiante estudiante, Model modelo) {
		Estudiante estu = this.estudianteService.buscar(idEstudiante);
		modelo.addAttribute("estu", estu);
		return "estudianteActualiza";
	}

	@PutMapping("actualizar/{idEstudiante}")
	public String actualizarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Estudiante estudiante) {
		estudiante.setId(idEstudiante);
		this.estudianteService.actualizar(estudiante);
//		return "redirect:todos";
		return "index";
	}

	@DeleteMapping("borrar/{idEstudiante}")
	public String eliminarEstudiane(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		this.estudianteService.eliminar(idEstudiante);
		List<Estudiante> listaEstudiantes = this.estudianteService.buscarTodos();

		modelo.addAttribute("estudiantes", listaEstudiantes);
		return "lista";
	}

}
