package com.mitocode.repo;

import org.springframework.stereotype.Repository;
import com.mitocode.model.Medico;

@Repository
public interface IMedicoRepo extends IGenericRepo<Medico, Integer> {
}