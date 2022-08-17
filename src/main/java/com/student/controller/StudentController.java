package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.services.StudentServices;

@RestController
public class StudentController {

	@Autowired
	private StudentServices studentServices;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAll() {
		List<Student> list = studentServices.getAll();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.of(Optional.of(list));
		}
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		try {
			Student st = studentServices.getStudent(id);
			return ResponseEntity.of(Optional.of(st));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student st) {
		try {
			Student create = studentServices.createStudent(st);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {
		try {
			studentServices.deleteStudent(id);
			System.out.println("Student deleted.");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student s) {
		try {
			Student put = studentServices.updateStudent(id, s);
			return ResponseEntity.status(HttpStatus.OK).body(put);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
}
