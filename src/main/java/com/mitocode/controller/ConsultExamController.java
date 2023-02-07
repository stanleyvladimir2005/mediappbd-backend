package com.mitocode.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mitocode.model.ConsultExam;
import com.mitocode.service.IConsultExamService;

@RestController
@RequestMapping("/v1/consult-exams")
public class ConsultExamController {

	@Autowired
	private IConsultExamService service;
	
	@GetMapping(value = "/{idConsult}")
	public ResponseEntity<List<ConsultExam>> listar(@PathVariable("idConsult") Integer idConsult) {
		List<ConsultExam> consultExam = service.getExamsByConsult(idConsult);
		return new ResponseEntity<>(consultExam, HttpStatus.OK);
	}
}