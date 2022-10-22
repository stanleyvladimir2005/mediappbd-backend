package com.mitocode.repo;

import org.springframework.stereotype.Repository;
import com.mitocode.model.Archivo;

@Repository
public interface IArchivoRepo extends IGenericRepo<Archivo, Integer> {
}