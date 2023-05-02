package com.example.StudentJPAStreamer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InstituteEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String institutionName;
    private String instituteLocation;
    @ElementCollection
    @CollectionTable(name = "course_prices",joinColumns = @JoinColumn(name = "institution_id"))
    @MapKeyColumn(name = "course_name")
    @Column(name = "price")
    private Map<String, Double> coursePrices = new HashMap<>();
}

