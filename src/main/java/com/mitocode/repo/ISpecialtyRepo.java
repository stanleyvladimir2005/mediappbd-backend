package com.mitocode.repo;

import org.springframework.stereotype.Repository;
import com.mitocode.model.Specialty;

@Repository
public interface ISpecialtyRepo extends IGenericRepo<Specialty, Integer> {
}