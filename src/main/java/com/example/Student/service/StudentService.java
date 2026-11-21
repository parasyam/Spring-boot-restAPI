package com.example.Student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Student.StudentRepo;
import com.example.Student.model.Student;

@Service 
public class StudentService {
    private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }
    
    public Student addStudent(Student student){
        return repo.save(student);

    }
    public List<Student> getStudent(){
        return repo.findAll();

    }
    public Student getStudentbyId(int id){
        return repo.findById(id).orElse(null);
    }
    public Student UpdateStudent(int id ,Student student){
        Student s= repo.findById(id).orElse(null);
        if(s!=null){
           
            s.setName(student.getName());
            s.setAge(student.getAge());
            s.setCourse(student.getCourse());
            return repo.save(s);
        }
        return null;
    }
    public boolean DeleteStudent(int id){
        Student s= repo.findById(id).orElse(null);
        if(s!=null){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    
}
