package com.mitocode.repo;

import org.springframework.stereotype.Repository;
import com.mitocode.model.Medic;

@Repository
public interface IMedicRepo extends IGenericRepo<Medic, Integer> {
}