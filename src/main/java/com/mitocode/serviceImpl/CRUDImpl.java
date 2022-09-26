package com.mitocode.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.mitocode.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.ICRUD;

public abstract class CRUDImpl<T,ID> implements ICRUD<T, ID> {
	
	protected abstract IGenericRepo<T, ID> getRepo();

	public T registrar(T t){
		return getRepo().save(t);		
	}

	public T modificar(T t){
		return getRepo().save(t);
	}
	
	public List<T> listar(){
		return getRepo().findAll();
	}

	public T listarPorId(ID id) {
		return getRepo().findById(id).orElse(null);
	}
	
	public void eliminar(ID id) { getRepo().deleteById(id);	}
	
	public Page<T> listarPageable(Pageable pageable){
		return getRepo().findAll(pageable);
	}
}