package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteRepository {

	public Paciente buscar(Integer id);
	
	public List<Paciente> buscarTodos();
	
	public void insertar(Paciente paciente);
	
	public void actualizar(Paciente paciente);
	
	public void eliminar(Integer id);
}
