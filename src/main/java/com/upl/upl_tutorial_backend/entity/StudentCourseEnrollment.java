package com.upl.upl_tutorial_backend.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name="student_course_enrollment")
public class StudentCourseEnrollment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;



    @Column(name="student_id")
    private Long studentId;



    @Column(name="course_id")
    private Integer courseId;



    private String status;



    private LocalDateTime enrolledAt;



    public StudentCourseEnrollment(){

    }



    @PrePersist
    public void beforeSave(){

        enrolledAt = LocalDateTime.now();

        if(status==null){

            status="ACTIVE";

        }

    }



    public Long getEnrollmentId() {
        return enrollmentId;
    }


    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }



    public Long getStudentId() {
        return studentId;
    }


    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }



    public Integer getCourseId() {
        return courseId;
    }


    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }



    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }



    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }


    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

}