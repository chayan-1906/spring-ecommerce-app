package com.padmanabhasmac.springecommerceapp.controllers;

import com.padmanabhasmac.springecommerceapp.models.FileModel;
import com.padmanabhasmac.springecommerceapp.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class UploadFileController {

	@Autowired
	private FileService fileService;

	@PostMapping("/upload-file")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
		return new ResponseEntity<> ( fileService.addFile ( file ), HttpStatus.OK );
	}

	@GetMapping("/{fileID}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable String fileID) throws IOException {
		FileModel file = fileService.downloadFile ( fileID );
		System.out.println ( file.getFileID ( ) );

		return ResponseEntity.ok ( )
				.contentType ( MediaType.parseMediaType ( file.getFileType ( ) ) )
				.header ( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename ( ) + "\"" )
				.body ( new ByteArrayResource ( file.getFile ( ) ) );
	}
}
