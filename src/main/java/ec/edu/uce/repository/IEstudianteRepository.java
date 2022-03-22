package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante buscar(Integer id);

	public List<Estudiante> buscarTodos();

	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
}
