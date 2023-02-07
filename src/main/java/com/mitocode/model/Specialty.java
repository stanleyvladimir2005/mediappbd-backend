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
@Table(name = "specialty")
@SQLDelete(sql = "UPDATE specialty SET status = false WHERE id_spelcialty = ?")
@Where(clause = "status = true")
public class Specialty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSpelcialty;
	
	@Column(name = "nombre", nullable = false, length = 50)
	@Size(min=3, message ="{especialidad_name.size}")
	private String spelcialtyName;
	
	@Column(name = "status")
	private Boolean status;
}