package com.springbootcrudproject.crudprojectdemo.repository;


import com.springbootcrudproject.crudprojectdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

//    private Student student;
//
//    public StudentRepository (Student student){
//      this.student=student;
//
    ////    }
//    public void saveStudent( Student student){
//
//        System.out.println("initaited studentRepository");
//        System.out.println("Saving student: " + student.getName());
//        System.out.println("existing student repository");
//
//    }

    List<Student> findByIsDeleteFalse();

    // Spring Data JPA parses this as: id AND isDelete = false
    Optional<Student> findByIdAndIsDeleteFalse(Integer id);

}
