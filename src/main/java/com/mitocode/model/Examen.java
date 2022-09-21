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
@Table (name = "examen")
@SQLDelete(sql = "UPDATE examen SET estado = false WHERE id_examen = ?")
@Where(clause = "estado = true")
public class Examen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idExamen;
	
	@Column(name="nombre", nullable= false, length=50)
	@Size(min=3, message="El nombre del examen debe contener 3-50 caracteres")
	private String nombre;
	
	@Column(name="descripcion", nullable= false, length=150)
	@Size(min=3, message="El nombre del examen debe contener 3-150 caracteres")
	private String descripcion;
	
	@Column(name = "estado")
	private Boolean estado;
}