package com.vti.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.vti.demo.exception.StudentNotFoundException;
import com.vti.demo.model.Student;

@Service
public class StudentService {

	private Map<Integer, Student> map = new HashMap<>();

	public StudentService() {
		for (int i = 1; i <= 10; i++) {
			Student student = new Student(i, "student" + i, 27, "Ha Noi, Viet Nam");
			map.put(i, student);
		}
	}

	/**
	 * 
	 * Get all current student
	 * 
	 * @return list student
	 */
	public List<Student> findAll() {
		return new ArrayList<Student>(map.values());
	}

	/**
	 * 
	 * Get student by id
	 * 
	 * @param id identify of student
	 * @return student have id or null if not exist
	 */
	public Student findById(int id) {
		Student student = map.get(id);
		if (student == null) {
			throw new StudentNotFoundException("Student with id: " + id + " not found.");
		}
		return student;
	}

	/**
	 * 
	 * Add new student. If id is exist then throw exception
	 * 
	 * @param newStudent
	 * @return
	 */
	public Student save(@NonNull Student newStudent) {
		if (isExist(newStudent.getId())) {
			throw new IllegalArgumentException("Id is exist.");
		}
		map.put(newStudent.getId(), newStudent);
		return newStudent;
	}

	/**
	 * 
	 * Update student. If id is not exist then throw exception
	 * 
	 * @param student
	 * @return
	 */
	public boolean update(@NonNull Student student) {
		if (!isExist(student.getId())) {
			throw new StudentNotFoundException("Id is not exist.");
		}
		map.put(student.getId(), student);
		return true;
	}

	/**
	 * 
	 * Delete student with id
	 * 
	 * @param id
	 */
	public void delete(int id) {
		map.remove(id);
	}

	/**
	 * 
	 * Check student is exist.
	 * 
	 * @param id
	 * @return true if exist else false
	 */
	public boolean isExist(int id) {
		return map.get(id) != null;
	}

}
