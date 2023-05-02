package com.example.StudentJPAStreamer.service;

import com.example.StudentJPAStreamer.entity.InstituteEntity;
import com.example.StudentJPAStreamer.entity.StudentEntity;
import com.example.StudentJPAStreamer.repository.InstitutionInterface;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionInterface repo;

    @Autowired
    private JPAStreamer jpaStreamer;


    public List<StudentEntity> getStudentsByInstitutionName(String institutionName) {
        return jpaStreamer.stream(StudentEntity.class)
               .filter(student -> student.getInstitution().getInstitutionName().equals(institutionName))
                .toList();
    }

    public InstituteEntity create(InstituteEntity institute) {
        return repo.save(institute);
    }
}
