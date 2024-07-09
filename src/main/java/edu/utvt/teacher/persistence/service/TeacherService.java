package edu.utvt.teacher.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.teacher.persistence.entities.Teacher;

public interface TeacherService {
	
	public Teacher save(Teacher teacher);
	
	public Teacher update(String id,Teacher teacher);
	
	public List<Teacher> getAll();
	
	public Optional<Teacher> findById(String id);
	
	public ResponseEntity<Teacher> deleteById(String id);	
	
	public Page<Teacher> get(Integer page, Integer size);

}
