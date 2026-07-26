package com.upl.upl_tutorial_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_progress")
public class StudentProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_id")
    private Long progressId;


    @Column(name = "student_id", nullable = false)
    private Long studentId;


    @Column(name = "tutorial_id", nullable = false)
    private Long tutorialId;


    @Column(name = "status", nullable = false)
    private String status;


    @Column(name = "completed_at")
    private LocalDateTime completedAt;



    public StudentProgress() {

    }



    public Long getProgressId() {
        return progressId;
    }


    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }



    public Long getStudentId() {
        return studentId;
    }


    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }



    public Long getTutorialId() {
        return tutorialId;
    }


    public void setTutorialId(Long tutorialId) {
        this.tutorialId = tutorialId;
    }



    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }



    public LocalDateTime getCompletedAt() {
        return completedAt;
    }


    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }



    @PrePersist
    public void prePersist() {

        if (completedAt == null) {

            completedAt = LocalDateTime.now();

        }

    }

}