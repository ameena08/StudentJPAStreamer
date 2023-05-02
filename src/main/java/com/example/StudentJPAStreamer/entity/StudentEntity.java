package com.example.StudentJPAStreamer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class StudentEntity {
        @Id
        @GeneratedValue
        private long Id;

        private String studentId;
        private String name;
        private String email;
        private String phone;
        private String qualification;

       @ElementCollection
        private List<String> interestedCourse;
        private String address;
        private String comment;


    @ManyToOne(fetch = FetchType.LAZY)
    private InstituteEntity institution;
    }

