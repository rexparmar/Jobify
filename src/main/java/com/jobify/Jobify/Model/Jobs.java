package com.jobify.Jobify.Model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String company;
    private String location;
    private double salary;
    @ManyToOne
    @JoinColumn(name = "posted_by")
    private Users postedBy;
    private LocalDate postedAt = LocalDate.now();


}
