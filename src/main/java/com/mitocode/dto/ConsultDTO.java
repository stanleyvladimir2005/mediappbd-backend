package com.mitocode.dto;

import com.mitocode.model.Patient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.EntityModel;
import com.mitocode.model.Medic;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConsultDTO extends EntityModel<Object> {
	private Integer idConsult;
	private Medic medic;
	private Patient patient;
}