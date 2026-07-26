package com.upl.upl_tutorial_backend.dto;


import java.time.LocalDateTime;


public class StudentLearningHistoryDTO {


    private Integer courseId;

    private String courseName;

    private Long tutorialId;

    private String tutorialTitle;

    private String status;

    private LocalDateTime completedAt;




    public StudentLearningHistoryDTO(){

    }



    public StudentLearningHistoryDTO(

            Integer courseId,
            String courseName,
            Long tutorialId,
            String tutorialTitle,
            String status,
            LocalDateTime completedAt

    ){

        this.courseId = courseId;
        this.courseName = courseName;
        this.tutorialId = tutorialId;
        this.tutorialTitle = tutorialTitle;
        this.status = status;
        this.completedAt = completedAt;

    }





    public Integer getCourseId() {
        return courseId;
    }


    public String getCourseName() {
        return courseName;
    }


    public Long getTutorialId() {
        return tutorialId;
    }


    public String getTutorialTitle() {
        return tutorialTitle;
    }


    public String getStatus() {
        return status;
    }


    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

}