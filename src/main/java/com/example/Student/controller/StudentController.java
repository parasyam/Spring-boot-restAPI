package com.example.Student.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Student.StudentRepo;
import com.example.Student.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Student.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController 
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("")
    public Student postStudents(@RequestBody Student student) {
        return service.addStudent(student);
    }
   @GetMapping("")
   public List<Student> getStudents() {
       return service.getStudent();
   }
   @GetMapping("/{id}")
   public Student getbyid(@PathVariable  int id) {
       return service.getStudentbyId(id);
   }
  
   @PutMapping("/{id}")
   public Student putMethodName(@PathVariable int id, @RequestBody Student student) {
      return service.UpdateStudent(id, student);
   }

   @DeleteMapping ("/{id}")
   public ResponseEntity<Void> deleteStudent(@PathVariable  int id){
    boolean delete=service.DeleteStudent(id);
    if(!delete)   {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.noContent().build();
    }

   
   
   
   
    
    
    
    
}
