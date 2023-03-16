package com.vti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.model.Student;
import com.vti.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> getAll() {
		return ResponseEntity.ok(studentService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") int id) {
		return ResponseEntity.ok(studentService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Student> addNew(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.save(student));
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Student student) {
		boolean success = studentService.update(student);

		if (success) {
			return ResponseEntity.ok("Update Success.");
		}
		return ResponseEntity.badRequest().body("Update Fail.");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		try {
			studentService.delete(id);
			return ResponseEntity.ok("Delete Success.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Delete Success.");
		}
	}

}
