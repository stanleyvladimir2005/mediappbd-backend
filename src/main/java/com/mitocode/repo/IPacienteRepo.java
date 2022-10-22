package com.mitocode.repo;

import org.springframework.stereotype.Repository;
import com.mitocode.model.Paciente;

@Repository
public interface IPacienteRepo extends IGenericRepo<Paciente, Integer> {
}