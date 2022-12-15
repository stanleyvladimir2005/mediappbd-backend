package com.mitocode.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.EntityModel;
import com.mitocode.model.Medico;
import com.mitocode.model.Paciente;

//Clase auxiliar para crear el HATEOAS nivel 3 a la consulta
@EqualsAndHashCode(callSuper = true)
@Data
public class ConsultaDTO extends EntityModel<Object> {
	private Integer idConsulta;
	private Medico medico;
	private Paciente paciente;
}