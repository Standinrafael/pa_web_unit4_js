package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteService {

public Paciente buscar(Integer id);
	
	public List<Paciente> buscarTodos();
	
	public void insertar(Paciente paciente);
	
	public void actualizar(Paciente paciente);
	
	public void eliminar(Integer id);
}
