package com.springbootcrudproject.crudprojectdemo.service;


import com.springbootcrudproject.crudprojectdemo.entity.Student;
import com.springbootcrudproject.crudprojectdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {



    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }



    public Student createSTudent( Student student){
        student.setDelete(false);
        return studentRepository.save(student);


    }


    public Optional<Student> getStudentById(int id) {

        return studentRepository.findById(id);
    }

  public List<Student> getAllStudent(){
     List<Student> studentresp =studentRepository.findAll();

     return studentresp;

  }

  public Student updateSTudent(int id,Student student) {

      Optional<Student> existingStudent = studentRepository.findById(id);

      if (existingStudent.isEmpty()) {
          return null;
      }
      Student studentToSave = existingStudent.get();
      studentToSave.setName(student.getName());
      studentToSave.setAge(student.getAge());
      studentToSave.setCourse(student.getCourse());
      studentToSave.setEmail(student.getEmail());


       return studentRepository.save(studentToSave);
  }



  public Boolean deleteStudentById(int id){

        boolean isPresent= studentRepository.existsById(id);

        if(isPresent){
            studentRepository.deleteById(id);
            return true;
        }
            return false;
  }
 public boolean softDelById(int id){

         Optional<Student> isMark =studentRepository.findById(id);
         if(isMark.isPresent()){
             Student student=isMark.get();

            student.isDelete(true);
             studentRepository.save(student);
            return true;
         }
         return false;
 }

}
