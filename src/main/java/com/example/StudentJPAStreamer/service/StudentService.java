package com.example.StudentJPAStreamer.service;

import com.example.StudentJPAStreamer.entity.StudentEntity;
import com.example.StudentJPAStreamer.repository.StudentRepo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;

    @Autowired
    private JPAStreamer jpaStreamer;

    public StudentEntity add(StudentEntity entity) {
        return repo.save(entity);

    }

    public List<StudentEntity> getAll() {
        return repo.findAll();
    }
    public long count(String interestedCourse) {
        List<StudentEntity> students = jpaStreamer.stream(StudentEntity.class)
                .flatMap(s -> s.getInterestedCourse().stream()
                        .filter(course -> course.equalsIgnoreCase(interestedCourse))
                        .map(course -> s))
                .toList();

        return students.size();
    }

//    public List<StudentEntity> findByLocation(String address) {
//
//            return repo.findByAddress(address);
//        }

    public List<StudentEntity> findByLocation(String address) {
        return repo.findAll().stream()
                .filter(student -> student.getAddress().toLowerCase().contains(address.toLowerCase()))
                .collect(Collectors.toList());
    }



//    public Long count(String interestedCourse) {
//        return jpaStreamer.stream(StudentEntity.class)
//                .flatMap(student -> student.getInterestedCourse().stream())
//                .filter(courses -> interestedCourse.contains(courses))
//                .distinct()
//                .count();
//    }

}


