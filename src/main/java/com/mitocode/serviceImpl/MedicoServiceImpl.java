package com.mitocode.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Medico;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IMedicoRepo;
import com.mitocode.service.IMedicoService;

@Service
public class MedicoServiceImpl extends CRUDImpl<Medico, Integer>implements IMedicoService{

	@Autowired
	private IMedicoRepo repo;

	@Override
	protected IGenericRepo<Medico, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public Medico listarPorId(int idMedico) {
		Optional<Medico> opt = repo.findById(idMedico);
		return opt.orElseGet(Medico::new);
	}
}