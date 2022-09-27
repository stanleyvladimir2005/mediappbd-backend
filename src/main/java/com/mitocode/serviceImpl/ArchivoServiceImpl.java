package com.mitocode.serviceImpl;

import com.mitocode.repo.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Archivo;
import com.mitocode.repo.IArchivoRepo;
import com.mitocode.service.IArchivoService;

@Service
public class ArchivoServiceImpl extends CRUDImpl<Archivo, Integer> implements IArchivoService{

	@Autowired
	private IArchivoRepo repo;

	@Override
	protected IGenericRepo<Archivo, Integer> getRepo(){	return repo;}
}


