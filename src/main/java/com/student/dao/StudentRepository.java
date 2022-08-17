package com.student.dao;

import org.springframework.data.repository.CrudRepository;

import com.student.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	public Student getStudentById(int id);

}
