package com.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.dao.StudentRepository;
import com.student.entity.Student;

@Component
public class StudentServices {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAll() {
		List<Student> findAll = (List<Student>) studentRepository.findAll();
		return findAll;
	}

	public Student getStudent(int id) {
		return studentRepository.getStudentById(id);
	}

	public Student createStudent(Student st) {
		Student save = studentRepository.save(st);
		return save;
	}

	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	public Student updateStudent(int id, Student st) {
		st.setId(id);
		Student update = studentRepository.save(st);
		return update;
	}

}
