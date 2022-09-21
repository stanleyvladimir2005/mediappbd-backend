package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table(name ="paciente")
@SQLDelete(sql = "UPDATE paciente SET estado = false WHERE id_paciente = ?")
@Where(clause = "estado = true")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "nombres", nullable = true, length = 70)
	private String nombres;

	@Size(min = 3, message = "Apellidos debe tener minimo 3 caracteres")
	@Column(name = "apellidos", nullable = true, length = 70)
	private String apellidos;

	@Size(min = 9, max = 9, message = "DNI debe tener 9 caracteres")
	@Column(name = "dui", nullable = false, length = 9)
	private String dui;

	@Size(min = 3, max = 150, message = "Direccion debe tener minimo 3 caracteres")
	@Column(name = "direccion", length = 150)
	private String direccion;

	@Size(min = 8, max = 8, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", length = 8)
	private String telefono;
	
	@Email
	@Size(message = "Email debe hasta 150 caracteres en formato xxxxx@xxxxx.com")
	@Column(name = "email", length = 150)
	private String email;
	
	@Column(name = "estado")
	private Boolean estado;
}