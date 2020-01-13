package com.richa.jdbctemplate.controller;

import com.richa.jdbctemplate.model.Student;
import com.richa.jdbctemplate.repository.StudentJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    StudentJdbcRepository studentJdbcRepository;

    @PostMapping
    public int addStudent(@RequestBody Student student){
        return studentJdbcRepository.insert(student);
    }

    @GetMapping
    public List<Student> listAll(){
        return studentJdbcRepository.findAll();
    }
    @GetMapping(value = "/{id}")
    public Student oneStudent(@PathVariable long id){
        return studentJdbcRepository.findById(id);
    }
    @PutMapping(value = "/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student){
        return studentJdbcRepository.update(student);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable long id){
        studentJdbcRepository.delete(id);
    }



}
