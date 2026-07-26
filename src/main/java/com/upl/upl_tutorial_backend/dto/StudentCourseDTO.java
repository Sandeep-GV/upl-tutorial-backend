package com.upl.upl_tutorial_backend.dto;


import java.time.LocalDateTime;


public class StudentCourseDTO {


    private Integer courseId;

    private String courseName;

    private String description;

    private String duration;

    private String level;

    private String status;

    private LocalDateTime enrolledAt;



    public StudentCourseDTO(){

    }



    public StudentCourseDTO(
            Integer courseId,
            String courseName,
            String description,
            String duration,
            String level,
            String status,
            LocalDateTime enrolledAt
    ){

        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.duration = duration;
        this.level = level;
        this.status = status;
        this.enrolledAt = enrolledAt;

    }



    public Integer getCourseId() {
        return courseId;
    }


    public String getCourseName() {
        return courseName;
    }


    public String getDescription() {
        return description;
    }


    public String getDuration() {
        return duration;
    }


    public String getLevel() {
        return level;
    }


    public String getStatus() {
        return status;
    }


    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

}