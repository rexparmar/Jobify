package com.jobify.Jobify.Model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name= "job_id")
    private Jobs jobId;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users userId;
    private String resume_url;
    private String status;
    private LocalDate appliedOn;
}
