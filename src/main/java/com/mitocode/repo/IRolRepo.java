package com.mitocode.repo;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.mitocode.model.Rol;

@Repository
public interface IRolRepo extends IGenericRepo<Rol, Integer> {
	
	public Optional<Rol> findByName(String name);
}