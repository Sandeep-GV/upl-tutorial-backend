package com.upl.upl_tutorial_backend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

import java.time.LocalDateTime;



@Entity
@Table(name = "tutorial_master")
public class Tutorial {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutorial_id")
    private Long tutorialId;





    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id"
    )
    @JsonBackReference
    private Course course;





    @Column(name = "title")
    private String title;





    @Column(name = "content")
    private String content;





    @Column(name = "youtube_link")
    private String youtubeLink;





    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;





    @Column(name = "created_at")
    private LocalDateTime createdAt;







    public enum Status {

        ACTIVE,

        INACTIVE

    }







    public Tutorial(){

    }








    @PrePersist
    public void beforeSave(){


        createdAt = LocalDateTime.now();


        if(status == null){

            status = Status.ACTIVE;

        }

    }







    @PreUpdate
    public void beforeUpdate(){


        if(status == null){

            status = Status.ACTIVE;

        }

    }








    public Long getTutorialId() {

        return tutorialId;

    }



    public void setTutorialId(Long tutorialId) {

        this.tutorialId = tutorialId;

    }








    public Course getCourse() {

        return course;

    }



    public void setCourse(Course course) {

        this.course = course;

    }








    public String getTitle() {

        return title;

    }



    public void setTitle(String title) {

        this.title = title;

    }








    public String getContent() {

        return content;

    }



    public void setContent(String content) {

        this.content = content;

    }








    public String getYoutubeLink() {

        return youtubeLink;

    }



    public void setYoutubeLink(String youtubeLink) {

        this.youtubeLink = youtubeLink;

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


}