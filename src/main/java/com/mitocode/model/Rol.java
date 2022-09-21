package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;

	@Column(name = "nombre", nullable = true, length = 60)
	@Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")
	private String nombre;
}

//$2a$10$gFNHv9w3dLtaug1QTZFyr.G09zRdfjAWO7L.kXylpi7wqdIsTpH4S
