package com.mitocode.dto;

import lombok.Data;

@Data
public class JwtAuthResponseDTO {
	private String tokenDeAcceso;
	private String tipoDeToken = "Bearer";
	
	public JwtAuthResponseDTO(String tokenDeAcceso) {
		super();
		this.tokenDeAcceso = tokenDeAcceso;
	}
}