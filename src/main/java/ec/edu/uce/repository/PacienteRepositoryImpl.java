package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import ec.edu.uce.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public List<Paciente> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myQuery=this.entityManager.createQuery(" SELECT p from Paciente p", Paciente.class);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Paciente pacienteEliminar=this.buscar(id);
		this.entityManager.remove(pacienteEliminar);
	}

}
