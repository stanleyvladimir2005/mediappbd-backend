package com.mitocode.serviceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.model.Examen;
import com.mitocode.repo.IExamenRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IExamenService;

@Service
public class ExamenServiceImpl extends CRUDImpl<Examen, Integer> implements IExamenService {

	@Autowired
	private IExamenRepo repo;	

	@Override
	protected IGenericRepo<Examen, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public Examen listarPorId(int idExamen) {
		Optional<Examen> opt = repo.findById(idExamen);
		return opt.orElseGet(Examen::new);
	}
}