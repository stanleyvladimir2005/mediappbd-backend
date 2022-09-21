package com.mitocode.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen {

	@Id
	private Examen examen;

	@Id
	private Consulta consulta;
}