package com.springbootcrudproject.crudprojectdemo.controller;

import com.springbootcrudproject.crudprojectdemo.entity.Student;
import com.springbootcrudproject.crudprojectdemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }


    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

       Student studentCreate = studentService.createSTudent(student);


       return new ResponseEntity<>(studentCreate, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        ResponseEntity<Student> studentResponseEntity = studentService.getStudentById(id)
                .map(student -> ResponseEntity.ok(student))
                .orElseGet(() -> ResponseEntity.notFound().build());
        return studentResponseEntity;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getStudentAll() {

       List<Student> studentresp = studentService.getAllStudent();
       if(studentresp.isEmpty()){

           return ResponseEntity.notFound().build();
       }

        return ResponseEntity.ok(studentresp);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student studentreq=studentService.updateSTudent(id,student);

        if(studentreq==null){

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentreq);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
         boolean delStudent=studentService.deleteStudentById(id);
         if(!delStudent){

             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok("Student is deleted");
    }


    public ResponseEntity<String> softDeleteById(@PathVariable int id){
        boolean issoftdelete=studentService.softDelById(id);
        if(!issoftdelete){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Soft Delete Success");
    }

}




