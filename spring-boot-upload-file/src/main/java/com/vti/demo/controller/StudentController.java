package com.vti.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vti.demo.dto.StudentDto;
import com.vti.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public @ResponseBody ResponseEntity<StudentDto> storeAd(@RequestPart("student") StudentDto student,
			@RequestPart("image") MultipartFile imageFile) throws IOException {
		try {
			return ResponseEntity.ok(studentService.save(imageFile, student));
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/{id}/image")
	public ResponseEntity<Object> download(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG)
				.body(studentService.getImageById(id));
	}

}
