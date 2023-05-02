package com.example.StudentJPAStreamer.controller;


import com.example.StudentJPAStreamer.entity.InstituteEntity;
import com.example.StudentJPAStreamer.entity.StudentEntity;
import com.example.StudentJPAStreamer.service.InstitutionService;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institution")
public class InstituteController {

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private JPAStreamer jpaStreamer;



    @PostMapping("/add")
    public InstituteEntity create(@RequestBody InstituteEntity institute){
        return institutionService.create(institute);
    }

    @GetMapping("/{name}/students")
    public List<StudentEntity> getStudentsByInstitutionName(@PathVariable String institutionName) {
        return institutionService.getStudentsByInstitutionName(institutionName);
//        return jpaStreamer.stream(StudentEntity.class)
//                .filter(student -> student.getInstitution().getInstitutionName().equals(institutionName))
//                .toList();
    }

}
