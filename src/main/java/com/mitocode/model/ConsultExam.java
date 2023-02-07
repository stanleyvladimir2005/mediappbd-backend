package com.mitocode.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.Data;

@Data
@Entity
@IdClass(ConsultExamPK.class)
public class ConsultExam {

	@Id
	private Exam exam;

	@Id
	private Consult consult;
}