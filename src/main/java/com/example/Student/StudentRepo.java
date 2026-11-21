package com.example.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.Student.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
    
}
