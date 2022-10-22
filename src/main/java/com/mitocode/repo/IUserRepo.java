package com.mitocode.repo;

import com.mitocode.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends IGenericRepo<Usuario, Integer>  {
	Usuario findOneByUsername(String username);
}