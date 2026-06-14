package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "specialty")
@SQLDelete(sql = "UPDATE specialty SET status = false WHERE id_specialty = ?")
@Where(clause = "status = true")
public class Specialty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSpecialty;

	@Column(name = "specialty_name", nullable = false, length = 50)
	@Size(min=3, message ="{speciality_name.size}")
	private String specialtyName;

	@Column(name = "status")
	private Boolean status;
}