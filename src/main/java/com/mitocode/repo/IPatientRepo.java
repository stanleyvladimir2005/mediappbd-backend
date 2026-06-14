package com.mitocode.repo;

import org.springframework.stereotype.Repository;
import com.mitocode.model.Patient;

@Repository
public interface IPatientRepo extends IGenericRepo<Patient, Integer> {
}