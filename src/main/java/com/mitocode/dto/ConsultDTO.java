package com.mitocode.dto;

import com.mitocode.model.Patient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.EntityModel;
import com.mitocode.model.Medic;

//Clase auxiliar para crear el HATEOAS nivel 3 a la consulta
@EqualsAndHashCode(callSuper = true)
@Data
public class ConsultDTO extends EntityModel<Object> {
	private Integer idConsulta;
	private Medic medic;
	private Patient patient;
}