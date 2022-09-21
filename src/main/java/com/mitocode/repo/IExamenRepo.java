package com.mitocode.repo;

import org.springframework.stereotype.Repository;

import com.mitocode.model.Examen;

@Repository
public interface IExamenRepo extends IGenericRepo<Examen, Integer> {
}