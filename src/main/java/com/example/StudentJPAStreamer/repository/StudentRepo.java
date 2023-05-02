package com.example.StudentJPAStreamer.repository;

import com.example.StudentJPAStreamer.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,String> {
    List<StudentEntity> findByAddress(String address);
}
