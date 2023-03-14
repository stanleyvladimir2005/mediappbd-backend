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
@Table (name = "exam")
@SQLDelete(sql = "UPDATE exam SET status = false WHERE id_exam = ?")
@Where(clause = "status = true")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idExam;
	
	@Column(name="exam_name", nullable= false, length=50)
	@Size(min=3, message="{examen_name.size}")
	private String examName;
	
	@Column(name="description", nullable= false, length=150)
	@Size(min=3, message="{examen_descripcion.size}")
	private String description;
	
	@Column(name = "status")
	private Boolean status;
}