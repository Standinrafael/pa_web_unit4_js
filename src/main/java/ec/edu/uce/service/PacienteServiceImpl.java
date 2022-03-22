package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.IPacienteRepository;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepository pacienteRepository;
	
	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepository.buscar(id);
	}

	@Override
	public List<Paciente> buscarTodos() {
		// TODO Auto-generated method stub
		return this.pacienteRepository.buscarTodos();
	}

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepository.insertar(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepository.actualizar(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.pacienteRepository.eliminar(id);
	}

}
