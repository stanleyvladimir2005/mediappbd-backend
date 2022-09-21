package com.mitocode.dto;

import java.util.List;

import com.mitocode.model.Consulta;
import com.mitocode.model.Examen;

import lombok.Data;

//Clase auxiliar para insertar en la tabla consulta-detalleConsulta-consultaExamen
@Data
public class ConsultaListaExamenDTO {
	private Consulta consulta;
	private List<Examen> listaExamen;
}