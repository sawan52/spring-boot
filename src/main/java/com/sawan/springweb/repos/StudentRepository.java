package com.sawan.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawan.springweb.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
