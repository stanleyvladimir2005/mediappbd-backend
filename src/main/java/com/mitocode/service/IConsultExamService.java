package com.mitocode.service;

import java.util.List;
import com.mitocode.model.ConsultExam;
import org.springframework.data.repository.query.Param;

public interface IConsultExamService {

	List<ConsultExam> getExamsByConsult(@Param("idConsult") Integer idConsult);
}
