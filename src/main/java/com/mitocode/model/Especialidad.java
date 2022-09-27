package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table(name = "especialidad")
@SQLDelete(sql = "UPDATE especialidad SET estado = false WHERE id_especialidad = ?")
@Where(clause = "estado = true")
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidad;
	
	@Column(name = "nombre", nullable = false, length = 50)
	@Size(min=3, message ="{especialidad_name.size}")
	private String nombre;
	
	@Column(name = "estado")
	private Boolean estado;
}