package com.example.StudentJPAStreamer.controller;

import com.example.StudentJPAStreamer.entity.StudentEntity;
import com.example.StudentJPAStreamer.service.StudentService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @Autowired
    private JPAStreamer jpaStreamer;

    @PostMapping("/hello")
    public StudentEntity add(@RequestBody StudentEntity entity){
        return studentService.add(entity);
    }


    @GetMapping("/all")
    public List<StudentEntity> getAll(){
        return studentService.getAll();
    }
    @GetMapping("/get/{interestedCourse}")
    public long count(@PathVariable String interestedCourse){
        return studentService.count(interestedCourse);
    }

    @GetMapping("/location/{address}")
    public List<StudentEntity> findByLocation(@PathVariable String address) {
        return studentService.findByLocation(address);
    }

}
