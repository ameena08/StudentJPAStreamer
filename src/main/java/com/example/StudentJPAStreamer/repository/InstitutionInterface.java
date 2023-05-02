package com.example.StudentJPAStreamer.repository;

import com.example.StudentJPAStreamer.entity.InstituteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionInterface extends JpaRepository<InstituteEntity,Long> {
}
