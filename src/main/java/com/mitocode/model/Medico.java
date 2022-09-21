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
@Table(name="medicos")
@SQLDelete(sql = "UPDATE medicos SET estado = false WHERE id_medico = ?")
@Where(clause = "estado = true")
public class Medico {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;
	
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;
	
	@Column(name = "dui", nullable = false, length = 9)
	private String dui;
	
	@Column(name = "telefono", nullable = false, length = 8)
	private String telefono;
	
	@Email
	@Size(message = "Email debe hasta 150 caracteres en formato xxxxx@xxxxx.com")
	@Column(name = "email", length = 150)
	private String email;
	
	@Column(name = "estado")
	private Boolean estado;
}