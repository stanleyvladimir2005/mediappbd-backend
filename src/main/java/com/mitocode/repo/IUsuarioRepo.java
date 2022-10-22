package com.mitocode.repo;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.mitocode.model.Usuario;

@Repository
public interface IUsuarioRepo  extends IGenericRepo<Usuario, Integer> {

	public Optional<Usuario> findOneByUsername(String username);
	
	public Boolean existsByUsername(String username);
}