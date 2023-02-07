package com.mitocode.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.model.Specialty;
import com.mitocode.repo.ISpecialtyRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ISpecialtyService;

@Service
public class SpecialtyServiceImpl extends CRUDImpl<Specialty,Integer> implements ISpecialtyService {

	@Autowired
	private ISpecialtyRepo repo;
	
	@Override
	protected IGenericRepo<Specialty, Integer> getRepo() {
		return repo;
	}
}