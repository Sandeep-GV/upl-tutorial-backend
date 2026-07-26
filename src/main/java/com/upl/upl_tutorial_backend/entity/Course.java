package com.upl.upl_tutorial_backend.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;



@Entity
@Table(name = "course_master")
public class Course {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;




    @Column(name = "course_name")
    private String title;




    @Column(name = "description")
    private String description;




    @Column(name = "duration")
    private String duration;




    @Column(name = "level")
    private String level;




    @Column(name = "instructor_id")
    private Integer instructorId;




    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;




    @Column(name = "created_at")
    private LocalDateTime createdAt;





    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Tutorial> tutorials;






    public enum Status {

        ACTIVE,

        INACTIVE

    }







    public Course(){

    }







    @PrePersist
    public void beforeSave(){

        createdAt = LocalDateTime.now();


        if(status == null){

            status = Status.ACTIVE;

        }

    }








    public Integer getCourseId() {

        return courseId;

    }


    public void setCourseId(Integer courseId) {

        this.courseId = courseId;

    }







    public String getTitle() {

        return title;

    }


    public void setTitle(String title) {

        this.title = title;

    }







    public String getDescription() {

        return description;

    }


    public void setDescription(String description) {

        this.description = description;

    }







    public String getDuration() {

        return duration;

    }


    public void setDuration(String duration) {

        this.duration = duration;

    }







    public String getLevel() {

        return level;

    }


    public void setLevel(String level) {

        this.level = level;

    }







    public Integer getInstructorId() {

        return instructorId;

    }


    public void setInstructorId(Integer instructorId) {

        this.instructorId = instructorId;

    }







    public Status getStatus() {

        return status;

    }


    public void setStatus(Status status) {

        this.status = status;

    }







    public LocalDateTime getCreatedAt() {

        return createdAt;

    }


    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;

    }







    public List<Tutorial> getTutorials() {

        return tutorials;

    }


    public void setTutorials(List<Tutorial> tutorials) {

        this.tutorials = tutorials;

    }


}