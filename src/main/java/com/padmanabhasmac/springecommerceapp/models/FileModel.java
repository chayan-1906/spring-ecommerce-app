package com.padmanabhasmac.springecommerceapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "files")
public class FileModel {

	@Id
	private String fileID;

	private String filename;

	private String fileType;

	private String fileSize;

	private byte[] file;
}
