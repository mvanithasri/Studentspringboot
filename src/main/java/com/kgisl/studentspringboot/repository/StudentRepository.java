package com.kgisl.studentspringboot.repository;

import com.kgisl.studentspringboot.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;




/**
 * TeamRepository
 */
public interface StudentRepository extends JpaRepository<Student,Long>{

    
}
