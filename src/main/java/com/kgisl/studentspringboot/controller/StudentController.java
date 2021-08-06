package com.kgisl.studentspringboot.controller;

import java.util.List;

import com.kgisl.studentspringboot.entity.Student;

import com.kgisl.studentspringboot.service.StudentService;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
* TeamController
*/

@CrossOrigin(origins = "*")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Student>> all() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    
   @PostMapping(value = "/", headers = "Accept=application/json")
   public ResponseEntity<Student> createStudent(@RequestBody Student student) {
       Student actualStudent=studentService.createStudent(student);
       HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(team.getTeamid()).toUri());
       return new ResponseEntity<>(actualStudent,headers,HttpStatus.CREATED);
   }


   @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
       Student student = studentService.findByStudentId(id);
       if (student == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(student, HttpStatus.OK);
   }

   @PutMapping(value = "/{id}", headers="Accept=application/json")
   public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody Student currentStudent)
   {
       Student student=studentService.updateStudent(id,currentStudent);
       return new ResponseEntity<>(student,HttpStatus.OK);
   }

   
   @DeleteMapping(value="/{id}", headers ="Accept=application/json")
   public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id){
       Student student = studentService.findByStudentId(id);
       if (student == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       studentService.deleteStudentById(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
 
    
}
