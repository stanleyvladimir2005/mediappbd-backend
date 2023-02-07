package com.mitocode.dto;

import java.util.List;
import com.mitocode.model.Consult;
import com.mitocode.model.Exam;
import lombok.Data;

//Clase auxiliar para insertar en la tabla consult-detalleConsulta-consultaExamen
@Data
public class ConsultListExamDTO {
	private Consult consult;
	private List<Exam> listExam;
}