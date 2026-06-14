package com.mitocode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "media_file")
public class MediaFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFile;
	private String fileName;
	private String fileType;
	private byte[] value;
}