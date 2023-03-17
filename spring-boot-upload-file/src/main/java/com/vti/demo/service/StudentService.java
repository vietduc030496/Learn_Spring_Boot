package com.vti.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.vti.demo.dto.StudentDto;
import com.vti.demo.model.Student;
import com.vti.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	private List<String> imageExtensions = new ArrayList<>() {{
		add("JPEG");
		add("JPG");
		add("PNG");
	}};

	/**
	 * 
	 * Get all current student
	 * 
	 * @return list student
	 */
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	/**
	 * 
	 * Get student by id
	 * 
	 * @param id identify of student
	 * @return student have id or null if not exist
	 */
	public Student findById(Long id) {
		return studentRepository.getReferenceById(id);
	}

	/**
	 * 
	 * Add new student. If id is exist then throw exception
	 * 
	 * @param student
	 * @return
	 * @throws IOException 
	 */
	@Transactional
	public StudentDto save(MultipartFile imageFile, StudentDto dto) throws IOException {
		String fileName = imageFile.getOriginalFilename();
		String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (!imageExtensions.contains(fileExtension.toUpperCase())) {
			throw new IllegalArgumentException("Invalid file.");
		}
		
		Student newStudent = new Student();
		newStudent.setName(dto.getName());
		newStudent.setAge(dto.getAge());
		newStudent.setAddress(dto.getAddress());
		
		newStudent.setAvatar(imageFile.getBytes());
		studentRepository.save(newStudent);
		return dto;
	}

	/**
	 * 
	 * Update student. If id is not exist then throw exception
	 * 
	 * @param student
	 * @return
	 */
	@Transactional
	public boolean update(@NonNull Student student) {
		studentRepository.save(student);
		return true;
	}

	/**
	 * 
	 * Delete student with id
	 * 
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

	/**
	 * 
	 * Check student is exist.
	 * 
	 * @param id
	 * @return true if exist else false
	 */
	public boolean isExist(Long id) {
		return studentRepository.existsById(id);
	}
	
	/**
	 * 
	 * Get avatar by student id
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public byte[] getImageById(Long id) {
		return findById(id).getAvatar();
	}

}
