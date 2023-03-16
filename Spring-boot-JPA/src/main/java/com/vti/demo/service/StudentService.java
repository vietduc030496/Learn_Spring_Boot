package com.vti.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.demo.model.Student;
import com.vti.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

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
	 * @param newStudent
	 * @return
	 */
	@Transactional
	public Student save(@NonNull Student newStudent) {
		return studentRepository.save(newStudent);
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

}
