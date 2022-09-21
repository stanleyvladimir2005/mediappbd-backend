package com.mitocode.serviceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.model.Paciente;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IPacienteRepo;
import com.mitocode.service.IPacienteService;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {

	@Autowired
	private IPacienteRepo repo;

	@Override
	protected IGenericRepo<Paciente, Integer> getRepo() {
		return repo;
	}	
	
	@Override
	public Paciente listarPorId(int idPaciente) {
		Optional<Paciente> opt = repo.findById(idPaciente);
		return opt.orElseGet(Paciente::new);  //opt.isPresent() ? opt.get() : new Paciente();
	}
}