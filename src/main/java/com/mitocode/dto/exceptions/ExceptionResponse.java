package com.mitocode.dto.exceptions;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse {

	private Date timestamp;
	private String mensaje;
	private String detalles;
	
	public ExceptionResponse(Date timestamp, String mensaje, String detalles) {
		super();
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}
}