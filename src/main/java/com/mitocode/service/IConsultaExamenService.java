package com.mitocode.service;

import java.util.List;
import com.mitocode.model.ConsultaExamen;
import org.springframework.data.repository.query.Param;

public interface IConsultaExamenService {

	List<ConsultaExamen> listarExamenesPorConsulta(@Param("idConsulta") Integer idConsulta);
}
